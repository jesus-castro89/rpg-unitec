package unitec.rpg.entities.enemies.slimes;

import unitec.rpg.entities.Player;
import unitec.rpg.entities.enemies.annotations.BossEnemy;
import unitec.rpg.entities.enums.Stats;
import unitec.rpg.ui.cache.ImageCache;

import javax.swing.*;

@BossEnemy
public class KingSlime extends SimpleSlime {

    public KingSlime(Player player) {

        super(player);
    }

    protected void initStats() {

        this.name = "King Slime";
        this.experience = 55;
        this.gold = 35;
        this.maxLevel = 25;
        this.stats.put(Stats.HP, 55);
        this.stats.put(Stats.ATTACK, 25);
        this.stats.put(Stats.DEFENSE, 20);
        this.stats.put(Stats.SPEED, 20);
        this.stats.put(Stats.EVASION, 20);
        this.stats.put(Stats.ACCURACY, 20);
        setStats(player);
    }

    @Override
    public String attack(Player player) {
        String message;
        double plainAttackChance = 0.60;
        double throwThunder = 0.20;
        double throwFireball = 0.20;
        double random = Math.random();
        if (random < plainAttackChance) {
            message = plainAttack(player);
        } else if (random < plainAttackChance + throwThunder) {
            message = throwThunder(player);
        } else {
            message = throwFireball(player);
        }
        return message;
    }

    protected String throwThunder(Player player) {

        int damage = (int) ((stats.get(Stats.ATTACK) * 2.00) - player.getStatus(Stats.DEFENSE));
        player.takeDamage(damage);
        return String.format("%s lanza un rayo a %s por %d puntos de daño.", name, player.getName(), damage);
    }

    protected String throwFireball(Player player) {

        int damage = (int) ((stats.get(Stats.ATTACK) * 2.50) - player.getStatus(Stats.DEFENSE));
        player.takeDamage(damage);
        return String.format("%s lanza una bola de fuego a %s por %d puntos de daño.", name, player.getName(), damage);
    }

    @Override
    public ImageIcon getImage() {

        ImageCache.addImage("KingSlime", "img/enemies/slimes/king_slime.png");
        return ImageCache.getImageIcon("KingSlime");
    }
}
