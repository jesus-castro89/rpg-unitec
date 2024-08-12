package unitec.rpg.entities.enemies.slimes;

import unitec.rpg.entities.Player;
import unitec.rpg.entities.enemies.annotations.RegularEnemy;
import unitec.rpg.entities.enums.Stats;
import unitec.rpg.ui.cache.ImageCache;

import javax.swing.*;

@RegularEnemy
public class FireSlime extends SimpleSlime {

    public FireSlime(Player player) {

        super(player);
    }

    protected void initStats() {

        this.name = "Slime de Fuego";
        this.experience = 16;
        this.gold = 12;
        this.maxLevel = 16;
        this.stats.put(Stats.HP, 16);
        this.stats.put(Stats.ATTACK, 12);
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
        message = random < plainAttackChance ? plainAttack(player) : throwFireball(player);
        return message;
    }

    protected String throwFireball(Player player) {
        int damage = (int) ((stats.get(Stats.ATTACK) * 1.50) - player.getStatus(Stats.DEFENSE));
        player.takeDamage(damage);
        return String.format("%s lanza una bola de fuego a %s por %d puntos de daño.\n", name, player.getName(), damage);
    }

    @Override
    public ImageIcon getImage() {
        ImageCache.addImage("FireSlime", "img/enemies/slimes/fire_slime.png");
        return ImageCache.getImageIcon("FireSlime");
    }
}
