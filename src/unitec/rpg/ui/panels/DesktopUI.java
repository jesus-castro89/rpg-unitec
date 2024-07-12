package unitec.rpg.ui.panels;

import unitec.rpg.ui.dimensions.ElementsDimension;

import javax.swing.*;
import javax.swing.plaf.basic.BasicDesktopPaneUI;
import java.awt.*;

public class DesktopUI extends BasicDesktopPaneUI {

    @Override
    public Dimension getPreferredSize(JComponent c) {

        return ElementsDimension.WINDOW_SIZE;
    }
}
