package unitec.rpg.ui.windows;

import unitec.rpg.entities.Enemy;
import unitec.rpg.entities.Player;
import unitec.rpg.entities.enums.Stats;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;

public class WelcomeWindow extends JFrame {

    private JPanel mainPanel;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JPanel topPanel;

    public WelcomeWindow() {

        super("Welcome to the RPG");
        topPanel.setPreferredSize(new Dimension(1280, 100));
        initTextArea();
        setContentPane(createDesktop());
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void initTextArea() {

        textArea.setText("""
                Bienvenido al RPG
                Este es un juego de rol en el que podrás crear tu propio personaje y vivir aventuras en un mundo de fantasía.
                ¡Que te diviertas!
                """);
        addTextToDesktop();
        textArea.setFont(new Font("Arial", Font.BOLD, 20));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(false);
        textArea.setAutoscrolls(true);
        scrollPane.setBorder(new LineBorder(new Color(0x803196BE, true), 5));
        scrollPane.setAutoscrolls(true);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setOpaque(false);
    }

    private JDesktopPane createDesktop() {

        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setOpaque(true);
        desktopPane.setPreferredSize(new Dimension(1280, 680));
        desktopPane.setSize(desktopPane.getPreferredSize());
        mainPanel.setBounds(0, 0, desktopPane.getWidth(), desktopPane.getHeight());
        mainPanel.setOpaque(true);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        desktopPane.add(mainPanel, JLayeredPane.DEFAULT_LAYER);
        return desktopPane;
    }

    private void addTextToDesktop() {

        Player player = new Player();
        String message;
        player.setName("Player");
        Enemy enemy = new Enemy();
        enemy.setName("Enemy");
        textArea.append(player.getName() + " vs " + enemy.getName() + "\n");
        while (player.isAlive() && enemy.isAlive()) {
            message = String.format("++++++++++++++++++++++++++\n%s HP: %d vs %s HP: %d\n++++++++++++++++++++++++++\n",
                    player.getName(), player.getStatus(Stats.HP), enemy.getName(), enemy.getStatus(Stats.HP));
            textArea.append(message);
            if (player.isAlive()) {
                message = player.attack(enemy);
                textArea.append(message);
            } else {
                message = String.format("%s ha muerto.\n", player.getName());
                textArea.append(message);
                break;
            }
            if (enemy.isAlive()) {
                message = enemy.attack(player);
                textArea.append(message);
            } else {
                message = String.format("%s ha muerto.\n", enemy.getName());
                textArea.append(message);
                message = enemy.dropLoot(player);
                textArea.append(message);
                break;
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
    }

    private void createUIComponents() {
        scrollPane = new JScrollPane() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Image image = new ImageIcon("img/ui/panel/textPanel.png").getImage();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.drawImage(new BufferedImage("img/ui/panel/textPanel.png", 0, 0, null), 0, 0, getWidth(), getHeight(), null);
            }
        };
    }
}