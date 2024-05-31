package unitec.rpg.gui;

import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public class InternalFrameMinimizer implements InternalFrameListener {

    private final JPanel mainPanel;

    InternalFrameMinimizer(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
    @Override
    public void internalFrameOpened(InternalFrameEvent e) {

        System.out.println("Internal Frame Opened");
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {

    }

    public void internalFrameMinimized(InternalFrameEvent e) {
        // Minimizar el JInternalFrame sobre el JPanel principal
        JInternalFrame frame = e.getInternalFrame();
        int x = mainPanel.getWidth() - frame.getWidth();
        int y = mainPanel.getHeight() - frame.getHeight();
        frame.setLocation(x, y);
    }
}
