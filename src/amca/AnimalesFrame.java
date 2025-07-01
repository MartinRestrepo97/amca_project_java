package amca;

import modelo.Animales;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalesFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private List<Animales> animalesList;
    private static final String CSV_FILE = "animales.csv";
    private JPanel mainPanel;

    public AnimalesFrame() {
        mainPanel = new JPanel(new BorderLayout());
        setNimbusLookAndFeel();
        animalesList = loadAnimales();
        String[] columns = {"Nombre", "Cantidad"};
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

        addBtn.addActionListener(e -> addAnimal());
        editBtn.addActionListener(e -> editAnimal());
        delBtn.addActionListener(e -> deleteAnimal());

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
        for (Animales a : animalesList) {
            tableModel.addRow(new Object[]{a.getNombre(), a.getCantidad()});
        }
    }

    private void addAnimal() {
        JTextField nombre = new JTextField();
        JTextField cantidad = new JTextField();
        Object[] fields = {"Nombre:", nombre, "Cantidad:", cantidad};
        int res = JOptionPane.showConfirmDialog(mainPanel, fields, "Agregar Animal", JOptionPane.OK_CANCEL_OPTION);
        if (res == JOptionPane.OK_OPTION) {
            String n = nombre.getText().trim();
            String c = cantidad.getText().trim();
            if (n.isEmpty() || c.isEmpty()) {
                JOptionPane.showMessageDialog(mainPanel, "Todos los campos son obligatorios.");
                return;
            }
            try {
                int cant = Integer.parseInt(c);
                if (cant <= 0) throw new NumberFormatException();
                animalesList.add(new Animales(n, cant));
                saveAnimales();
                refreshTable();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(mainPanel, "Cantidad debe ser un número positivo.");
            }
        }
    }

    private void editAnimal() {
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(mainPanel, "Selecciona un animal para editar.");
            return;
        }
        Animales a = animalesList.get(row);
        JTextField nombre = new JTextField(a.getNombre());
        JTextField cantidad = new JTextField(String.valueOf(a.getCantidad()));
        Object[] fields = {"Nombre:", nombre, "Cantidad:", cantidad};
        int res = JOptionPane.showConfirmDialog(mainPanel, fields, "Editar Animal", JOptionPane.OK_CANCEL_OPTION);
        if (res == JOptionPane.OK_OPTION) {
            String n = nombre.getText().trim();
            String c = cantidad.getText().trim();
            if (n.isEmpty() || c.isEmpty()) {
                JOptionPane.showMessageDialog(mainPanel, "Todos los campos son obligatorios.");
                return;
            }
            try {
                int cant = Integer.parseInt(c);
                if (cant <= 0) throw new NumberFormatException();
                a.setNombre(n);
                a.setCantidad(cant);
                saveAnimales();
                refreshTable();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(mainPanel, "Cantidad debe ser un número positivo.");
            }
        }
    }

    private void deleteAnimal() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            if (JOptionPane.showConfirmDialog(mainPanel, "¿Eliminar el animal seleccionado?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                animalesList.remove(row);
                saveAnimales();
                refreshTable();
            }
        }
    }

    private List<Animales> loadAnimales() {
        List<Animales> list = new ArrayList<>();
        File file = new File(CSV_FILE);
        if (!file.exists()) return Animales.listaAnimales();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String nombre = parts[0];
                    int cant = Integer.parseInt(parts[1]);
                    list.add(new Animales(nombre, cant));
                }
            }
        } catch (Exception ignored) {}
        return list;
    }

    private void saveAnimales() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(CSV_FILE))) {
            for (Animales a : animalesList) {
                pw.println(a.getNombre() + "," + a.getCantidad());
            }
        } catch (IOException ignored) {}
    }
} 