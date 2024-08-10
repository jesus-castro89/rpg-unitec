package unitec.rpg.ui.buttons;

import unitec.rpg.ui.buttons.events.FileListener;
import unitec.rpg.ui.windows.NewGameWindow;
import unitec.rpg.ui.windows.StartWindow;

import java.awt.*;

public class NewGameButton extends AbstractButton {

    private int slot;
    private NewGameWindow newGameWindow;
    private StartWindow startWindow;

    public NewGameButton(int slot, StartWindow startWindow, NewGameWindow newGameWindow) {

        super("Nueva Partida", false);
        this.slot = slot;
        setForeground(Color.WHITE);
    }

    @Override
    public void addAction() {
        // Add action to start a new game
        addActionListener(new FileListener(this, slot, startWindow, newGameWindow));
    }
}
