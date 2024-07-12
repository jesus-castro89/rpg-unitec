package unitec.rpg.ui.windows;

import unitec.rpg.ui.labels.BarLabel;
import unitec.rpg.ui.labels.BarType;
import unitec.rpg.ui.labels.ImageLabel;
import unitec.rpg.ui.panels.DesktopUI;
import unitec.rpg.ui.panels.PanelUI;

import javax.swing.*;

public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel bottomPanel;
    private JLabel portraitLabel;
    private JLabel lifeBar;
    private JLabel magicBar;
    private JLabel expBar;
    private JDesktopPane desktopPane;

    public MainWindow() {
        super("RPG Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createDesktop();
        setContentPane(desktopPane);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void createDesktop() {

        desktopPane = new JDesktopPane();
        desktopPane.setUI(new DesktopUI());
        desktopPane.setSize(desktopPane.getPreferredSize());
        mainPanel.setUI(new PanelUI());
        topPanel.setUI(new PanelUI());
        topPanel.setSize(topPanel.getPreferredSize());
        centerPanel.setUI(new PanelUI());
        centerPanel.setSize(centerPanel.getPreferredSize());
        bottomPanel.setUI(new PanelUI());
        bottomPanel.setSize(bottomPanel.getPreferredSize());
        mainPanel.setBounds(0, 0, desktopPane.getWidth(), desktopPane.getHeight());
        desktopPane.add(mainPanel, JLayeredPane.DEFAULT_LAYER);
    }

    private void createUIComponents() {
        portraitLabel = new ImageLabel(new ImageIcon("img/player/portrait.png"));
        lifeBar = new BarLabel(BarType.LIFE);
        magicBar = new BarLabel(BarType.MAGIC);
        expBar = new BarLabel(BarType.EXPERIENCE);
    }
}
