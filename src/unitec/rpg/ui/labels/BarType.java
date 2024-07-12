package unitec.rpg.ui.labels;

import javax.swing.*;

public enum BarType {

    LIFE("img/bars/lifeBar.png"),
    MAGIC("img/bars/magicBar.png"),
    EXPERIENCE("img/bars/expBar.png");

    final ImageIcon image;

    BarType(String path) {
        image = new ImageIcon(path);
    }

    public ImageIcon getImage() {
        return image;
    }
}
