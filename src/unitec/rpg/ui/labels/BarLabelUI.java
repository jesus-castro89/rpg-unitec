package unitec.rpg.ui.labels;

import unitec.rpg.ui.cache.FontCache;
import unitec.rpg.ui.dimensions.ElementsDimension;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;

public class BarLabelUI extends BasicLabelUI {

    private BarType type;

    public BarLabelUI(BarType type) {

        this.type = type;
        //Esto permite agregar una fuente con su nombre y la dirección al archivo a la que hace referencia
        FontCache.addFont("Gamer", "fonts/Gamer.ttf");
    }

    private int getBarValue(JLabel c) {
        return ((BarLabel) c).getBarValue();
    }

    private int getMaxBarValue(JLabel c) {
        return ((BarLabel) c).getMaxValue();
    }

    private int getBarWidth(JLabel c) {

        int value = getBarValue(c);
        int max = getMaxBarValue(c);
        if (value > max) {
            value = max;
        }
        if (value>0 && value <= 25) {
            value = 18;
        }
        return (int) (value * 1.0 / max * 130);
    }

    @Override
    protected void installDefaults(JLabel c) {

        c.setForeground(new Color(241, 229, 227));
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
        g2d.drawImage(type.getContainer().getImage(), c.getWidth() - 150, 1, 150, 50, null);
        g2d.drawImage(type.getBar().getImage(), 32, 10, getBarWidth((JLabel) c), 14, null);
        g2d.drawImage(type.getIcon().getImage(), 0, 0, 51, 51, null);
        g2d.setColor(Color.BLACK);
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
