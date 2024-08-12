package unitec.rpg.ui.windows;

import unitec.rpg.ui.PanelUI;
import unitec.rpg.ui.buttons.ExitButton;
import unitec.rpg.ui.buttons.StartButton;
import unitec.rpg.ui.cache.FontCache;
import unitec.rpg.ui.cache.ImageCache;
import unitec.rpg.ui.labels.PlayerLabel;

import javax.swing.*;
import java.awt.*;

public class NewGameWindow extends JFrame {

    private final int slot;
    private JPanel backgroundPanel;
    private JButton exitButton;
    private JButton startButton;
    private JTextArea welcomeText;
    private JTextField playerName;
    private JLabel playerLabel;
    private JLabel portraitLabel;


    public NewGameWindow(int slot) {

        this.slot = slot;
        setTitle("New Game");
        add(backgroundPanel);
        pack();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        welcomeText.append("¡Bienvenido al mundo de JavaRPG!\n");
        welcomeText.append("¿Estás listo para comenzar tu aventura?\n");
        welcomeText.append("¡Elige tu nombre de jugador y comencemos!");
        welcomeText.setOpaque(false);
        welcomeText.setEditable(false);
        welcomeText.setForeground(Color.WHITE);
        playerName.setForeground(Color.WHITE);
        playerLabel.setForeground(Color.WHITE);
        FontCache.addFont("Retron", "fonts/Retron2000.ttf");
        welcomeText.setFont(FontCache.getFont("Retron").deriveFont(14f));
        playerLabel.setFont(FontCache.getFont("Retron").deriveFont(14f));
        playerName.setFont(FontCache.getFont("Retron").deriveFont(14f));
        ((StartButton) startButton).setSlot(slot);
        backgroundPanel.setUI(new PanelUI());
    }

    private void createUIComponents() {

        portraitLabel = new PlayerLabel();
        startButton = new StartButton(this, slot);
        exitButton = new ExitButton();
    }

    public String getPlayerName() {

        return playerName.getText();
    }
}
