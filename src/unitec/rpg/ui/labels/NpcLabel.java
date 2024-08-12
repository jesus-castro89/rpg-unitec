package unitec.rpg.ui.labels;

import unitec.rpg.ui.dimensions.ElementsDimension;

import javax.swing.*;
import java.awt.*;

public class NpcLabel extends ImageLabel {

    private boolean isBoss;

    public NpcLabel(ImageIcon imageIcon, boolean isBoss) {
        super(imageIcon);
        setPreferredSize(ElementsDimension.NPC_LABEL);
        this.isBoss = isBoss;
    }

    public NpcLabel(ImageIcon imageIcon) {
        super(imageIcon);
        setPreferredSize(ElementsDimension.NPC_LABEL);
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        ImageIcon imageIcon = (ImageIcon) getIcon();
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        if (isBoss) {

            g2d.drawImage(imageIcon.getImage(), 0, 0, getWidth(), 180, null);
        } else {
            int originalWidth = imageIcon.getIconWidth();
            int originalHeight = imageIcon.getIconHeight();
            int newHeight = Math.min(originalHeight, 125);
            int newWidth = (originalWidth * newHeight) / originalHeight;
            int x = (getWidth() - newWidth) / 2;
            int y = getHeight() - newHeight;
            g2d.drawImage(imageIcon.getImage(), x, y, newWidth, newHeight, null);
        }
    }

    public void setBoss(boolean isBoss) {
        this.isBoss = isBoss;
    }
}
