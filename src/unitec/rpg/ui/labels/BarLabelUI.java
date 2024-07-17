package unitec.rpg.ui.labels;

import unitec.rpg.ui.dimensions.ElementsDimension;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;

public class BarLabelUI extends BasicLabelUI {

    @Override
    protected void installDefaults(JLabel c) {

        c.setOpaque(false);
        c.setForeground(Color.WHITE);
        c.setVerticalTextPosition(SwingConstants.BOTTOM);
        c.setHorizontalTextPosition(SwingConstants.RIGHT);
        c.setIconTextGap(30);
    }

    @Override
    public void paint(Graphics g, JComponent c) {

        Graphics2D g2d = (Graphics2D) g;
        int textX = (getPreferredSize(c).width - c.getFontMetrics(c.getFont()).stringWidth(((JLabel) c).getText())) / 2;
        int textY = getPreferredSize(c).height - c.getFontMetrics(c.getFont()).getHeight() / 2;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.drawImage(((ImageIcon) ((JLabel) c).getIcon()).getImage(), 0, 0,
                getPreferredSize(c).width, getPreferredSize(c).height, null);
        paintEnabledText((JLabel) c, g, ((JLabel) c).getText(), textX, textY);
    }

    @Override
    protected void paintEnabledText(JLabel l, Graphics g, String s, int textX, int textY) {

        textX = l.getIconTextGap() +
                ((ElementsDimension.BAR_LABEL.width - l.getFontMetrics(l.getFont()).stringWidth(s)) / 2);
        textY = (ElementsDimension.BAR_LABEL.height - l.getFontMetrics(l.getFont()).getHeight() / 2)
                + 5;
        super.paintEnabledText(l, g, s, textX, textY);
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {
        return ElementsDimension.BAR_LABEL;
    }
}
