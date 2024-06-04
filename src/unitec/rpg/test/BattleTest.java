package unitec.rpg.test;

import unitec.rpg.entities.Player;
import unitec.rpg.entities.Enemy;

public class BattleTest {

    public static void main(String[] args) {

        // Crear un nuevo jugador
        Player player = new Player("Alice");

        // Crear un nuevo enemigo
        Enemy enemy = new Enemy("Goblin");

        // Imprimir los atributos del jugador y el enemigo
        System.out.println("Jugador: " + player.getName());
        System.out.println("Salud: " + player.getHP() + "/" + player.getMaxHP());
        System.out.println("Magía: " + player.getMP() + "/" + player.getMaxMP());
        System.out.println("Ataque: " + player.getAttack());
        System.out.println("Defensa: " + player.getDefense());
        System.out.println("Experiencia: " + player.getExperience());
        System.out.println("Nivel: " + player.getLevel());
        System.out.println("Oro: " + player.getGold());

        System.out.println("Enemigo: " + enemy.getName());
        System.out.println("Salud: " + enemy.getHP() + "/" + enemy.getMaxHP());
        System.out.println("Magía: " + enemy.getMP() + "/" + enemy.getMaxMP());
        System.out.println("Ataque: " + enemy.getAttack());
        System.out.println("Defensa: " + enemy.getDefense());
        System.out.println("Experiencia: " + enemy.getExperience());
        System.out.println("Oro: " + enemy.getGold());

        // Realizar una batalla entre el jugador y el enemigo
        while (player.isAlive() && enemy.isAlive()) {
            player.attack(enemy);
            if (enemy.isAlive()) {
                enemy.attack(player);
            }
        }
        if (player.isAlive()) {
            System.out.println("¡" + player.getName() + " ha derrotado a " + enemy.getName() + "!");
            enemy.dropLoot(player);
        } else {
            System.out.println("¡" + enemy.getName() + " ha derrotado a " + player.getName() + "!");
        }
    }
}