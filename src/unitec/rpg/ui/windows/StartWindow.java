package unitec.rpg.ui.windows;


import unitec.rpg.ui.panels.StartPanel;

import javax.swing.*;

public class StartWindow extends JFrame {

    private final StartPanel startPanel;

    public StartWindow() {

        super("RPG :: Inicio");
        startPanel = new StartPanel(this);
        add(startPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void update() {

        startPanel.update();
    }
}
