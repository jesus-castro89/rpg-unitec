package unitec.rpg.ui.buttons;

import unitec.rpg.utils.ImageCache;
import unitec.rpg.utils.ImageLoader;

import javax.swing.*;
import javax.swing.AbstractButton;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameButtonUI extends BasicButtonUI {

    /**
     * Indica si el botón es de un jugador o del juego.
     */
    private final boolean player;
    /**
     * Imágenes de los lados del botón.
     */
    private BufferedImage leftSide, centerSide, rightSide;

    public GameButtonUI(boolean player) {

        this.player = player;
        loadCache();
    }

    private static void loadCache() {

        // Imágenes de los botones de los lados. Para el jugador, en modo idle
        ImageCache.addImage("leftSidePlayerIdle",
                ImageLoader.loadImage("img/buttons/idle/user/leftSide.png"));
        ImageCache.addImage("centerSidePlayerIdle",
                ImageLoader.loadImage("img/buttons/idle/user/centerSide.png"));
        ImageCache.addImage("rightSidePlayerIdle",
                ImageLoader.loadImage("img/buttons/idle/user/rightSide.png"));
        // Imágenes de los botones de los lados. Para el jugador, en modo hover
        ImageCache.addImage("leftSidePlayerHover",
                ImageLoader.loadImage("img/buttons/hover/user/leftSide.png"));
        ImageCache.addImage("centerSidePlayerHover",
                ImageLoader.loadImage("img/buttons/hover/user/centerSide.png"));
        ImageCache.addImage("rightSidePlayerHover",
                ImageLoader.loadImage("img/buttons/hover/user/rightSide.png"));
        // Imágenes de los botones de los lados. Para el juego, en modo idle
        ImageCache.addImage("leftSideGameIdle",
                ImageLoader.loadImage("img/buttons/idle/ui/leftSide.png"));
        ImageCache.addImage("centerSideGameIdle",
                ImageLoader.loadImage("img/buttons/idle/ui/centerSide.png"));
        ImageCache.addImage("rightSideGameIdle",
                ImageLoader.loadImage("img/buttons/idle/ui/rightSide.png"));
        // Imágenes de los botones de los lados. Para el juego, en modo hover
        ImageCache.addImage("leftSideGameHover",
                ImageLoader.loadImage("img/buttons/hover/ui/leftSide.png"));
        ImageCache.addImage("centerSideGameHover",
                ImageLoader.loadImage("img/buttons/hover/ui/centerSide.png"));
        ImageCache.addImage("rightSideGameHover",
                ImageLoader.loadImage("img/buttons/hover/ui/rightSide.png"));
    }

    private void loadIdleImages() {

        leftSide = player ? ImageCache.getImage("leftSidePlayerIdle") :
                ImageCache.getImage("leftSideGameIdle");
        centerSide = player ? ImageCache.getImage("centerSidePlayerIdle") :
                ImageCache.getImage("centerSideGameIdle");
        rightSide = player ? ImageCache.getImage("rightSidePlayerIdle") :
                ImageCache.getImage("rightSideGameIdle");
    }

    private void loadHoverImages() {

        leftSide = player ? ImageCache.getImage("leftSidePlayerHover") :
                ImageCache.getImage("leftSideGameHover");
        centerSide = player ? ImageCache.getImage("centerSidePlayerHover") :
                ImageCache.getImage("centerSideGameHover");
        rightSide = player ? ImageCache.getImage("rightSidePlayerHover") :
                ImageCache.getImage("rightSideGameHover");
    }

    @Override
    protected void installDefaults(AbstractButton b) {

        b.setDoubleBuffered(true);
        b.setOpaque(false);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setContentAreaFilled(false);
        b.setIconTextGap(5);
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Retron2000.ttf")).deriveFont(Font.BOLD, 14f);
            b.setFont(font);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {

        int width = Math.max(c.getFontMetrics(c.getFont()).stringWidth(((JButton) c).getText()) + 60, 80);
        return new Dimension(width, 48);
    }

    @Override
    public void paint(Graphics g, JComponent c) {

        Graphics2D g2d = (Graphics2D) g;
        boolean selected = ((JButton) c).getModel().isRollover();
        if (selected) {
            loadHoverImages();
        } else {
            loadIdleImages();
        }
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.drawImage(leftSide, 0, 0, null);
        g2d.drawImage(centerSide, leftSide.getWidth(), 0,
                c.getWidth() - leftSide.getWidth() * 2, c.getHeight(), null);
        g2d.drawImage(rightSide, c.getWidth() - rightSide.getWidth(), 0, null);
        super.paint(g2d, c);
    }
}
