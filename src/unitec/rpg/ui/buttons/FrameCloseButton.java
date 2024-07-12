package unitec.rpg.ui.buttons;

import unitec.rpg.utils.ImageCache;

import javax.swing.*;

import static unitec.rpg.ui.dimensions.ElementsDimension.ICON_BUTTON_SIZE;

public class FrameCloseButton extends BasicIconButton {

    private final JInternalFrame parent;

    public FrameCloseButton(JInternalFrame parent) {
        super(ImageCache.getImage("close", "img/buttons/close.png"),
                ImageCache.getImage("closeHover", "img/buttons/close_hover.png"));
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
