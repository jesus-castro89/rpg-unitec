package unitec.rpg.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Desktop extends JInternalFrame {
    private JPanel mainPanel;
    private JButton button1;
    private JDesktopPane desktopPane;

    public Desktop() {

        super("Desktop", false, false, false, false);
        add(mainPanel);
        setSize(800, 600);
        desktopPane = new JDesktopPane();
        desktopPane.add(this);
        this.setVisible(true);
        JFrame frame = new JFrame("Desktop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(desktopPane);
        frame.setSize(800, 600);
        frame.setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JInternalFrame frame = new JInternalFrame("Internal Frame", true, true, true, true);
                frame.setSize(200, 200);
                frame.setVisible(true);
                desktopPane.add(frame);
                desktopPane.moveToFront(frame);
            }
        });
    }

    public static void main(String[] args) {
        new Desktop();
    }
}
