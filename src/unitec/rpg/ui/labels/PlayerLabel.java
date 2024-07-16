package unitec.rpg.ui.labels;

import unitec.rpg.ui.dimensions.ElementsDimension;

import javax.swing.*;
import java.awt.*;

public class PlayerLabel extends ImageLabel {

    public PlayerLabel() {
        super(new ImageIcon("img/player/player.png"));
        setPreferredSize(ElementsDimension.PLAYER_LABEL);
    }
}
