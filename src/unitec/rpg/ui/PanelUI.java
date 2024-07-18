package unitec.rpg.ui;

import unitec.rpg.ui.cache.ImageCache;
import unitec.rpg.ui.dimensions.ElementsDimension;

import javax.swing.*;
import javax.swing.plaf.basic.BasicPanelUI;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Clase responsable de la apariencia de los paneles del juego.
 */
public class PanelUI extends BasicPanelUI {

    /**
     * Constructor de la clase. Que se encarga de agregar a la cáche las imágenes de los paneles.
     */
    public PanelUI() {

        ImageCache.addImage("mainPanel", "img/panels/backgroundPanel.png");
        ImageCache.addImage("topPanel", "img/panels/statusPanel.png");
        ImageCache.addImage("centerPanel", "img/panels/mainBackground.png");
        ImageCache.addImage("bottomPanel", "img/panels/battlePanel.png");
        ImageCache.addImage("dialogPanel", "img/panels/skillPanel.png");
    }

    /**
     * Método que se encarga de instalar los valores por defecto de los paneles.
     *
     * @param p Panel al que se le instalarán los valores por defecto.
     */
    @Override
    protected void installDefaults(JPanel p) {

        p.setOpaque(false);
        if (p.getName().equals("mainPanel")) {
            p.setBorder(ElementsDimension.MARGIN_BORDER);
        } else {
            p.setBorder(BorderFactory.createEmptyBorder());
        }
    }

    /**
     * Método que se encarga de recuperar las dimensiones por defecto de los paneles.
     *
     * @param c Componente al que se le recuperarán las dimensiones.
     */
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

    /**
     * Método que se encarga de pintar los paneles.
     *
     * @param g Gráficos del panel.
     * @param c Componente al que se le pintará.
     */
    @Override
    public void paint(Graphics g, JComponent c) {

        Graphics2D g2d = (Graphics2D) g;
        BufferedImage image;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        switch (c.getName()) {
            case "topPanel" -> image = ImageCache.getImage("topPanel");
            case "centerPanel" -> image = ImageCache.getImage("centerPanel");
            case "bottomPanel" -> image = ImageCache.getImage("bottomPanel");
            case "dialogPanel" -> image = ImageCache.getImage("dialogPanel");
            default -> image = ImageCache.getImage("mainPanel");
        }
        g2d.drawImage(image, 0, 0, c.getWidth(), c.getHeight(), null);
    }
}
