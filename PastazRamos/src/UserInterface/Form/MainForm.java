 package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import BusinessLogic.CuentaAdminBL;


import BusinessLogic.Entities.EjercitoRuso.Hormiga;
import DataAccess.*;


public class MainForm extends JFrame{

    
    private CuentaAdminBL cuentaAdminBL;
    MenuPanel  pnlMenu = new MenuPanel();
    JPanel     pnlMain = new MainPanel();

 
    public MainForm(String tilteApp, CuentaAdminBL cuentaAdminBL) {
        super(tilteApp);
        
        this.cuentaAdminBL = cuentaAdminBL;
        customizeComponent(tilteApp);
        pnlMenu.btnHome.addActionListener(      e -> setPanel(new MainPanel())); 
        pnlMenu.btnFuentePoder.addActionListener(e -> setPanel(new FuentePoderPanel()));

        pnlMenu.btnAntBot.addActionListener(e->setPanel(new AntBotPanel()));

        pnlMenu.btnHormiga.addActionListener(e -> setPanel(new HormigaPanel()));
        



        
    }
    private void setPanel(JPanel formularioPanel) {
        Container container = getContentPane();
        container.remove(pnlMain);
        pnlMain = formularioPanel;
        container.add(pnlMain, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
     

    private void customizeComponent(String tilteApp) {
        setTitle(tilteApp);
        setSize(930, 800);
        setResizable(false);
        setLocationRelativeTo(null); // Centrar en la pantalla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        container.add(pnlMenu, BorderLayout.WEST);
        container.add(pnlMain, BorderLayout.CENTER);
        setVisible(true);
    }   
     
    }

