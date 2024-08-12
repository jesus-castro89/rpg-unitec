package unitec.rpg.entities.enemies.goblins;

import unitec.rpg.entities.enemies.Enemy;
import unitec.rpg.entities.Player;
import unitec.rpg.entities.enemies.annotations.RegularEnemy;
import unitec.rpg.entities.enums.Stats;
import unitec.rpg.ui.cache.ImageCache;

import javax.swing.*;

@RegularEnemy
public class RookieGoblin extends Enemy {

    public RookieGoblin(Player player) {

        super(player);
    }

    protected void initStats() {

        this.name = "Goblin Novato";
        this.experience = 9;
        this.gold = 4;
        this.maxLevel = 10;
        this.stats.put(Stats.HP, 10);
        this.stats.put(Stats.ATTACK, 5);
        this.stats.put(Stats.DEFENSE, 5);
        this.stats.put(Stats.SPEED, 5);
        this.stats.put(Stats.EVASION, 5);
        this.stats.put(Stats.ACCURACY, 5);
        setStats(player);
    }

    /**
     * Función que permitirá al enemigo atacar al jugador utilizando de forma aleatoria los métodos de ataque del enemigo
     *
     * @param player el jugador al que se atacará
     * @return un mensaje que indica el ataque realizado
     */
    @Override
    public String attack(Player player) {

        String message;
        // Probabilidades de ataque
        double plainAttackChance = 0.30;
        double throwRockChance = 0.30;
        double fleeChance = 0.30;
        double random = Math.random();
        if (random < plainAttackChance) {

            message = plainAttack(player);
        } else if (random < plainAttackChance + throwRockChance) {

            message = throwRock(player);
        } else if (random < plainAttackChance + throwRockChance + fleeChance) {

            message = flee(player);
        } else {
            message = stealGold(player);
        }
        return message;
    }

    protected String plainAttack(Player player) {

        int damage = stats.get(Stats.ATTACK) - player.getStatus(Stats.DEFENSE);
        player.takeDamage(damage);
        return String.format("%s ataca a %s por %d puntos de daño.\n", name, player.getName(), damage);
    }

    protected String throwRock(Player player) {

        int damage = (int) ((stats.get(Stats.ATTACK) * 1.15) - player.getStatus(Stats.DEFENSE));
        player.takeDamage(damage);
        return String.format("%s lanza una roca a %s por %d puntos de daño.\n", name, player.getName(), damage);
    }

    protected String flee(Player player) {

        stats.put(Stats.HP, 0);
        return String.format("%s huye.\n", name);
    }

    protected String stealGold(Player player) {

        int goldStolen = Math.max((player.getGold() - 5), 0);
        player.setGold(player.getGold() - goldStolen);
        gold += goldStolen;
        return goldStolen == 0 ? String.format("%s intenta robar a %s, pero no tiene oro.\n", name, player.getName()) :
                String.format("%s roba %d monedas de oro a %s.\n", name, goldStolen, player.getName());
    }

    /**
     * Devuelve la imagen del enemigo.
     *
     * @return la imagen del enemigo
     */
    @Override
    public ImageIcon getImage() {

        ImageCache.addImage("RookieGoblin", "img/enemies/goblins/rookie_goblin.png");
        return ImageCache.getImageIcon("RookieGoblin");
    }
}
