package unitec.rpg.ui.buttons;

import javax.swing.*;

public class InventoryButton extends AbstractButton {

    public InventoryButton() {

        super("Inventario", true);
        setIcon(new ImageIcon("img/icons/inventoryIdle.png"));
        setRolloverIcon(new ImageIcon("img/icons/inventoryHover.png"));
    }

    @Override
    public void addAction() {

    }
}
