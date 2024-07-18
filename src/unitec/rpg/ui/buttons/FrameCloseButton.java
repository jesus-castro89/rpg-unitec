package unitec.rpg.ui.buttons;

import unitec.rpg.ui.cache.ImageCache;

import javax.swing.*;

import static unitec.rpg.ui.dimensions.ElementsDimension.ICON_BUTTON_SIZE;

public class FrameCloseButton extends BasicIconButton {

    private final JInternalFrame parent;

    public FrameCloseButton(JInternalFrame parent) {
        super(ImageCache.addImage("close", "img/buttons/close.png"),
                ImageCache.addImage("closeHover", "img/buttons/close_hover.png"));
        this.parent = parent;
        setPreferredSize(ICON_BUTTON_SIZE);
    }

    @Override
    protected void setAction() {
        addActionListener(e -> {
            parent.dispose();
        });
    }
}
