package unitec.rpg.ui.panels;

import unitec.rpg.ui.buttons.FrameCloseButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.*;

public class FrameTitlePane extends BasicInternalFrameTitlePane {

    /**
     * Constructs a new instance of {@code BasicInternalFrameTitlePane}.
     *
     * @param f an instance of {@code JInternalFrame}
     */
    public FrameTitlePane(JInternalFrame f) {

        super(f);
        Dimension d = getPreferredSize();
        d.height = 45;
        setPreferredSize(d);
    }

    protected void installDefaults() {
        super.installDefaults();
        setOpaque(false);
    }

    @Override
    protected void addSubComponents() {
        JPanel leftCorner = new ImagePanel("topLeftCorner", "img/panels/topLeftCorner.png", 45, 42);
        JPanel rightCorner = new ImagePanel("topRightCorner", "img/panels/topRightCorner.png", 45, 45);
        JPanel middlePanel = new ImagePanel("topBack", "img/panels/topBack.png", 555, 45);
        FrameCloseButton frameCloseButton = new FrameCloseButton(frame);
        frameCloseButton.setVisible(true);
        leftCorner.setBounds(0, 0, 45, 45);
        rightCorner.setBounds(596, 0, 45, 45);
        middlePanel.setBounds(45, 0, 555, 45);
        frameCloseButton.setBounds(596, 6, 32, 32);
        add(frameCloseButton);
        add(leftCorner);
        add(middlePanel);
        add(rightCorner);
    }

    public void paintComponent(Graphics g)  {
        //super.paintComponent(g);
    }
}
