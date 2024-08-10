package unitec.rpg.ui.labels;

import unitec.rpg.ui.cache.FontCache;
import unitec.rpg.ui.cache.ImageCache;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class FileLabel extends ImageLabel {
    /**
     * Constructor de la clase
     *
     * @param text texto a mostrar
     */
    public FileLabel(String text) {

        super(new ImageIcon(ImageCache.addImage("fileLabel", "img/labels/fileLabel.png")));
        FontCache.addFont("Retron", "fonts/Retron2000.ttf");
        setFont(FontCache.getFont("Retron").deriveFont(Font.BOLD, 14f));
        setHorizontalTextPosition(JLabel.CENTER);
        setVerticalTextPosition(JLabel.CENTER);
    }
}
