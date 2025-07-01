package amca;

import modelo.Cultivos;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CultivosFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private List<Cultivos> cultivosList;
    private static final String CSV_FILE = "cultivos.csv";
    private JPanel mainPanel;

    public CultivosFrame() {
        mainPanel = new JPanel(new BorderLayout());
        setNimbusLookAndFeel();
        cultivosList = loadCultivos();
        String[] columns = {"Nombre", "Hectáreas"};
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

        addBtn.addActionListener(e -> addCultivo());
        editBtn.addActionListener(e -> editCultivo());
        delBtn.addActionListener(e -> deleteCultivo());

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
        for (Cultivos c : cultivosList) {
            tableModel.addRow(new Object[]{c.getNombre(), c.getExtended()});
        }
    }

    private void addCultivo() {
        JTextField nombre = new JTextField();
        JTextField hectareas = new JTextField();
        Object[] fields = {"Nombre:", nombre, "Hectáreas:", hectareas};
        int res = JOptionPane.showConfirmDialog(mainPanel, fields, "Agregar Cultivo", JOptionPane.OK_CANCEL_OPTION);
        if (res == JOptionPane.OK_OPTION) {
            String n = nombre.getText().trim();
            String h = hectareas.getText().trim();
            if (n.isEmpty() || h.isEmpty()) {
                JOptionPane.showMessageDialog(mainPanel, "Todos los campos son obligatorios.");
                return;
            }
            try {
                int hect = Integer.parseInt(h);
                if (hect <= 0) throw new NumberFormatException();
                cultivosList.add(new Cultivos(n, hect));
                saveCultivos();
                refreshTable();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(mainPanel, "Hectáreas debe ser un número positivo.");
            }
        }
    }

    private void editCultivo() {
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(mainPanel, "Selecciona un cultivo para editar.");
            return;
        }
        Cultivos c = cultivosList.get(row);
        JTextField nombre = new JTextField(c.getNombre());
        JTextField hectareas = new JTextField(String.valueOf(c.getExtended()));
        Object[] fields = {"Nombre:", nombre, "Hectáreas:", hectareas};
        int res = JOptionPane.showConfirmDialog(mainPanel, fields, "Editar Cultivo", JOptionPane.OK_CANCEL_OPTION);
        if (res == JOptionPane.OK_OPTION) {
            String n = nombre.getText().trim();
            String h = hectareas.getText().trim();
            if (n.isEmpty() || h.isEmpty()) {
                JOptionPane.showMessageDialog(mainPanel, "Todos los campos son obligatorios.");
                return;
            }
            try {
                int hect = Integer.parseInt(h);
                if (hect <= 0) throw new NumberFormatException();
                c.setNombre(n);
                c.setExtended(hect);
                saveCultivos();
                refreshTable();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(mainPanel, "Hectáreas debe ser un número positivo.");
            }
        }
    }

    private void deleteCultivo() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            if (JOptionPane.showConfirmDialog(mainPanel, "¿Eliminar el cultivo seleccionado?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                cultivosList.remove(row);
                saveCultivos();
                refreshTable();
            }
        }
    }

    private List<Cultivos> loadCultivos() {
        List<Cultivos> list = new ArrayList<>();
        File file = new File(CSV_FILE);
        if (!file.exists()) return Cultivos.obtenerListaCultivos();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String nombre = parts[0];
                    int hect = Integer.parseInt(parts[1]);
                    list.add(new Cultivos(nombre, hect));
                }
            }
        } catch (Exception ignored) {}
        return list;
    }

    private void saveCultivos() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(CSV_FILE))) {
            for (Cultivos c : cultivosList) {
                pw.println(c.getNombre() + "," + c.getExtended());
            }
        } catch (IOException ignored) {}
    }
} 