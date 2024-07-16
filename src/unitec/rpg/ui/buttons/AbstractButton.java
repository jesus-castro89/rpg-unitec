package unitec.rpg.ui.buttons;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractButton extends JButton {

    public AbstractButton(String text, boolean player) {

        super(text);
        setUI(new GameButtonUI(player));
    }

    public abstract void addAction();

    @Override
    public Dimension getSize(Dimension rv) {

        return getPreferredSize();
    }
}
