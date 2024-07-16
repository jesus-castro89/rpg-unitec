package unitec.rpg.ui.panels;

import unitec.rpg.ui.dimensions.ElementsDimension;

import javax.swing.*;
import javax.swing.plaf.basic.BasicPanelUI;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PanelUI extends BasicPanelUI {

    @Override
    protected void installDefaults(JPanel p) {

        p.setOpaque(false);
        if (p.getName().equals("mainPanel")) {
            p.setBorder(ElementsDimension.MARGIN_BORDER);
        } else {
            p.setBorder(BorderFactory.createEmptyBorder());
        }
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {
        return switch (c.getName()) {
            case "topPanel" -> ElementsDimension.TOP_PANEL_SIZE;
            case "centerPanel" -> ElementsDimension.CENTER_PANEL_SIZE;
            case "bottomPanel" -> ElementsDimension.BOTTOM_PANEL_SIZE;
            case "dialogPanel" -> ElementsDimension.CONTAINER_SIZE;
            default -> ElementsDimension.WINDOW_SIZE;
        };
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        switch (c.getName()) {
            case "mainPanel" -> g2d.drawImage(new ImageIcon("img/panels/backgroundPanel.png").getImage(),
                    0, 0, c.getWidth(), c.getHeight(), null);
            case "topPanel" -> g2d.drawImage(new ImageIcon("img/panels/statusPanel.png").getImage(),
                    0, 0, c.getWidth(), c.getHeight(), null);
            case "centerPanel" -> g2d.drawImage(new ImageIcon("img/panels/mainBackground.png").getImage(),
                    0, 0, c.getWidth(), c.getHeight(), null);
            case "bottomPanel" -> g2d.drawImage(new ImageIcon("img/panels/battlePanel.png").getImage(),
                    0, 0, c.getWidth(), c.getHeight(), null);
            case "dialogPanel" -> g2d.drawImage(new ImageIcon("img/panels/skillPanel.png").getImage(),
                    0, 0, c.getWidth(), c.getHeight(), null);
        }
    }
}
