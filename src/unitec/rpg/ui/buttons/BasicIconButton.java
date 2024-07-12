package unitec.rpg.ui.buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class BasicIconButton extends JButton {


    public BasicIconButton(BufferedImage idleImage, BufferedImage hoverImage) {

        setIcon(new ImageIcon(idleImage));
        setRolloverIcon(new ImageIcon(hoverImage));
        setPreferredSize(new Dimension(idleImage.getWidth(), idleImage.getHeight()));
        setBorder(null);
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setVisible(true);
        setOpaque(false);
        setAction();
    }

    protected abstract void setAction();
}
