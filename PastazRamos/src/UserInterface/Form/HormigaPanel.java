package UserInterface.Form;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import BusinessLogic.HormigaBL;
import DataAccess.DTO.HormigaDTO;

public class HormigaPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private HormigaBL hormigaBL = new HormigaBL();
    private JTextField txtNombre, txtObservacion, txtIdHormigaTipo;
    private JButton btnNuevo, btnGuardar, btnEliminar, btnCancelar;

    public HormigaPanel() {
        setLayout(new BorderLayout());
        initializeUI();
        loadHormigas();
    }

    private void initializeUI() {
        model = new DefaultTableModel(new String[]{"ID", "Nombre", "Observación"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        inputPanel.add(txtNombre);
        inputPanel.add(new JLabel("IdHormigaTipo:"));
        txtIdHormigaTipo = new JTextField();
        inputPanel.add(txtIdHormigaTipo);
        inputPanel.add(new JLabel("Observación:"));
        txtObservacion = new JTextField();
        inputPanel.add(txtObservacion);

        btnNuevo = new JButton("Nuevo");
        btnGuardar = new JButton("Guardar");
        btnEliminar = new JButton("Eliminar");
        btnCancelar = new JButton("Cancelar");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnNuevo);
        buttonPanel.add(btnGuardar);
        buttonPanel.add(btnEliminar);
        buttonPanel.add(btnCancelar);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        btnNuevo.addActionListener(e -> nuevo());
        btnGuardar.addActionListener(e -> guardar());
        btnEliminar.addActionListener(e -> eliminar());
        btnCancelar.addActionListener(e -> cancelar());

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    txtNombre.setText(model.getValueAt(row, 1).toString());
                    txtObservacion.setText(model.getValueAt(row, 2).toString());
                }
            }
        });
    }

    private void loadHormigas() {
        try {
            model.setRowCount(0); // Limpiar el modelo
            for (HormigaDTO hormiga : hormigaBL.readAll()) {
                model.addRow(new Object[]{hormiga.getIdHormiga(), hormiga.getNombre(), hormiga.getObservacion()});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar hormigas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void nuevo() {
        txtNombre.setText("");
        txtObservacion.setText("");
    }

    private void guardar() {
        try {
            HormigaDTO hormiga = new HormigaDTO();
            hormiga.setNombre(txtNombre.getText());
            hormiga.setObservacion(txtObservacion.getText());
            hormiga.setIdHormigaTipo(Integer.parseInt(txtIdHormigaTipo.getText()));
            hormigaBL.create(hormiga);
            loadHormigas(); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar hormiga: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminar() {
        int row = table.getSelectedRow();
        if (row != -1) {
            int id = (int) model.getValueAt(row, 0);
            try {
                hormigaBL.delete(id);
                loadHormigas(); // Recargar la lista
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar hormiga: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void cancelar() {
        nuevo(); 
    }
}
