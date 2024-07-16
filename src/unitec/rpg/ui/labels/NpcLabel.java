package unitec.rpg.ui.labels;

import unitec.rpg.ui.dimensions.ElementsDimension;

import javax.swing.*;

public class NpcLabel extends ImageLabel {

    public NpcLabel(String path) {
        super(new ImageIcon(path));
        setPreferredSize(ElementsDimension.NPC_LABEL);
    }
}
