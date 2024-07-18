package unitec.rpg.ui.buttons;

import unitec.rpg.ui.ButtonUI;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractButton extends JButton {

    public AbstractButton(String text, boolean player) {

        super(text);
        setUI(new ButtonUI(player));
    }

    public abstract void addAction();

    @Override
    public Dimension getSize(Dimension rv) {

        return getPreferredSize();
    }
}
