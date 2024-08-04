package unitec.rpg.entities.enemies.slimes;

import unitec.rpg.entities.Player;
import unitec.rpg.entities.enemies.annotations.RegularEnemy;
import unitec.rpg.entities.enums.Stats;
import unitec.rpg.ui.cache.ImageCache;

import javax.swing.*;

@RegularEnemy
public class ThunderSlime extends SimpleSlime {

    public ThunderSlime(Player player) {

        super(player);
    }

    protected void initStats() {

        this.name = "Slime Eléctrico";
        this.experience = 15;
        this.gold = 10;
        this.maxLevel = 15;
        this.stats.put(Stats.HP, 15);
        this.stats.put(Stats.ATTACK, 10);
        this.stats.put(Stats.DEFENSE, 10);
        this.stats.put(Stats.SPEED, 10);
        this.stats.put(Stats.EVASION, 10);
        this.stats.put(Stats.ACCURACY, 10);
        setStats(player);
    }

    @Override
    public String attack(Player player) {
        String message;
        double plainAttackChance = 0.50;
        double random = Math.random();
        message = random < plainAttackChance ? plainAttack(player) : throwThunder(player);
        return message;
    }

    protected String throwThunder(Player player) {
        int damage = (int) ((stats.get(Stats.ATTACK) * 1.50) - player.getStatus(Stats.DEFENSE));
        player.takeDamage(damage);
        return String.format("%s lanza un rayo a %s por %d puntos de daño.", name, player.getName(), damage);
    }

    @Override
    public ImageIcon getImage() {
        ImageCache.addImage("ThunderSlime", "img/enemies/slimes/thunder_slime.png");
        return ImageCache.getImageIcon("ThunderSlime");
    }
}
