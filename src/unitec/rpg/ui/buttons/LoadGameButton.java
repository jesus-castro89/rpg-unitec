package unitec.rpg.ui.buttons;

import unitec.rpg.ui.buttons.events.FileListener;
import unitec.rpg.ui.windows.NewGameWindow;
import unitec.rpg.ui.windows.StartWindow;

public class LoadGameButton extends AbstractButton {

    private int slot;
    private StartWindow startWindow;
    private NewGameWindow newGameWindow;

    public LoadGameButton(int slot, StartWindow startWindow, NewGameWindow newGameWindow) {

        super("Cargar Partida", false);
    }

    @Override
    public void addAction() {
        addActionListener(new FileListener(this, slot, startWindow, newGameWindow));
    }
}
