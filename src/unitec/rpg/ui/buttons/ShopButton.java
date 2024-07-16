package unitec.rpg.ui.buttons;

import javax.swing.*;

public class ShopButton extends AbstractButton {

    public ShopButton() {
        super("Tienda", true);
        setIcon(new ImageIcon("img/icons/shopIdle.png"));
        setRolloverIcon(new ImageIcon("img/icons/shopHover.png"));
    }

    @Override
    public void addAction() {

    }
}
