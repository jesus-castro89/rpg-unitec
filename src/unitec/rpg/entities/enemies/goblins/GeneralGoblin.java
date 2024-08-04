package unitec.rpg.entities.enemies.goblins;

import unitec.rpg.entities.Player;
import unitec.rpg.entities.enemies.annotations.BossEnemy;
import unitec.rpg.entities.enums.Stats;
import unitec.rpg.ui.cache.ImageCache;

import javax.swing.*;

@BossEnemy
public class GeneralGoblin extends RookieGoblin {

    public GeneralGoblin(Player player) {

        super(player);
    }

    protected void initStats() {

        this.name = "Goblin General";
        this.experience = 50;
        this.gold = 30;
        this.maxLevel = 20;
        this.stats.put(Stats.HP, 50);
        this.stats.put(Stats.ATTACK, 20);
        this.stats.put(Stats.DEFENSE, 20);
        this.stats.put(Stats.SPEED, 20);
        this.stats.put(Stats.EVASION, 20);
        this.stats.put(Stats.ACCURACY, 20);
        setStats(player);
    }

    @Override
    public String attack(Player player) {

        String message;
        double plainAttackChance = 0.30;
        double throwClubChance = 0.30;
        double random = Math.random();
        if (random < plainAttackChance) {

            message = plainAttack(player);
        } else if (random < plainAttackChance + throwClubChance) {

            message = throwClub(player);
        } else {

            message = flee(player);
        }
        return message;
    }

    protected String plainAttack(Player player) {

        int damage = (int) ((stats.get(Stats.ATTACK) * 1.25) - player.getStatus(Stats.DEFENSE));
        player.takeDamage(damage);
        return String.format("%s ataca a %s por %d puntos de daño.", name, player.getName(), damage);
    }

    private String throwClub(Player player) {

        int damage = (int) ((stats.get(Stats.ATTACK) * 1.5) - player.getStatus(Stats.DEFENSE));
        player.takeDamage(damage);
        return String.format("%s lanza un garrote a %s por %d puntos de daño.", name, player.getName(), damage);
    }

    @Override
    public ImageIcon getImage() {

        ImageCache.addImage("GeneralGoblin", "img/enemies/goblins/general_goblin.png");
        return ImageCache.getImageIcon("GeneralGoblin");
    }
}
