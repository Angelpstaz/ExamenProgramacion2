/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| dilan.calvache@epn.edu.ec  Msetoo      |
|----------------------------------------|
Autor : Mateo Calvache
Fecha : 29.02.2k24
*/
package UserInterface.Form;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import BusinessLogic.CuentaAdminBL;
import DataAccess.DTO.CuentaAdminDTO;

public class LoginWindow extends JFrame {
    private JTextField txtCorreo;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private CuentaAdminBL cuentaAdminBL;

    public LoginWindow() {
        super("ANTBOT");
        cuentaAdminBL = new CuentaAdminBL(); 
        initializeUI();
    
        URL iconURL = getClass().getResource("/UserInterface/Resource/Img/Icono.png"); 
        if (iconURL != null) {
            ImageIcon windowIcon = new ImageIcon(iconURL);
            setIconImage(windowIcon.getImage());
        }
    
        // Configurar la ventana para que se maximice
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
    }
    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH); // Ventana maximizada
        setLocationRelativeTo(null); // Centrar la ventana
        setLayout(new GridBagLayout()); // Usar GridBagLayout para el layout principal
    
        JPanel loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setBorder(BorderFactory.createTitledBorder("Login Admin"));
    
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
    
        // Intentar cargar el ícono y mostrarlo en el panel de login
        URL iconURL = getClass().getResource("/UserInterface/Resource/Img/Icono.png");
        if (iconURL != null) {
            ImageIcon loginIcon = new ImageIcon(iconURL);
            JLabel lblIcon = new JLabel(loginIcon);
            // Configurar el gbc para el ícono específicamente
            GridBagConstraints iconGbc = new GridBagConstraints();
            iconGbc.insets = new Insets(5, 5, 5, 5);
            iconGbc.gridx = 0; // Puede ajustar según la posición deseada
            iconGbc.gridy = 0;
            iconGbc.gridwidth = 2; // Asumiendo que quieres que el ícono abarque dos columnas
            iconGbc.anchor = GridBagConstraints.CENTER;
            loginPanel.add(lblIcon, iconGbc);
    
            // Ajustar el valor de y para los próximos componentes
            gbc.gridy = 1;
        } else {
            System.err.println("No se pudo cargar el ícono: /UserInterface/Resource/Img/Icono.png");
            gbc.gridy = 0;
        }
    
        gbc.gridx = 0;
        loginPanel.add(new JLabel("Correo:"), gbc);
        gbc.gridx = 1;
        txtCorreo = new JTextField(20);
        loginPanel.add(txtCorreo, gbc);
    
        gbc.gridx = 0;
        gbc.gridy++;
        loginPanel.add(new JLabel("Contraseña:"), gbc);
        gbc.gridx = 1;
        txtPassword = new JPasswordField(20);
        loginPanel.add(txtPassword, gbc);
    
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        btnLogin = new JButton("Login");
        btnLogin.addActionListener(e -> {
            try {
                login();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        loginPanel.add(btnLogin, gbc);
    
        // Centrar el panel de login en la ventana
        GridBagConstraints mainGbc = new GridBagConstraints();
        mainGbc.anchor = GridBagConstraints.CENTER;
        add(loginPanel, mainGbc);
    }
    
    

    private void login() throws Exception {
        String correo = txtCorreo.getText();
        String password = new String(txtPassword.getPassword());
    
        CuentaAdminDTO cuenta = cuentaAdminBL.login(correo, password);
        if (cuenta != null) {
            JOptionPane.showMessageDialog(this, "Bienvenido "+ correo, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    
            // Crear instancia de MainForm pasando CuentaAdminBL
            MainForm frmMain = new MainForm("AntBot", cuentaAdminBL);
            frmMain.setVisible(true);
            this.dispose();  // Cerrar ventana de inicio de sesión
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error de Login", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginWindow().setVisible(true));
    }
}


