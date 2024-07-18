package unitec.rpg.ui.buttons;

import unitec.rpg.ui.cache.ImageCache;

import javax.swing.*;

public class BlackSmithButton extends AbstractButton {

    public BlackSmithButton() {

        super("Herrero", true);
        ImageCache.addImage("blackSmithIdle", "img/icons/blackSmithIdle.png");
        ImageCache.addImage("blackSmithHover", "img/icons/blackSmithHover.png");
        setIcon(ImageCache.getImageIcon("blackSmithIdle"));
        setRolloverIcon(ImageCache.getImageIcon("blackSmithHover"));
    }

    @Override
    public void addAction() {

    }
}
