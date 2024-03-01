package UserInterface.Form;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import BusinessLogic.AntBotBL;
import DataAccess.DTO.AntBotDTO;
import UserInterface.IAStyle;
import UserInterface.CustomerControl.PatButton;
import UserInterface.CustomerControl.PatLabel;
import UserInterface.CustomerControl.PatTextBox;
public class AntBotPanel extends JPanel implements ActionListener {
    private Integer idAntBot = 0, idMaxAInteger=0;
    private AntBotBL antBotBL = null;
    private AntBotDTO antBot = null;
    private PatTextBox txtIdAntBot = new PatTextBox();

    public AntBotPanel() {
        try {
            customizeComponent();
            loadRow();
            showRow();
            showTable();

            btnRowIni.addActionListener(this);
            btnRowAnt.addActionListener(this);
            btnRowSig.addActionListener(this);
            btnRowFin.addActionListener(this);
            
            btnNuevo.addActionListener(     e -> btnNuevoClick());
            btnGuardar.addActionListener(   e -> btnGuardarClick());
            btnEliminar.addActionListener(  e -> btnEliminarClick());
            btnCancelar.addActionListener(  e -> btnCancelarClick());
        } catch (Exception e) {
            IAStyle.showMsg(e.getMessage());
        }
    }

        private void loadRow() throws Exception {
            idAntBot      = 1;
            antBotBL      = new AntBotBL();
            antBot       = antBotBL.getByIdAntBot(idAntBot);
            idAntBot  = antBotBL.getMaxRow();
        }
    
        private void showRow() {
        boolean antBotNull = (antBot == null);
        txtIdAntBot.setText((antBot) != null ? " " : antBot.getIdAntBot().toString());

        lblTotalReg.setText(idAntBot.toString() + " de " + idAntBot.toString());
    }
        private void btnNuevoClick() {
            antBot = null;
            showRow();
        } 
        private void btnGuardarClick() {
            boolean antBotNull = (antBot== null);
            // String buttonText = ((JButton) e.getSource()).getText();
            try {
                if (IAStyle.showConfirmYesNo("¿Seguro que desea " + ((antBotNull) ? "AGREGAR ?" : "ACTUALIZAR ?"))){
                
                    if (antBotNull)
                        antBot= new AntBotDTO(idAntBot, idAntBot, idAntBot, idAntBot, idAntBot, idAntBot, idAntBot, idAntBot, idAntBot, idAntBot, idAntBot, idAntBot, idAntBot, idAntBot, idAntBot, txtNombre.getText(), null, null, null);
                    else
                        antBot.setIdHormiga(idAntBot);
        
                    if(!((antBotNull) ? antBotBL.create(antBot) : antBotBL.update(antBot)))
                        IAStyle.showMsgError("Error al guardar...!");
        
                    loadRow();
                    showRow();
                    showTable();
                }
            } catch (Exception e) {
                IAStyle.showMsgError(e.getMessage());
            }
        }

        private void btnEliminarClick() {
            try {
                if (IAStyle.showConfirmYesNo("Seguro que desea Eliminar?")) {
    
                    if (!antBotBL.delete(antBot.getIdFuentePoder()))
                        throw new Exception("Error al eliminar...!");
        
                    loadRow();
                    showRow();
                    showTable();
                }
            } catch (Exception e) {
                IAStyle.showMsgError(e.getMessage());
            }
        }
    
        private void btnCancelarClick() {
            try {
                if(antBot == null)
                    loadRow();
                showRow();
            } catch (Exception e) {}
        }

