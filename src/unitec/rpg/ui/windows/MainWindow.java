package unitec.rpg.ui.windows;

import unitec.rpg.entities.Player;
import unitec.rpg.entities.enemies.Enemy;
import unitec.rpg.entities.enemies.EnemyFactory;
import unitec.rpg.entities.enums.Stats;
import unitec.rpg.ui.buttons.*;
import unitec.rpg.ui.cache.FontCache;
import unitec.rpg.ui.cache.ImageCache;
import unitec.rpg.ui.labels.*;
import unitec.rpg.ui.panels.DesktopUI;
import unitec.rpg.ui.PanelUI;
import unitec.rpg.util.FileManager;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;

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
    private JLabel nameLabel;
    private JLabel enemyName;
    private JDesktopPane desktopPane;
    private Player player;
    private Enemy enemy;
    private final int slot;

    public MainWindow(Player player, int slot) {

        this.player = player;
        setTitle("RPG Unitec");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createDesktop();
        setContentPane(desktopPane);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        this.slot = slot;
    }

    private void createDesktop() {

        desktopPane = new JDesktopPane();
        setUIElements();
        configDialog();
        setDimensions();
    }

    private void setDimensions() {
        // Configuramos los tamaños de los paneles.
        topPanel.setSize(topPanel.getPreferredSize());
        centerPanel.setSize(centerPanel.getPreferredSize());
        bottomPanel.setSize(bottomPanel.getPreferredSize());
        mainPanel.setBounds(0, 0, desktopPane.getWidth(), desktopPane.getHeight());
        desktopPane.add(mainPanel, JLayeredPane.DEFAULT_LAYER);
    }

    private void configDialog() {
        //Configuramos el cuadro de diálogo.
        dialogScroll.setOpaque(false);
        dialogScroll.getViewport().setOpaque(false);
        dialogScroll.getVerticalScrollBar().setOpaque(false);
        dialogScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        dialogScroll.setHorizontalScrollBar(null);
        dialogScroll.setBorder(BorderFactory.createEmptyBorder());
        dialogArea.setOpaque(false);
        FontCache.addFont("Pixellari", "fonts/Pixellari.ttf");
        dialogArea.setFont(FontCache.getFont("Pixellari").deriveFont(Font.PLAIN, 16f));
        dialogArea.setForeground(Color.WHITE);
        dialogArea.setEditable(false);
        dialogArea.setLineWrap(true);
        dialogArea.setWrapStyleWord(true);
        //Agregamos el texto inicial
        addText("¡Bienvenido a RPG Unitec!\n");
        addText("¡Hola, " + player.getName() + "!\n");
        addText("¡Tu aventura comienza ahora!\n");
    }

    private void setUIElements() {
        // Esto es lo que se conoce como "look and feel" (L&F) en Java.
        desktopPane.setUI(new DesktopUI());
        desktopPane.setSize(desktopPane.getPreferredSize());
        // Agregamos el look and feel a los paneles.
        mainPanel.setUI(new PanelUI());
        topPanel.setUI(new PanelUI());
        centerPanel.setUI(new PanelUI());
        bottomPanel.setUI(new PanelUI());
        dialogPanel.setUI(new PanelUI());
    }

    private void createUIComponents() {

        //Creamos las Etiquetas
        ImageCache.addImage("textLabel", "img/labels/name_label.png");
        FontCache.addFont("Retron", "fonts/Retron2000.ttf");
        nameLabel = new ImageLabel(ImageCache.getImageIcon("textLabel"));
        nameLabel.setText(player.getName() + " - Lvl. " + player.getLevel());
        nameLabel.setFont(FontCache.getFont("Retron").deriveFont(Font.BOLD, 12f));
        //Etiquetas
        ImageCache.addImage("portrait", "img/player/portrait.png");
        portraitLabel = new ImageLabel(ImageCache.getImageIcon("portrait"));
        lifeBar = new BarLabel(BarType.LIFE, player.getStatus(Stats.HP), player.getStatus(Stats.MAX_HP));
        magicBar = new BarLabel(BarType.MAGIC, player.getStatus(Stats.MP), player.getStatus(Stats.MAX_MP));
        expBar = new BarLabel(BarType.EXPERIENCE, player.getExperience(), player.getExperienceToNextLevel());
        playerLabel = new PlayerLabel();
        goldLabel = new GoldLabel();
        ((GoldLabel) goldLabel).setGold(player.getGold());
        //Creamos un enemigo
        enemy = EnemyFactory.generateRegularEnemy(player);
        enemyName = new ImageLabel(ImageCache.getImageIcon("textLabel"));
        enemyName.setText(enemy != null ? enemy.getName() : null);
        enemyName.setFont(FontCache.getFont("Retron").deriveFont(Font.BOLD, 16f));
        enemyBar = new BarLabel(BarType.LIFE, enemy != null ? enemy.getStatus(Stats.HP) : 0,
                enemy != null ? enemy.getStatus(Stats.MAX_HP) : 0);
        //Creamos la etiqueta del enemigo
        npcLabel = new NpcLabel(enemy != null ? enemy.getImage() : null, enemy != null && enemy.isBoss());
        //Botones
        inventoryButton = new InventoryButton(this);
        shopButton = new ShopButton();
        blackSmithButton = new BlackSmithButton();
        attackButton = new AttackButton(this, enemy, player);
        fleeButton = new FleeButton(this, enemy, player);
        saveButton = new SaveButton(this);
        exitButton = new ExitButton();
    }

    public void addText(String text) {

        SwingUtilities.invokeLater(() -> {
            dialogArea.append(text);
            dialogArea.setCaretPosition(dialogArea.getDocument().getLength());
        });
    }

    public void saveGame() {

        FileManager.saveGame(player, slot);
        addText("¡Partida guardada!\n");
    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }

    public Player getPlayer() {
        return player;
    }

    public void setEnemy(Enemy enemy) {

        this.enemy = enemy;
        enemyName.setText(enemy.getName());
        ((BarLabel) enemyBar).setMaxValue(enemy.getStatus(Stats.MAX_HP));
        ((BarLabel) enemyBar).setBarValue(enemy.getStatus(Stats.HP));
        ((ImageLabel) npcLabel).setIcon(enemy.getImage());
        ((NpcLabel) npcLabel).setBoss(enemy.isBoss());
        enemyBar.repaint();
        npcLabel.repaint();
        enemyName.repaint();
    }

    public void updateBars() {

        ((BarLabel) lifeBar).setMaxValue(player.getStatus(Stats.MAX_HP));
        ((BarLabel) lifeBar).setBarValue(player.getStatus(Stats.HP));
        ((BarLabel) magicBar).setMaxValue(player.getStatus(Stats.MAX_MP));
        ((BarLabel) magicBar).setBarValue(player.getStatus(Stats.MP));
        ((BarLabel) expBar).setMaxValue(player.getExperienceToNextLevel());
        ((BarLabel) expBar).setBarValue(player.getExperience());
        ((GoldLabel) goldLabel).setGold(player.getGold());
        lifeBar.repaint();
        magicBar.repaint();
        expBar.repaint();
        enemyName.setText(enemy.getName());
        ((BarLabel) enemyBar).setMaxValue(enemy.getStatus(Stats.MAX_HP));
        ((BarLabel) enemyBar).setBarValue(enemy.getStatus(Stats.HP));
        enemyBar.repaint();
        enemyName.repaint();
        goldLabel.repaint();
        nameLabel.setText(player.getName() + " - Lvl. " + player.getLevel());
        nameLabel.repaint();
    }
}
