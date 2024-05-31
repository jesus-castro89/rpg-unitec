package unitec.rpg.test;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import java.awt.*;

public class WindowTest {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Window Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(800, 600);
        frame.setVisible(true);

        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setSize(800, 600);
        frame.add(desktopPane, BorderLayout.CENTER);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        mainPanel.setSize(800, 600);
        JButton button1 = new JButton("Create Internal Frame");
        mainPanel.add(button1);
        desktopPane.add(mainPanel, BorderLayout.CENTER);

        JInternalFrame internalFrame = new JInternalFrame("Internal Frame", true, true, true, true);
        internalFrame.setSize(200, 200);
        internalFrame.setVisible(true);
        desktopPane.add(internalFrame);
        internalFrame.addInternalFrameListener(new InternalFrameAdapter() {

            @Override
            public void internalFrameIconified(InternalFrameEvent e) {
                System.out.println("Internal Frame Iconified");
                internalFrame.toFront();
            }
        });
        desktopPane.moveToFront(internalFrame);
    }
}
