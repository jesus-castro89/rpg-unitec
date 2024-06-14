package unitec.rpg.ui.windows;

import unitec.rpg.entities.Enemy;
import unitec.rpg.entities.Player;

import javax.swing.*;
import java.awt.*;

public class WelcomeWindow extends JFrame {

    private JPanel mainPanel;
    private JTextArea textArea;
    private JScrollPane scrollPane;

    public WelcomeWindow() {

        super("Welcome to the RPG");
        initTextArea();
        createDesktop();
        add(mainPanel);
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
        textArea.setFont(new Font("Arial", Font.BOLD, 16));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(false);
        textArea.setAutoscrolls(true);
        scrollPane.setAutoscrolls(true);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setOpaque(false);
    }

    private void createDesktop() {

        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setPreferredSize(new Dimension(1280, 680));
        desktopPane.setSize(desktopPane.getPreferredSize());
        mainPanel.setPreferredSize(desktopPane.getPreferredSize());
        desktopPane.add(mainPanel, JLayeredPane.DEFAULT_LAYER);
        desktopPane.setVisible(true);
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
                    player.getName(), player.getHP(), enemy.getName(), enemy.getHP());
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
}