package unitec.rpg.ui.windows;

import javax.swing.*;
import java.awt.*;

public class Inventory extends JPanel {
    private JPanel mainPanel;
    private JPanel item1;
    private JPanel item2;
    private JPanel item3;
    private JPanel item4;
    private JPanel item5;
    private JPanel item6;

    public Inventory() {
        add(mainPanel);
        setPreferredSize(new Dimension(400, 200));
        setSize(getPreferredSize());
    }

    private void createUIComponents() {

        item1 = new ItemDisplay();
        item2 = new ItemDisplay();
        item3 = new ItemDisplay();
        item4 = new ItemDisplay();
        item5 = new ItemDisplay();
        item6 = new ItemDisplay();
    }
}
