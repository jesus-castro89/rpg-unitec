package unitec.rpg.ui.labels;

import unitec.rpg.ui.dimensions.ElementsDimension;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GoldLabel extends ImageLabel {

    public GoldLabel() {
        super(new ImageIcon("img/labels/goldLabel.png"));
        setText(0 + " G");
        setIconTextGap(55);
        setVerticalTextPosition(SwingConstants.CENTER);
        setHorizontalTextPosition(SwingConstants.CENTER);
        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT,
                    new File("fonts/Gamer.ttf")).deriveFont(35f);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
        setFont(font);
    }

    @Override
    public Dimension getPreferredSize() {
        return ElementsDimension.BAR_LABEL;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int textX = getIconTextGap();
        int textY = getPreferredSize().height / 2 + getFontMetrics(getFont()).getHeight() / 4;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.drawImage(((ImageIcon) getIcon()).getImage(), 0,0,
                getPreferredSize().width, getPreferredSize().height, null);
        g2d.drawString(getText(), textX, textY);
    }
}
