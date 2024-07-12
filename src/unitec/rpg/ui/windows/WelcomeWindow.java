package unitec.rpg.ui.windows;

import unitec.rpg.ui.panels.DesktopUI;

import javax.swing.*;
import java.awt.*;

public class WelcomeWindow extends JFrame {

    private JPanel mainPanel;

    public WelcomeWindow() {

        super("Welcome to the RPG");
        setContentPane(createDesktop());
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private JDesktopPane createDesktop() {

        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setUI(new DesktopUI());
        mainPanel.setBackground(Color.RED);
        mainPanel.setBounds(0, 0, desktopPane.getWidth(), desktopPane.getHeight());
        mainPanel.setOpaque(true);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        desktopPane.add(mainPanel, JLayeredPane.DEFAULT_LAYER);
        return desktopPane;
    }
}