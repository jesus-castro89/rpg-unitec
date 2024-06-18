package unitec.rpg.ui.windows;

import unitec.rpg.entities.Enemy;
import unitec.rpg.entities.Player;
import unitec.rpg.entities.enums.Stats;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class WelcomeWindow extends JFrame {

    private JPanel mainPanel;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JButton button1;
    private JLabel hpBar;
    private JPanel hpPanel;
    private JPanel mpPanel;
    private JLabel mpBar;

    public WelcomeWindow() {

        super("Welcome to the RPG");
        initTextArea();
        setContentPane(createDesktop());
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JInternalFrame internalFrame = new JInternalFrame("Internal Frame", true, true, true, true);
                internalFrame.setBounds(0, 0, 640, 360);
                internalFrame.add(new JLabel("Internal Frame"));
                getContentPane().add(internalFrame);
                ((JDesktopPane) getContentPane()).setLayer(internalFrame, JLayeredPane.PALETTE_LAYER);
                internalFrame.setVisible(true);
            }
        });
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
        scrollPane.setAutoscrolls(true);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setOpaque(false);
    }

    private JDesktopPane createDesktop() {

        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setOpaque(true);
        desktopPane.setPreferredSize(new Dimension(1280, 720));
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
}