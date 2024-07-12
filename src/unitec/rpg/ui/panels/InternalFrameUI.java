package unitec.rpg.ui.panels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.plaf.metal.MetalInternalFrameTitlePane;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InternalFrameUI extends BasicInternalFrameUI {

    private Point initialClick;

    /**
     * Constructs a {@code BasicInternalFrameUI}.
     *
     * @param b the internal frame
     */
    public InternalFrameUI(JInternalFrame b) {
        super(b);
        JPanel contentPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("img/panels/background.png");
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2d.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
                g2d.dispose();
            }
        };
        contentPanel.setOpaque(false);
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPanel.setBackground(Color.PINK);
        b.setContentPane(contentPanel);
        b.setOpaque(false);
        b.setBorder(null);
        b.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                b.getComponentAt(initialClick);
            }
        });

        b.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

                // localización de la ventana
                int thisX = b.getLocation().x;
                int thisY = b.getLocation().y;

                // Determinar cuánto se ha movido el mouse desde el clic inicial
                int xMoved = e.getX() - initialClick.x;
                int yMoved = e.getY() - initialClick.y;

                // Mover la ventana a esta posición
                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                b.setLocation(X, Y);
            }
        });
    }

    @Override
    protected JComponent createNorthPane(JInternalFrame frame) {

        return new FrameTitlePane(frame);
    }
}
