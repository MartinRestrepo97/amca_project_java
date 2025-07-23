package amca;

import modelo.Cultivos;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CultivosPruebaFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private List<Cultivos> cultivosList;
    private JPanel mainPanel;

    public CultivosPruebaFrame() {
        mainPanel = new JPanel(new BorderLayout());
        cultivosList = new ArrayList<>();
        String[] columns = {"Nombre", "Hectáreas"};
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

        addValidBtn.addActionListener(e -> addCultivo(true));
        addInvalidBtn.addActionListener(e -> addCultivo(false));
        clearBtn.addActionListener(e -> {
            cultivosList.clear();
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
        for (Cultivos c : cultivosList) {
            tableModel.addRow(new Object[]{c.getNombre(), c.getExtended()});
        }
    }

    private void addCultivo(boolean valido) {
        JTextField nombre = new JTextField();
        JTextField hectareas = new JTextField();
        Object[] fields = {"Nombre:", nombre, "Hectáreas:", hectareas};
        int res = JOptionPane.showConfirmDialog(mainPanel, fields, (valido ? "Agregar Cultivo Válido" : "Agregar Cultivo Inválido"), JOptionPane.OK_CANCEL_OPTION);
        if (res == JOptionPane.OK_OPTION) {
            String n = nombre.getText().trim();
            String h = hectareas.getText().trim();
            if (n.isEmpty() || h.isEmpty()) {
                JOptionPane.showMessageDialog(mainPanel, "El campo 'Nombre' y 'Hectáreas' no pueden estar vacíos.");
                return;
            }
            if (!n.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
                JOptionPane.showMessageDialog(mainPanel, "El campo 'Nombre' solo puede contener letras y espacios, sin números ni caracteres especiales.");
                return;
            }
            try {
                int hect = Integer.parseInt(h);
                if (hect <= 0) throw new NumberFormatException();
                if (!valido && hect > 10000) {
                    throw new Exception("El valor de hectáreas es irrealmente alto para prueba negativa.");
                }
                cultivosList.add(new Cultivos(n, hect));
                refreshTable();
                JOptionPane.showMessageDialog(mainPanel, "Cultivo agregado correctamente.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(mainPanel, "El campo 'Hectáreas' debe ser un número entero positivo mayor que cero.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(mainPanel, ex.getMessage());
            }
        }
    }
    private void exportarResultados() {
        try {
            java.io.PrintWriter pw = new java.io.PrintWriter("cultivos_prueba_resultados.csv");
            pw.println("Nombre,Hectáreas");
            for (Cultivos c : cultivosList) {
                pw.println(c.getNombre() + "," + c.getExtended());
            }
            pw.close();
            JOptionPane.showMessageDialog(mainPanel, "Resultados exportados correctamente a cultivos_prueba_resultados.csv");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(mainPanel, "Error al exportar resultados: " + ex.getMessage());
        }
    }
} 