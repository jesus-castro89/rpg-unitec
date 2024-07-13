package unitec.rpg.ui.panels;

import javax.swing.*;
import java.awt.*;

public class InventoryPanel extends JPanel {
    private JPanel mainPanel;

    public InventoryPanel() {

        add(mainPanel);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        ImageIcon imageIcon = new ImageIcon("img/panels/background.png");
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
        g2d.dispose();
    }
}