        private void showTable() throws Exception {
            String[] header = {"Id", "IdHormiga", "Estado"};
            Object[][] data = new Object[antBotBL.getAll().size()][3];
            int index = 0;
            for (AntBotDTO s : antBotBL.getAll()) {
                data[index][0] = s.getIdFuentePoder();
                data[index][1] = s.getIdHormiga();
                data[index][2] = s.getEstado();
                index++;
            }
        
            JTable table = new JTable(data, header);
            table.setShowHorizontalLines(true);
            table.setGridColor(Color.lightGray);
            table.setRowSelectionAllowed(true);
            table.setColumnSelectionAllowed(false);
        
            table.setPreferredScrollableViewportSize(new Dimension(450, 150));
            table.setFillsViewportHeight(true);
        
            pnlTabla.removeAll();
            pnlTabla.add(new JScrollPane(table));
        
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = table.rowAtPoint(e.getPoint());
                    int col = table.columnAtPoint(e.getPoint());
                    if (row >= 0 && col >= 0) {
                        String strIdAntBot = table.getModel().getValueAt(row, 0).toString(); // Corregido el nombre de la variable
                        idAntBot = Integer.parseInt(strIdAntBot);
                        try {
                            antBot = antBotBL.getByIdAntBot(idAntBot);
                            showRow();
                        } catch (Exception ignored) {
                        }
                        System.out.println("Tabla.Selected: " + strIdAntBot);
                    }
                }
            });
        }
        
    







    private PatLabel 
            lblTitulo   = new PatLabel("AntBot"),
            lblIdRelacion   = new PatLabel(" Codigo:      "),
            lblNombre   = new PatLabel("*IdHormiga: "),
            lblTotalReg = new PatLabel(" 0 de 0 ");
    private PatTextBox 
            txtIdRelacion   = new PatTextBox(),
            txtNombre   = new PatTextBox();
    private PatButton 
            btnPageIni  = new PatButton(" |< "),
            btnPageAnt  = new PatButton(" << "),
            btnPageSig  = new PatButton(" >> "),
            btnPageFin  = new PatButton(" >| "),

            btnRowIni   = new PatButton(" |< "),
            btnRowAnt   = new PatButton(" << "),
            btnRowSig   = new PatButton(" >> "),
            btnRowFin   = new PatButton(" >| "),

            btnNuevo    = new PatButton("Nuevo"),
            btnGuardar  = new PatButton("Guardar"),
            btnCancelar = new PatButton("Cancelar"),
            btnEliminar = new PatButton("Eliminar");
    private JPanel 
            pnlTabla    = new JPanel(),
            pnlBtnRow   = new JPanel(new FlowLayout()),
            pnlBtnPage  = new JPanel(new FlowLayout()),
            pnlBtnCRUD  = new JPanel(new FlowLayout());




    private Integer idAntBotInteger = 0, idMaxAntBot=0;
    private AntBotBL AntBotBL = null;
    private AntBotDTO AntBot = null;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRowIni)
        idAntBot = 1;
    if (e.getSource() == btnRowAnt && (idAntBot > 1))
        idAntBot--;
    if (e.getSource() == btnRowSig && (idAntBot < idMaxAntBot))
        idAntBot++;
    if (e.getSource() == btnRowFin)
        idAntBot = idMaxAntBot;
    try {
        antBot    = antBotBL.getByIdAntBot(idAntBot);
        showRow();
    } catch (Exception ex) {}
    }

    public void customizeComponent() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        txtIdRelacion.setEnabled(false);
        txtIdRelacion.setBorderLine();
        txtNombre.setBorderLine();

        pnlBtnPage.add(btnPageIni);
        pnlBtnPage.add(btnPageAnt);
        pnlBtnPage.add(new PatLabel(" Page:( "));
        pnlBtnPage.add(lblTotalReg); //cambiar
        pnlBtnPage.add(new PatLabel(" ) "));
        pnlBtnPage.add(btnPageSig);
        pnlBtnPage.add(btnPageFin);

        pnlBtnRow.add(btnRowIni);
        pnlBtnRow.add(btnRowAnt);
        pnlBtnRow.add(lblTotalReg);
        pnlBtnRow.add(btnRowSig);
        pnlBtnRow.add(btnRowFin);

        pnlBtnCRUD.add(btnNuevo);
        pnlBtnCRUD.add(btnGuardar);
        pnlBtnCRUD.add(btnCancelar);
        pnlBtnCRUD.add(btnEliminar);
        pnlBtnCRUD.setBorder(IAStyle.createBorderRect());

        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(lblTitulo, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(new JLabel("■ Sección de datos: "), gbc);
        gbc.gridy = 1;
        gbc.gridx = 1;
        add(pnlBtnPage, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.ipady = 150;
        gbc.ipadx = 450;
        pnlTabla.add(new Label("Loading data..."));
        add(pnlTabla, gbc);

        gbc.ipady = 1;
        gbc.ipadx = 1;

        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(50, 0, 0, 0);  // Ajusta el valor superior a 50
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(Box.createRigidArea(new Dimension(0, 0)), gbc);

        gbc.insets = new Insets(10, 0, 0, 0);  

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(new JLabel("■ Sección de registro: "), gbc);
        gbc.gridy = 4;
        gbc.gridx = 1;
        add(pnlBtnRow, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        add(lblIdRelacion, gbc);
        gbc.gridy = 5;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(txtIdRelacion, gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        add(lblNombre, gbc);
        gbc.gridy = 6;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; 
        add(txtNombre, gbc);


        gbc.gridy = 7;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pnlBtnCRUD, gbc);
    }

}
