package amca;

import modelo.Preparados;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PreparadosPruebaFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private List<Preparados> preparadosList;
    private JPanel mainPanel;
    private static final int MAX_PRODUCTO = 20;

    public PreparadosPruebaFrame() {
        mainPanel = new JPanel(new BorderLayout());
        preparadosList = new ArrayList<>();
        String[] columns = {"Finca", "Tipo", "Producto", "Cantidad"};
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

        addValidBtn.addActionListener(e -> addPreparado(true));
        addInvalidBtn.addActionListener(e -> addPreparado(false));
        clearBtn.addActionListener(e -> {
            preparadosList.clear();
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
        for (Preparados p : preparadosList) {
            tableModel.addRow(new Object[]{p.getNombreFinca(), p.getTipo(), p.getNombreProducto(), p.getCantidad()});
        }
    }

    private void addPreparado(boolean valido) {
        JTextField finca = new JTextField();
        JTextField tipo = new JTextField();
        JTextField producto = new JTextField();
        JTextField cantidad = new JTextField();
        Object[] fields = {"Finca:", finca, "Tipo:", tipo, "Producto:", producto, "Cantidad:", cantidad};
        int res = JOptionPane.showConfirmDialog(mainPanel, fields, (valido ? "Agregar Preparado Válido" : "Agregar Preparado Inválido"), JOptionPane.OK_CANCEL_OPTION);
        if (res == JOptionPane.OK_OPTION) {
            String f = finca.getText().trim();
            String t = tipo.getText().trim();
            String p = producto.getText().trim();
            String c = cantidad.getText().trim();
            if (f.isEmpty() || t.isEmpty() || p.isEmpty() || c.isEmpty()) {
                JOptionPane.showMessageDialog(mainPanel, "Ningún campo puede estar vacío.");
                return;
            }
            if (p.length() > MAX_PRODUCTO) {
                JOptionPane.showMessageDialog(mainPanel, "El campo 'Producto' no debe exceder 20 caracteres.");
                return;
            }
            try {
                int cant = Integer.parseInt(c);
                if (cant <= 0) throw new NumberFormatException();
                if (!valido && cant > 10000) {
                    throw new Exception("La cantidad es irrealmente alta para prueba negativa.");
                }
                preparadosList.add(new Preparados(f, t, p, cant));
                refreshTable();
                JOptionPane.showMessageDialog(mainPanel, "Preparado agregado correctamente.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(mainPanel, "El campo 'Cantidad' debe ser un número entero positivo mayor que cero.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(mainPanel, ex.getMessage());
            }
        }
    }
    private void exportarResultados() {
        try {
            java.io.PrintWriter pw = new java.io.PrintWriter("preparados_prueba_resultados.csv");
            pw.println("Finca,Tipo,Producto,Cantidad");
            for (Preparados p : preparadosList) {
                pw.println(p.getNombreFinca() + "," + p.getTipo() + "," + p.getNombreProducto() + "," + p.getCantidad());
            }
            pw.close();
            JOptionPane.showMessageDialog(mainPanel, "Resultados exportados correctamente a preparados_prueba_resultados.csv");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(mainPanel, "Error al exportar resultados: " + ex.getMessage());
        }
    }
} 