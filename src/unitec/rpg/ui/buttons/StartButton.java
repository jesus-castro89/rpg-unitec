package unitec.rpg.ui.buttons;

import unitec.rpg.entities.Player;
import unitec.rpg.ui.windows.MainWindow;
import unitec.rpg.ui.windows.NewGameWindow;
import unitec.rpg.util.FileManager;

import java.io.File;

public class StartButton extends AbstractButton {

    private int slot;
    private NewGameWindow window;

    public StartButton(NewGameWindow window, int slot) {
        super("Start", false);
        this.slot = slot;
        this.window = window;
    }

    @Override
    public void addAction() {
        // Add action to start the game
        addActionListener(e -> {

            File file = new File("files/player" + slot + ".dat");
            if (file.exists()) {
                try {
                    Player player = FileManager.loadGame(slot);
                    window.dispose();
                    // Start the game
                    new MainWindow(player, slot);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                Player player = new Player(window.getPlayerName());
                // Close the new game window and open the game window
                window.dispose();
                // Start the game
                FileManager.saveGame(player, slot);
            }
        });
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }
}
