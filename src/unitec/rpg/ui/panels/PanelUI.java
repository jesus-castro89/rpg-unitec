package unitec.rpg.ui.panels;

import unitec.rpg.ui.dimensions.ElementsDimension;

import javax.swing.*;
import javax.swing.plaf.basic.BasicPanelUI;
import java.awt.*;

public class PanelUI extends BasicPanelUI {

    @Override
    protected void installDefaults(JPanel p) {

        p.setOpaque(false);
        if (p.getName().equals("mainPanel")) {
            p.setBorder(ElementsDimension.MARGIN_BORDER);
        } else {
            p.setBorder(BorderFactory.createEmptyBorder());
        }
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {
        return switch (c.getName()) {
            case "topPanel" -> ElementsDimension.TOP_PANEL_SIZE;
            case "centerPanel" -> ElementsDimension.CENTER_PANEL_SIZE;
            case "bottomPanel" -> ElementsDimension.BOTTOM_PANEL_SIZE;
            default -> ElementsDimension.WINDOW_SIZE;
        };
    }
}
