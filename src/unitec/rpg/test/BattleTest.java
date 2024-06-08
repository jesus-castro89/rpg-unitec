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
        printData(player.getHP(), player.getMaxHP(), player.getMP(), player.getMaxMP(), player.getAttack(), player.getDefense(), player.getExperience(), player);
        System.out.println("Nivel: " + player.getLevel());
        System.out.println("Oro: " + player.getGold());

        System.out.println("Enemigo: " + enemy.getName());
        printData(enemy.getHP(), enemy.getMaxHP(), enemy.getMP(), enemy.getMaxMP(), enemy.getAttack(), enemy.getDefense(), enemy.getExperience(), player);
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

    private static void printData(int hp, int maxHP, int mp, int maxMP, int attack, int defense, int experience, Player player) {
        System.out.println("Salud: " + hp + "/" + maxHP);
        System.out.println("Magía: " + mp + "/" + maxMP);
        System.out.println("Ataque: " + attack);
        System.out.println("Defensa: " + defense);
        System.out.println("Experiencia: " + experience);
    }
}