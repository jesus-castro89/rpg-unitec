package unitec.rpg.ui.buttons;

import java.awt.*;

public class ExitButton extends AbstractButton {

    public ExitButton() {
        super("Salir", false);
        setForeground(Color.WHITE);
        addAction();
    }

    @Override
    public void addAction() {

        addActionListener(e -> System.exit(0));
    }
}
