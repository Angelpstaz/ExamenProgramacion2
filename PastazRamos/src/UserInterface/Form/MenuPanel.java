package UserInterface.Form;

import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UserInterface.CustomerControl.PatButton;

public class MenuPanel extends JPanel {
    
    public PatButton
            
            btnHome = new PatButton("Home"),
            btnLogin = new PatButton("Login"),
            btnFuentePoder = new PatButton("Fuente Poder"),

            btnAntBot= new PatButton("Ant Bot"),

            btnHormiga = new PatButton("Hormiga");
           


    public MenuPanel() {
        customizeComponent();
    }

    private void customizeComponent() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(250, getHeight()));

        // Añadir logo
        try {
            Image logo = ImageIO.read(getClass().getResource("/UserInterface/Resource/Img/Icono.png")); // Asegúrate de actualizar esta ruta al logo
            logo = logo.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            add(new JLabel(new ImageIcon(logo)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        add(btnHome);
        add(btnFuentePoder);
        
        add(btnAntBot);
        add(btnHormiga);

        


        // Pie de página con derechos de autor
        add(new JLabel("\u00A9 2024 Byte_Busters"));
    }
}
