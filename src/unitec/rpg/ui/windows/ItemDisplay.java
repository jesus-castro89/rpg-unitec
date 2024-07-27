package unitec.rpg.ui.windows;

import unitec.rpg.ui.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

public class ItemDisplay extends JPanel {
    private JLabel itemIamge;
    private JLabel itemNameCost;
    private JLabel itemDescription;
    private JPanel mainPanel;

    public ItemDisplay() {

        add(mainPanel);
        setSize(new Dimension(150, 50));
        itemIamge.setIcon(ImageCache.getImageIcon("inventoryIdle"));
    }
}
