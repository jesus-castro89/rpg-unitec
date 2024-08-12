package unitec.rpg.ui.buttons.events;


import unitec.rpg.entities.Player;
import unitec.rpg.entities.enemies.Enemy;
import unitec.rpg.entities.enemies.EnemyFactory;
import unitec.rpg.entities.enums.Stats;
import unitec.rpg.exceptions.EnemyDeadException;
import unitec.rpg.exceptions.PlayerDeadException;
import unitec.rpg.ui.windows.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que implementa la interfaz ActionListener para manejar los eventos de los botones de ataque.
 */
public class AttackButtonListener implements ActionListener {

    // Enemigo al que se le va a atacar
    private Enemy enemy;
    private final Player player;
    private final MainWindow mainWindow;

    // Constructor que recibe un enemigo como parámetro
    public AttackButtonListener(MainWindow mainWindow, Enemy enemy, Player player) {

        this.mainWindow = mainWindow;
        this.enemy = enemy;
        this.player = player;
    }

    // Método que se ejecuta al presionar el botón de ataque
    @Override
    public void actionPerformed(ActionEvent e) {

        // Intentamos atacar al enemigo
        try {
            // Si la velocidad del jugador es mayor a la velocidad ajustada del enemigo
            if (player.getStatus(Stats.SPEED) > enemy.getStatus(Stats.SPEED)) {
                // Si el jugador está muerto, lanzamos una excepción
                if (!player.isAlive()) throw new PlayerDeadException();
                // Si no, atacamos al enemigo
                mainWindow.addText(player.attack(enemy));
                // Si el enemigo no está muerto
                if (enemy.isAlive()) {
                    // El enemigo nos ataca
                    mainWindow.addText(enemy.attack(player));
                    // Si escapa por una habilidad, para el sistema está muerto
                    if (!enemy.isAlive()) throw new EnemyDeadException("El enemigo ha escapado.");
                    if (!player.isAlive()) throw new PlayerDeadException();
                } else {
                    dropLoot(player);
                    throw new EnemyDeadException("El enemigo ha muerto.");
                }
            } else {
                // Si el enemigo no está muerto, nos ataca
                mainWindow.addText(enemy.attack(player));
                if (!player.isAlive()) throw new PlayerDeadException();
                // Si escapa por una habilidad, para el sistema está muerto
                if (!enemy.isAlive()) throw new EnemyDeadException("El enemigo ha escapado.");
                // Atacamos al enemigo
                mainWindow.addText(player.attack(enemy));
                if (!enemy.isAlive()) {
                    dropLoot(player);
                    throw new EnemyDeadException("El enemigo ha muerto.");
                }
            }
            // Actualizamos los paneles
            updatePanels(player);
        } catch (EnemyDeadException ex) {
            // Si el enemigo está muerto o escapo por una habilidad
            // Creamos un nuevo enemigo
            enemy = EnemyFactory.generateRegularEnemy(player);
            // Asignamos el nuevo enemigo al panel de juego
            mainWindow.setEnemy(enemy);
            // Actualizamos los paneles
            updatePanels(player);
        } catch (PlayerDeadException ex) {
            // Si el jugador está muerto, mostramos un mensaje de consolación
            mainWindow.addText("¡Has sido derrotado!\n");
            mainWindow.addText("¡Quizás deberías entrenar más duro!\n");
            // Revivimos al jugador
            player.recover();
            // Mostramos un mensaje de que el jugador fue revivido
            mainWindow.addText("¡Has sido revivido!\n");
            // Creamos un nuevo enemigo
            enemy = EnemyFactory.generateRegularEnemy(player);
            // Asignamos el nuevo enemigo al panel de juego
            mainWindow.setEnemy(enemy);
            // Actualizamos los paneles
            updatePanels(player);
        }
    }

    private void dropLoot(Player player) {

        mainWindow.addText(enemy.dropLoot(player));
    }

    /**
     * Método que actualiza los paneles de la interfaz gráfica.
     *
     * @param player Jugador actual
     */
    private void updatePanels(Player player) {
        // Actualizamos los paneles
        mainWindow.updateBars();
    }
}
