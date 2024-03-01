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

import BusinessLogic.FuentePoderBL;
import DataAccess.DTO.FuentePoderDTO;
import UserInterface.IAStyle;
import UserInterface.CustomerControl.PatButton;
import UserInterface.CustomerControl.PatLabel;
import UserInterface.CustomerControl.PatTextBox;


public class FuentePoderPanel extends JPanel implements ActionListener {
    private Integer idFuentePoderInteger = 0, idMaxRInteger=0;
    private FuentePoderBL fuentePoderBL = null;
    private FuentePoderDTO fuentePoder = null;
    private PatTextBox txtIdFuentePoder = new PatTextBox();

    public FuentePoderPanel() {
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
            idFuentePoderInteger      = 1;
            fuentePoderBL      = new FuentePoderBL();
            fuentePoder       = fuentePoderBL.getByIdFuentePoder(idFuentePoderInteger);
            idMaxRInteger   = fuentePoderBL.getMaxRow();
        }
    
        private void showRow() {
        boolean fuentePoderNull = (fuentePoder == null);
        txtIdFuentePoder.setText((fuentePoder) != null ? " " : fuentePoder.getIdFuentePoder().toString());
        txtNombre.setText((fuentePoderNull) ? " " : fuentePoder.getNombre());
        lblTotalReg.setText(idFuentePoder.toString() + " de " + idFuentePoder.toString());
    }
        private void btnNuevoClick() {
            fuentePoder = null;
            showRow();
        } 
        private void btnGuardarClick() {
            boolean fuentePoderNull = (fuentePoder == null);
            // String buttonText = ((JButton) e.getSource()).getText();
            try {
                if (IAStyle.showConfirmYesNo("¿Seguro que desea " + ((fuentePoderNull) ? "AGREGAR ?" : "ACTUALIZAR ?"))){
                
                    if (fuentePoderNull)
                        fuentePoder = new FuentePoderDTO(txtNombre.getText(), null);
                    else
                        fuentePoder.setNombre(txtNombre.getText());
        
                    if(!((fuentePoderNull) ? fuentePoderBL.create(fuentePoder) : fuentePoderBL.update(fuentePoder)))
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
    
                    if (!fuentePoderBL.delete(fuentePoder.getIdFuentePoder()))
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
                if(fuentePoder == null)
                    loadRow();
                showRow();
            } catch (Exception e) {}
        }

        private void showTable() throws Exception {
            String[] header = {"Id", "Nombre", "Estado"};
            Object[][] data = new Object[fuentePoderBL.getAll().size()][3];
            int index = 0;
            for (FuentePoderDTO s : fuentePoderBL.getAll()) {
                data[index][0] = s.getIdFuentePoder();
                data[index][1] = s.getNombre();
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
                        String strIdFuentePoder = table.getModel().getValueAt(row, 0).toString(); // Corregido el nombre de la variable
                        idFuentePoder = Integer.parseInt(strIdFuentePoder);
                        try {
                            fuentePoder = fuentePoderBL.getByIdFuentePoder(idFuentePoder);
                            showRow();
                        } catch (Exception ignored) {
                        }
                        System.out.println("Tabla.Selected: " + strIdFuentePoder);
                    }
                }
            });
        }
        
    
    private PatLabel 
            lblTitulo   = new PatLabel("AntBot"),
            lblIdRelacion   = new PatLabel(" Codigo:      "),
            lblNombre   = new PatLabel("*Descripción: "),
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




    private Integer idFuentePoder = 0, idMaxFuentePoder=0;
    private FuentePoderBL FuentePoderBL = null;
    private FuentePoderDTO FuentePoder = null;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRowIni)
        idFuentePoderInteger = 1;
    if (e.getSource() == btnRowAnt && (idFuentePoderInteger > 1))
        idFuentePoderInteger--;
    if (e.getSource() == btnRowSig && (idFuentePoderInteger < idMaxRInteger))
        idFuentePoder++;
    if (e.getSource() == btnRowFin)
        idFuentePoderInteger = idMaxRInteger;
    try {
        fuentePoder    = fuentePoderBL.getByIdFuentePoder(idFuentePoderInteger);
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
