package unitec.rpg.ui.labels;

import unitec.rpg.ui.cache.ImageCache;

import javax.swing.*;

public enum BarType {

    LIFE, MAGIC, EXPERIENCE;

    ImageIcon container;
    ImageIcon icon;
    ImageIcon bar;

    BarType() {
        switch (this) {
            case LIFE -> {
                ImageCache.addImage("life_container", "img/bars/life/container.png");
                ImageCache.addImage("life_icon", "img/bars/life/icon.png");
                ImageCache.addImage("life_bar", "img/bars/life/bar.png");
                container = ImageCache.getImageIcon("life_container");
                icon = ImageCache.getImageIcon("life_icon");
                bar = ImageCache.getImageIcon("life_bar");
            }
            case MAGIC -> {
                ImageCache.addImage("magic_container", "img/bars/magic/container.png");
                ImageCache.addImage("magic_icon", "img/bars/magic/icon.png");
                ImageCache.addImage("magic_bar", "img/bars/magic/bar.png");
                container = ImageCache.getImageIcon("magic_container");
                icon = ImageCache.getImageIcon("magic_icon");
                bar = ImageCache.getImageIcon("magic_bar");
            }
            case EXPERIENCE -> {
                ImageCache.addImage("experience_container", "img/bars/experience/container.png");
                ImageCache.addImage("experience_icon", "img/bars/experience/icon.png");
                ImageCache.addImage("experience_bar", "img/bars/experience/bar.png");
                container = ImageCache.getImageIcon("experience_container");
                icon = ImageCache.getImageIcon("experience_icon");
                bar = ImageCache.getImageIcon("experience_bar");
            }
        }
    }

    public ImageIcon getContainer() {
        return container;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public ImageIcon getBar() {
        return bar;
    }
}
