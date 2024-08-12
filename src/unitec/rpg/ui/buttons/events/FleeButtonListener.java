package unitec.rpg.ui.buttons.events;


import unitec.rpg.entities.Player;
import unitec.rpg.entities.enemies.Enemy;
import unitec.rpg.entities.enemies.EnemyFactory;
import unitec.rpg.entities.enums.Stats;
import unitec.rpg.exceptions.EnemyDeadException;
import unitec.rpg.ui.windows.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que implementa el comportamiento del botón de huir.
 */
public class FleeButtonListener implements ActionListener {

    // Enemigo al que se le aplicará el comportamiento de huir.
    private Enemy enemy;
    private final Player player;
    private MainWindow mainWindow;

    /**
     * Constructor de la clase.
     *
     * @param enemy Enemigo al que se le aplicará el comportamiento de huir.
     */
    public FleeButtonListener(MainWindow mainWindow, Player player, Enemy enemy) {

        this.mainWindow = mainWindow;
        this.player = player;
        this.enemy = enemy;
    }

    /**
     * Método que se ejecuta al hacer clic en el botón de huir.
     *
     * @param e Evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // Se intenta huir del enemigo.
        try {
            // Si la velocidad del jugador es mayor que la velocidad ajustada del enemigo,
            // el jugador tratará de huir.
            if (player.getStatus(Stats.SPEED) > enemy.getStatus(Stats.SPEED)) {
                // Se intenta huir.
                mainWindow.addText(player.tryToFlee());
                // En caso de no poder huir, es el enemigo quien atacará.
                mainWindow.addText(enemy.attack(player));
                // Si el enemigo muere o escapa se lanza una excepción.
                if (!enemy.isAlive()) throw new EnemyDeadException("El enemigo ha escapado.");
            } else {
                // En caso contrario el enemigo atacará y el jugador tratará de huir.
                mainWindow.addText(enemy.attack(player));
                // Si el enemigo muere o escapa se lanza una excepción.
                if (!enemy.isAlive()) throw new EnemyDeadException("El enemigo ha escapado.");
                // Se intenta huir.
                mainWindow.addText(player.tryToFlee());
            }
            // Se actualizan los paneles.
            updatePanels(player);
        } catch (EnemyDeadException ex) {
            // Si el enemigo muere o huye haremos esto.
            // Se genera un nuevo enemigo.
            enemy = EnemyFactory.generateRegularEnemy(player);
            // Se actualiza la instancia del enemigo en la ventana de juego.
            mainWindow.setEnemy(enemy);
            // Se actualizan los paneles.
            updatePanels(player);
        }
    }

    private void updatePanels(Player player) {

        mainWindow.repaint();
    }
}
