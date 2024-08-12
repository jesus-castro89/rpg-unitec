package unitec.rpg.ui.buttons;

import unitec.rpg.entities.Player;
import unitec.rpg.entities.enemies.Enemy;
import unitec.rpg.ui.buttons.events.FleeButtonListener;
import unitec.rpg.ui.windows.MainWindow;

import java.awt.*;

public class FleeButton extends AbstractButton {

    private Enemy enemy;
    private Player player;
    private MainWindow mainWindow;

    public FleeButton(MainWindow mainWindow, Enemy enemy, Player player) {
        
        super("Huir", false);
        this.mainWindow = mainWindow;
        this.enemy = enemy;
        this.player = player;
        setForeground(Color.WHITE);
        addAction();
    }

    @Override
    public void addAction() {

        addActionListener(new FleeButtonListener(mainWindow, player, enemy));
    }

    public void setEnemy(Enemy enemy) {

        this.enemy = enemy;
    }
}
