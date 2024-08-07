package unitec.rpg.ui.buttons;

import unitec.rpg.ui.windows.MainWindow;

import java.awt.*;

public class SaveButton extends AbstractButton {

    private final MainWindow window;

    public SaveButton(MainWindow window) {
        super("Guardar", false);
        this.window = window;
        setForeground(Color.WHITE);
        addAction();
    }

    @Override
    public void addAction() {

        addActionListener(e -> window.saveGame());
    }
}
