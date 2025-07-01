package amca;

import modelo.Preparados;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PreparadosFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private List<Preparados> preparadosList;
    private static final String CSV_FILE = "preparados.csv";
    private JPanel mainPanel;

    public PreparadosFrame() {
        mainPanel = new JPanel(new BorderLayout());
        setNimbusLookAndFeel();
        preparadosList = loadPreparados();
        String[] columns = {"Finca", "Tipo", "Producto", "Cantidad"};
        tableModel = new DefaultTableModel(columns, 0) {
            public boolean isCellEditable(int row, int column) { return false; }
        };
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        refreshTable();

        JButton addBtn = new JButton("Agregar");
        JButton editBtn = new JButton("Editar");
        JButton delBtn = new JButton("Eliminar");

        addBtn.setBackground(new Color(0, 153, 76));
        addBtn.setForeground(Color.WHITE);
        editBtn.setBackground(new Color(0, 102, 204));
        editBtn.setForeground(Color.WHITE);
        delBtn.setBackground(new Color(204, 0, 0));
        delBtn.setForeground(Color.WHITE);

        addBtn.addActionListener(e -> addPreparado());
        editBtn.addActionListener(e -> editPreparado());
        delBtn.addActionListener(e -> deletePreparado());

        JPanel btnPanel = new JPanel();
        btnPanel.add(addBtn);
        btnPanel.add(editBtn);
        btnPanel.add(delBtn);

        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);
    }

    public JPanel getContentPanel() {
        return mainPanel;
    }

    private void setNimbusLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ignored) {}
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Preparados p : preparadosList) {
            tableModel.addRow(new Object[]{p.getNombreFinca(), p.getTipo(), p.getNombreProducto(), p.getCantidad()});
        }
    }

    private void addPreparado() {
        JTextField finca = new JTextField();
        JTextField tipo = new JTextField();
        JTextField producto = new JTextField();
        JTextField cantidad = new JTextField();
        Object[] fields = {"Finca:", finca, "Tipo:", tipo, "Producto:", producto, "Cantidad:", cantidad};
        int res = JOptionPane.showConfirmDialog(mainPanel, fields, "Agregar Preparado", JOptionPane.OK_CANCEL_OPTION);
        if (res == JOptionPane.OK_OPTION) {
            String f = finca.getText().trim();
            String t = tipo.getText().trim();
            String p = producto.getText().trim();
            String c = cantidad.getText().trim();
            if (f.isEmpty() || t.isEmpty() || p.isEmpty() || c.isEmpty()) {
                JOptionPane.showMessageDialog(mainPanel, "Todos los campos son obligatorios.");
                return;
            }
            try {
                int cant = Integer.parseInt(c);
                if (cant <= 0) throw new NumberFormatException();
                preparadosList.add(new Preparados(f, t, p, cant));
                savePreparados();
                refreshTable();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(mainPanel, "Cantidad debe ser un número positivo.");
            }
        }
    }

    private void editPreparado() {
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(mainPanel, "Selecciona un preparado para editar.");
            return;
        }
        Preparados prep = preparadosList.get(row);
        JTextField finca = new JTextField(prep.getNombreFinca());
        JTextField tipo = new JTextField(prep.getTipo());
        JTextField producto = new JTextField(prep.getNombreProducto());
        JTextField cantidad = new JTextField(String.valueOf(prep.getCantidad()));
        Object[] fields = {"Finca:", finca, "Tipo:", tipo, "Producto:", producto, "Cantidad:", cantidad};
        int res = JOptionPane.showConfirmDialog(mainPanel, fields, "Editar Preparado", JOptionPane.OK_CANCEL_OPTION);
        if (res == JOptionPane.OK_OPTION) {
            String f = finca.getText().trim();
            String t = tipo.getText().trim();
            String p = producto.getText().trim();
            String c = cantidad.getText().trim();
            if (f.isEmpty() || t.isEmpty() || p.isEmpty() || c.isEmpty()) {
                JOptionPane.showMessageDialog(mainPanel, "Todos los campos son obligatorios.");
                return;
            }
            try {
                int cant = Integer.parseInt(c);
                if (cant <= 0) throw new NumberFormatException();
                prep.setNombreFinca(f);
                prep.setTipo(t);
                prep.setNombreProducto(p);
                prep.setCantidad(cant);
                savePreparados();
                refreshTable();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(mainPanel, "Cantidad debe ser un número positivo.");
            }
        }
    }

    private void deletePreparado() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            if (JOptionPane.showConfirmDialog(mainPanel, "¿Eliminar el preparado seleccionado?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                preparadosList.remove(row);
                savePreparados();
                refreshTable();
            }
        }
    }

    private List<Preparados> loadPreparados() {
        List<Preparados> list = new ArrayList<>();
        File file = new File(CSV_FILE);
        if (!file.exists()) return Preparados.listaPreparados();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String finca = parts[0];
                    String tipo = parts[1];
                    String producto = parts[2];
                    int cant = Integer.parseInt(parts[3]);
                    list.add(new Preparados(finca, tipo, producto, cant));
                }
            }
        } catch (Exception ignored) {}
        return list;
    }

    private void savePreparados() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(CSV_FILE))) {
            for (Preparados p : preparadosList) {
                pw.println(p.getNombreFinca() + "," + p.getTipo() + "," + p.getNombreProducto() + "," + p.getCantidad());
            }
        } catch (IOException ignored) {}
    }
} 