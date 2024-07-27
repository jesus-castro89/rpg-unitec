package unitec.rpg.ui.windows;

import unitec.rpg.ui.buttons.*;
import unitec.rpg.ui.labels.*;
import unitec.rpg.ui.panels.DesktopUI;
import unitec.rpg.ui.PanelUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel bottomPanel;
    private JLabel portraitLabel;
    private JLabel lifeBar;
    private JLabel magicBar;
    private JLabel expBar;
    private JButton inventoryButton;
    private JLabel npcLabel;
    private JLabel playerLabel;
    private JButton attackButton;
    private JButton saveButton;
    private JButton fleeButton;
    private JButton exitButton;
    private JTextArea dialogArea;
    private JPanel dialogPanel;
    private JScrollPane dialogScroll;
    private JLabel goldLabel;
    private JButton shopButton;
    private JButton blackSmithButton;
    private JLabel enemyBar;
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
        npcLabel.setBorder(new LineBorder(Color.BLACK, 1));
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
        dialogPanel.setUI(new PanelUI());
        //Configuramos el cuadro de diálogo.
        dialogScroll.setOpaque(false);
        dialogScroll.getViewport().setOpaque(false);
        dialogScroll.getVerticalScrollBar().setOpaque(false);
        dialogScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        dialogScroll.setHorizontalScrollBar(null);
        dialogScroll.setBorder(BorderFactory.createEmptyBorder());
        dialogArea.setOpaque(false);
        dialogArea.setFont(new Font("Arial", Font.PLAIN, 14));
        dialogArea.setForeground(Color.WHITE);
        dialogArea.setEditable(false);
        dialogArea.setLineWrap(true);
        dialogArea.setWrapStyleWord(true);
        // Configuramos los tamaños de los paneles.
        topPanel.setSize(topPanel.getPreferredSize());
        centerPanel.setSize(centerPanel.getPreferredSize());
        bottomPanel.setSize(bottomPanel.getPreferredSize());
        mainPanel.setBounds(0, 0, desktopPane.getWidth(), desktopPane.getHeight());
        desktopPane.add(mainPanel, JLayeredPane.DEFAULT_LAYER);
    }

    private void createUIComponents() {
        //Etiquetas
        portraitLabel = new ImageLabel(new ImageIcon("img/player/portrait.png"));
        lifeBar = new BarLabel(BarType.LIFE);
        enemyBar= new BarLabel(BarType.LIFE);
        magicBar = new BarLabel(BarType.MAGIC);
        expBar = new BarLabel(BarType.EXPERIENCE);
        playerLabel = new PlayerLabel();
        goldLabel = new GoldLabel();
        npcLabel = new NpcLabel("img/npc/blacksmith/1.png");
        //Botones
        inventoryButton = new InventoryButton(this);
        shopButton = new ShopButton();
        blackSmithButton = new BlackSmithButton();
        attackButton = new AttackButton();
        fleeButton = new FleeButton();
        saveButton = new SaveButton();
        exitButton = new ExitButton();
    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }
}
