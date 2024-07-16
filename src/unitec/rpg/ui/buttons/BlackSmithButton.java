package unitec.rpg.ui.buttons;

import javax.swing.*;

public class BlackSmithButton extends AbstractButton {

    public BlackSmithButton() {
        super("Herrero", true);
        setIcon(new ImageIcon("img/icons/blackSmithIdle.png"));
        setRolloverIcon(new ImageIcon("img/icons/blackSmithHover.png"));
    }

    @Override
    public void addAction() {

    }
}
