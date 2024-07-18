package unitec.rpg.ui.panels;

import unitec.rpg.ui.cache.ImageCache;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {

    private final ImageIcon background;

    public ImagePanel(String name, String path, int width, int height) {

        background = new ImageIcon(ImageCache.addImage(name, path));
        setPreferredSize(new Dimension(width, height));
        setSize(getPreferredSize());
        setOpaque(false);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), null);
        g2d.dispose();
    }
}
