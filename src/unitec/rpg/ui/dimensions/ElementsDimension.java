package unitec.rpg.ui.dimensions;

import javax.swing.border.EmptyBorder;
import java.awt.*;

public interface ElementsDimension {

    int MARGIN = 5;
    EmptyBorder MARGIN_BORDER = new EmptyBorder(MARGIN, MARGIN, MARGIN, MARGIN);
    Dimension ICON_BUTTON_SIZE = new Dimension(32, 32);
    Dimension WINDOW_SIZE = new Dimension(1280, 720);
    Dimension CONTAINER_SIZE = new Dimension(-1, -1);
    Dimension TOP_PANEL_SIZE = new Dimension(WINDOW_SIZE.width - (2 * MARGIN), 145);
    Dimension BOTTOM_PANEL_SIZE = new Dimension(WINDOW_SIZE.width - (2 * MARGIN), 320);
    Dimension CENTER_PANEL_SIZE = new Dimension(WINDOW_SIZE.width - (2 * MARGIN), WINDOW_SIZE.height
            - (2 * MARGIN) - TOP_PANEL_SIZE.height - BOTTOM_PANEL_SIZE.height);
    Dimension BAR_LABEL = new Dimension(172, 51);
    Dimension PLAYER_LABEL = new Dimension(64, 64);
    Dimension NPC_LABEL = new Dimension(500, 200);
    Dimension START_PANEL_SIZE = new Dimension(960, 540);
}