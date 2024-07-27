package unitec.rpg.ui.buttons;

import unitec.rpg.ui.cache.ImageCache;
import unitec.rpg.ui.windows.Inventory;
import unitec.rpg.ui.windows.MainWindow;

import javax.swing.*;

public class InventoryButton extends AbstractButton {

    private MainWindow mainWindow;

    public InventoryButton(MainWindow mainWindow) {

        super("Inventario", true);
        this.mainWindow = mainWindow;
        ImageCache.addImage("inventoryIdle", "img/icons/inventoryIdle.png");
        setIcon(ImageCache.getImageIcon("inventoryIdle"));
        setRolloverIcon(new ImageIcon("img/icons/inventoryHover.png"));
        addAction();
    }

    @Override
    public void addAction() {
        addActionListener(e -> {
            JInternalFrame inventory = new JInternalFrame("Inventario", true, true, true, true);
            inventory.setContentPane(new Inventory());
            inventory.setSize(400, 200);
            inventory.setLocation(50, 50);
            inventory.setVisible(true);
            mainWindow.getDesktopPane().add(inventory, JLayeredPane.PALETTE_LAYER);
        });
    }
}
