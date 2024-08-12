package unitec.rpg.ui.buttons;

import unitec.rpg.ui.buttons.events.FileListener;
import unitec.rpg.ui.windows.NewGameWindow;
import unitec.rpg.ui.windows.StartWindow;

import java.awt.*;

public class LoadGameButton extends AbstractButton {

    private final int slot;
    private final StartWindow startWindow;
    private final NewGameWindow newGameWindow;

    public LoadGameButton(int slot, StartWindow startWindow, NewGameWindow newGameWindow) {

        super("Cargar Partida", false);
        this.slot = slot;
        this.startWindow = startWindow;
        this.newGameWindow = newGameWindow;
        setForeground(Color.WHITE);
        addAction();
    }

    @Override
    public void addAction() {
        addActionListener(new FileListener(this, slot, startWindow, newGameWindow));
    }
}
