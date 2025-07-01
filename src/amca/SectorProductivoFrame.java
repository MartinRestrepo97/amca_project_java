package amca;

import modelo.SectorProductivo;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SectorProductivoFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private List<SectorProductivo> sectorList;
    private static final String CSV_FILE = "sectorproductivo.csv";
    private JPanel mainPanel;

    public SectorProductivoFrame() {
        mainPanel = new JPanel(new BorderLayout());
        setNimbusLookAndFeel();
        sectorList = loadSector();
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

        addBtn.addActionListener(e -> addSector());
        editBtn.addActionListener(e -> editSector());
        delBtn.addActionListener(e -> deleteSector());

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
        for (SectorProductivo s : sectorList) {
            tableModel.addRow(new Object[]{s.getNombre(), s.getExtended()});
        }
    }

    private void addSector() {
        JTextField nombre = new JTextField();
        JTextField hectareas = new JTextField();
        Object[] fields = {"Nombre:", nombre, "Hectáreas:", hectareas};
        int res = JOptionPane.showConfirmDialog(mainPanel, fields, "Agregar Sector Productivo", JOptionPane.OK_CANCEL_OPTION);
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
                sectorList.add(new SectorProductivo(n, hect, ""));
                saveSector();
                refreshTable();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(mainPanel, "Hectáreas debe ser un número positivo.");
            }
        }
    }

    private void editSector() {
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(mainPanel, "Selecciona un sector para editar.");
            return;
        }
        SectorProductivo s = sectorList.get(row);
        JTextField nombre = new JTextField(s.getNombre());
        JTextField hectareas = new JTextField(String.valueOf(s.getExtended()));
        Object[] fields = {"Nombre:", nombre, "Hectáreas:", hectareas};
        int res = JOptionPane.showConfirmDialog(mainPanel, fields, "Editar Sector Productivo", JOptionPane.OK_CANCEL_OPTION);
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
                s.setNombre(n);
                s.setExtended(hect);
                saveSector();
                refreshTable();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(mainPanel, "Hectáreas debe ser un número positivo.");
            }
        }
    }

    private void deleteSector() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            if (JOptionPane.showConfirmDialog(mainPanel, "¿Eliminar el sector seleccionado?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                sectorList.remove(row);
                saveSector();
                refreshTable();
            }
        }
    }

    private List<SectorProductivo> loadSector() {
        List<SectorProductivo> list = new ArrayList<>();
        File file = new File(CSV_FILE);
        if (!file.exists()) return SectorProductivo.listaSectorProductivo();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String nombre = parts[0];
                    int hect = Integer.parseInt(parts[1]);
                    list.add(new SectorProductivo(nombre, hect, ""));
                }
            }
        } catch (Exception ignored) {}
        return list;
    }

    private void saveSector() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(CSV_FILE))) {
            for (SectorProductivo s : sectorList) {
                pw.println(s.getNombre() + "," + s.getExtended());
            }
        } catch (IOException ignored) {}
    }
} 