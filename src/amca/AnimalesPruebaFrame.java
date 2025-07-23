package amca;

import modelo.Animales;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalesPruebaFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private List<Animales> animalesList;
    private JPanel mainPanel;

    public AnimalesPruebaFrame() {
        mainPanel = new JPanel(new BorderLayout());
        animalesList = new ArrayList<>();
        String[] columns = {"Nombre", "Cantidad"};
        tableModel = new DefaultTableModel(columns, 0) {
            public boolean isCellEditable(int row, int column) { return false; }
        };
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        refreshTable();

        JButton addValidBtn = new JButton("Agregar Válido");
        JButton addInvalidBtn = new JButton("Agregar Inválido");
        JButton clearBtn = new JButton("Limpiar");
        JButton exportBtn = new JButton("Exportar Resultados");

        addValidBtn.setBackground(new Color(0, 153, 76));
        addValidBtn.setForeground(Color.WHITE);
        addInvalidBtn.setBackground(new Color(204, 0, 0));
        addInvalidBtn.setForeground(Color.WHITE);
        clearBtn.setBackground(new Color(0, 102, 204));
        clearBtn.setForeground(Color.WHITE);
        exportBtn.setBackground(new Color(255, 193, 7));
        exportBtn.setForeground(Color.BLACK);

        addValidBtn.addActionListener(e -> addAnimal(true));
        addInvalidBtn.addActionListener(e -> addAnimal(false));
        clearBtn.addActionListener(e -> {
            animalesList.clear();
            refreshTable();
        });
        exportBtn.addActionListener(e -> exportarResultados());

        JPanel btnPanel = new JPanel();
        btnPanel.add(addValidBtn);
        btnPanel.add(addInvalidBtn);
        btnPanel.add(clearBtn);
        btnPanel.add(exportBtn);

        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);
    }

    public JPanel getContentPanel() {
        return mainPanel;
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Animales a : animalesList) {
            tableModel.addRow(new Object[]{a.getNombre(), a.getCantidad()});
        }
    }

    private void addAnimal(boolean valido) {
        JTextField nombre = new JTextField();
        JTextField cantidad = new JTextField();
        Object[] fields = {"Nombre:", nombre, "Cantidad:", cantidad};
        int res = JOptionPane.showConfirmDialog(mainPanel, fields, (valido ? "Agregar Animal Válido" : "Agregar Animal Inválido"), JOptionPane.OK_CANCEL_OPTION);
        if (res == JOptionPane.OK_OPTION) {
            String n = nombre.getText().trim();
            String c = cantidad.getText().trim();
            if (n.isEmpty() || c.isEmpty()) {
                JOptionPane.showMessageDialog(mainPanel, "El campo 'Nombre' y 'Cantidad' no pueden estar vacíos.");
                return;
            }
            if (!n.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
                JOptionPane.showMessageDialog(mainPanel, "El campo 'Nombre' solo puede contener letras y espacios, sin números ni caracteres especiales.");
                return;
            }
            try {
                int cant = Integer.parseInt(c);
                if (cant <= 0) throw new NumberFormatException();
                if (!valido && cant > 10000) {
                    throw new Exception("La cantidad es irrealmente alta para prueba negativa.");
                }
                animalesList.add(new Animales(n, cant));
                refreshTable();
                JOptionPane.showMessageDialog(mainPanel, "Animal agregado correctamente.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(mainPanel, "El campo 'Cantidad' debe ser un número entero positivo mayor que cero.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(mainPanel, ex.getMessage());
            }
        }
    }
    private void exportarResultados() {
        try {
            java.io.PrintWriter pw = new java.io.PrintWriter("animales_prueba_resultados.csv");
            pw.println("Nombre,Cantidad");
            for (Animales a : animalesList) {
                pw.println(a.getNombre() + "," + a.getCantidad());
            }
            pw.close();
            JOptionPane.showMessageDialog(mainPanel, "Resultados exportados correctamente a animales_prueba_resultados.csv");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(mainPanel, "Error al exportar resultados: " + ex.getMessage());
        }
    }
} 