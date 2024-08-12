package unitec.rpg.ui.buttons;

import unitec.rpg.entities.Player;
import unitec.rpg.entities.enemies.Enemy;
import unitec.rpg.ui.buttons.events.AttackButtonListener;
import unitec.rpg.ui.windows.MainWindow;

import javax.swing.*;
import java.awt.*;

public class AttackButton extends AbstractButton {

    private Enemy enemy;
    private Player player;
    private MainWindow mainWindow;

    public AttackButton(MainWindow mainWindow, Enemy enemy, Player player) {

        super("Atacar", false);
        this.mainWindow = mainWindow;
        this.enemy = enemy;
        this.player = player;
        setForeground(Color.WHITE);
        addAction();
    }

    @Override
    public void addAction() {

        addActionListener(new AttackButtonListener(mainWindow, enemy, player));
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
}
