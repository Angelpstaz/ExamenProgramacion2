/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| dilan.calvache@epn.edu.ec  Msetoo      |
|----------------------------------------|
Autor : Mateo Calvache
Fecha : 29.02.2k24
*/

package UserInterface.Form;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.net.URL;

public abstract class SplashAntBot {
    private static JFrame frmSplash;
    private static JProgressBar prbLoading;
    private static ImageIcon icoImagen;
    private static JLabel lblSplash;
    private static Timer progressTimer;
    private static final int DELAY = 50; // Retraso del Timer en milisegundos

    /*
     * Método principal para mostrar la ventana de carga del Splash.
     */
    public static void show() {
        URL imageURL = SplashAntBot.class.getResource("/UserInterface/Resource/Img/SplashAntBot.png");
        if (imageURL != null) {
            icoImagen = new ImageIcon(imageURL);
        } else {
            // Asegúrate de manejar el caso donde la imagen no se encuentra
            System.err.println("El recurso de la imagen no se encontró.");
            return;
        }

        lblSplash = new JLabel(icoImagen);

        prbLoading = new JProgressBar(0, 100);
        prbLoading.setStringPainted(true);

        frmSplash = new JFrame("Splash Screen");
        frmSplash.setUndecorated(true);
        frmSplash.getContentPane().add(lblSplash, BorderLayout.CENTER);
        frmSplash.add(prbLoading, BorderLayout.SOUTH);
        frmSplash.setSize(icoImagen.getIconWidth(), icoImagen.getIconHeight() + prbLoading.getPreferredSize().height);
        frmSplash.setLocationRelativeTo(null);

        frmSplash.setVisible(true);

        progressTimer = new Timer(DELAY, e -> {
            int currentValue = prbLoading.getValue();
            if (currentValue < 100) {
                prbLoading.setValue(currentValue + 1);
            } else {
                progressTimer.stop();
                frmSplash.dispose(); // Cierra la ventana de splash

                // Muestra la ventana de login tras cerrar el splash
                SwingUtilities.invokeLater(() -> new LoginWindow().setVisible(true));
            }
        });
        progressTimer.start();
    }

    public static int getDelay() {
        return DELAY;
    }
}