package unitec.rpg.ui.windows;

import unitec.rpg.ui.labels.BarLabel;
import unitec.rpg.ui.labels.BarType;
import unitec.rpg.ui.labels.ImageLabel;
import unitec.rpg.ui.panels.DesktopUI;
import unitec.rpg.ui.panels.InternalFrameUI;
import unitec.rpg.ui.panels.PanelUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel bottomPanel;
    private JLabel portraitLabel;
    private JLabel lifeBar;
    private JLabel magicBar;
    private JLabel expBar;
    private JButton button1;
    private JLabel npcLabel;
    private JLabel playerLabel;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JTextArea TEXTOTextArea;
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
        playerLabel.setBorder(new LineBorder(Color.BLUE, 5));
        npcLabel.setBorder(new LineBorder(Color.RED, 5));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JInternalFrame internalFrame = new JInternalFrame("Internal Frame",
                        false, true, false, false);
                internalFrame.setUI(new InternalFrameUI(internalFrame));
                internalFrame.setSize(640, 200);
                internalFrame.setLocation(50, 50);
                internalFrame.setVisible(true);
                internalFrame.setBorder(null);
                desktopPane.add(internalFrame, JLayeredPane.PALETTE_LAYER);
            }
        });
    }

    private void createDesktop() {

        desktopPane = new JDesktopPane();
        // Esto es lo que se conoce como "look and feel" (L&F) en Java.
        desktopPane.setUI(new DesktopUI());
        desktopPane.setSize(desktopPane.getPreferredSize());
        // Agregamos el look and feel a los paneles.
        mainPanel.setUI(new PanelUI());
        topPanel.setUI(new PanelUI());
        centerPanel.setUI(new PanelUI());
        bottomPanel.setUI(new PanelUI());
        // Configuramos los tamaños de los paneles.
        topPanel.setSize(topPanel.getPreferredSize());
        topPanel.setBorder(new LineBorder(Color.BLACK, 5));
        centerPanel.setSize(centerPanel.getPreferredSize());
        centerPanel.setBorder(new LineBorder(Color.BLACK, 5));
        bottomPanel.setSize(bottomPanel.getPreferredSize());
        bottomPanel.setBorder(new LineBorder(Color.BLACK, 5));
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
