package amca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * Ventana principal tipo cPanel con sidebar y panel principal con CardLayout.
 * Los módulos se muestran como paneles dentro del mismo frame.
 */
public class MainFrame extends JFrame {
    private final JPanel mainPanel;
    private final CardLayout cardLayout;
    private final Map<String, JPanel> sidebarPanels = new HashMap<>();
    private final Map<String, JButton> sidebarButtons = new HashMap<>();
    private final Color sidebarBg = new Color(36, 41, 46);
    private final Color sidebarBtn = new Color(60, 65, 70);
    private final Color sidebarBtnHover = new Color(80, 85, 90);
    private final Color sidebarBtnSelected = new Color(100, 181, 246);
    private final Color sidebarText = new Color(230, 230, 230);
    private final Color sidebarTextSelected = Color.WHITE;
    private final Color accentBar = new Color(33, 150, 243);
    private String currentSection = "Cultivos";

    public MainFrame() {
        setTitle("AMCA - Apoyo al Mercado Campesino Agrícola");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 650);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(true);

        // Sidebar
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(sidebarBg);
        sidebar.setPreferredSize(new Dimension(220, 0));

        // Logo
        JLabel logo = new JLabel("AMCA", SwingConstants.CENTER);
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        logo.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidebar.add(logo);

        // Botones solo texto con barra de acento
        sidebar.add(createSidebarPanel("Cultivos"));
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(createSidebarPanel("Animales"));
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(createSidebarPanel("Preparados"));
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(createSidebarPanel("Sector Productivo"));
        sidebar.add(Box.createVerticalStrut(30));
        // Botones de prueba
        sidebar.add(createSidebarTestPanel("Prueba Cultivos", CultivosPruebaFrame.class));
        sidebar.add(Box.createVerticalStrut(5));
        sidebar.add(createSidebarTestPanel("Prueba Animales", AnimalesPruebaFrame.class));
        sidebar.add(Box.createVerticalStrut(5));
        sidebar.add(createSidebarTestPanel("Prueba Preparados", PreparadosPruebaFrame.class));
        sidebar.add(Box.createVerticalStrut(5));
        sidebar.add(createSidebarTestPanel("Prueba Sector", SectorProductivoPruebaFrame.class));
        sidebar.add(Box.createVerticalGlue());

        // Panel principal con CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(Color.WHITE);

        // Paneles de cada módulo con título
        mainPanel.add(wrapWithTitle(new CultivosFrame().getContentPanel(), "Cultivos"), "Cultivos");
        mainPanel.add(wrapWithTitle(new AnimalesFrame().getContentPanel(), "Animales"), "Animales");
        mainPanel.add(wrapWithTitle(new PreparadosFrame().getContentPanel(), "Preparados"), "Preparados");
        mainPanel.add(wrapWithTitle(new SectorProductivoFrame().getContentPanel(), "Sector Productivo"), "Sector Productivo");

        // Layout principal
        add(sidebar, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);

        // Mostrar panel por defecto
        setSidebarSelected("Cultivos");
        cardLayout.show(mainPanel, "Cultivos");
    }

    private JPanel wrapWithTitle(JPanel content, String title) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel(title, SwingConstants.LEFT);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 10));
        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(content, BorderLayout.CENTER);
        panel.setBackground(Color.WHITE);
        return panel;
    }

    private JPanel createSidebarPanel(String text) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setMaximumSize(new Dimension(220, 50));
        panel.setBackground(sidebarBtn);

        JPanel accent = new JPanel();
        accent.setPreferredSize(new Dimension(6, 50));
        accent.setBackground(sidebarBtn);
        panel.add(accent, BorderLayout.WEST);

        JButton btn = new JButton(text);
        btn.setFocusPainted(false);
        btn.setBackground(sidebarBtn);
        btn.setForeground(sidebarText);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btn.setBorder(BorderFactory.createEmptyBorder(12, 24, 12, 12));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setContentAreaFilled(false);
        btn.setOpaque(true);
        btn.setBorderPainted(false);
        sidebarButtons.put(text, btn);
        sidebarPanels.put(text, panel);

        btn.addActionListener(e -> {
            cardLayout.show(mainPanel, text);
            setSidebarSelected(text);
        });

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (!currentSection.equals(text)) {
                    btn.setBackground(sidebarBtnHover);
                    accent.setBackground(sidebarBtnHover);
                }
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (!currentSection.equals(text)) {
                    btn.setBackground(sidebarBtn);
                    accent.setBackground(sidebarBtn);
                }
            }
        });

        panel.add(btn, BorderLayout.CENTER);
        return panel;
    }

    private void setSidebarSelected(String section) {
        for (Map.Entry<String, JPanel> entry : sidebarPanels.entrySet()) {
            JButton btn = sidebarButtons.get(entry.getKey());
            JPanel accent = (JPanel) entry.getValue().getComponent(0);
            if (entry.getKey().equals(section)) {
                btn.setBackground(sidebarBtnSelected);
                btn.setForeground(sidebarTextSelected);
                accent.setBackground(accentBar);
            } else {
                btn.setBackground(sidebarBtn);
                btn.setForeground(sidebarText);
                accent.setBackground(sidebarBtn);
            }
        }
        currentSection = section;
    }

    // Agregar método para crear panel de prueba en la barra lateral
    private JPanel createSidebarTestPanel(String label, Class<?> frameClass) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JButton btn = new JButton(label);
        btn.setBackground(new Color(255, 193, 7));
        btn.setForeground(Color.BLACK);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        btn.addActionListener(e -> {
            try {
                Object frameObj = frameClass.getDeclaredConstructor().newInstance();
                JPanel contentPanel = (JPanel) frameClass.getMethod("getContentPanel").invoke(frameObj);
                JFrame testFrame = new JFrame(label);
                testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                testFrame.setSize(600, 400);
                testFrame.setLocationRelativeTo(null);
                testFrame.setContentPane(contentPanel);
                testFrame.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al abrir la interfaz de prueba: " + ex.getMessage());
            }
        });
        panel.add(btn, BorderLayout.CENTER);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
} 