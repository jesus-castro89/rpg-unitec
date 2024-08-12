package unitec.rpg.ui.buttons;

import unitec.rpg.entities.Player;
import unitec.rpg.ui.windows.MainWindow;
import unitec.rpg.ui.windows.NewGameWindow;
import unitec.rpg.util.FileManager;

import java.awt.*;
import java.io.File;

public class StartButton extends AbstractButton {

    private int slot;
    private NewGameWindow window;

    public StartButton(NewGameWindow window, int slot) {

        super("Start", false);
        this.slot = slot;
        this.window = window;
        setForeground(Color.WHITE);
        addAction();
    }

    @Override
    public void addAction() {
        // Add action to start the game
        addActionListener(e -> {

            File file = new File("files/player_" + slot + ".dat");
            Player player = null;
            if (file.exists()) {
                try {
                    player = FileManager.loadGame(slot);
                    window.dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                player = new Player(window.getPlayerName());
                window.dispose();
                FileManager.saveGame(player, slot);
            }
            startGame(player);
        });
    }

    private void startGame(Player player) {
        // Start the game
        MainWindow mainWindow = new MainWindow(player, slot);
        mainWindow.setVisible(true);
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }
}
