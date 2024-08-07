package unitec.rpg.entities.enemies.slimes;

import unitec.rpg.entities.Player;
import unitec.rpg.entities.enemies.Enemy;
import unitec.rpg.entities.enemies.annotations.RegularEnemy;
import unitec.rpg.entities.enums.Stats;
import unitec.rpg.ui.cache.ImageCache;

import javax.swing.*;

@RegularEnemy
public class SimpleSlime extends Enemy {

    public SimpleSlime(Player player) {

        super(player);
    }

    @Override
    protected void initStats() {

        this.name = "Slime";
        this.experience = 10;
        this.gold = 5;
        this.maxLevel = 11;
        this.stats.put(Stats.HP, 11);
        this.stats.put(Stats.ATTACK, 6);
        this.stats.put(Stats.DEFENSE, 5);
        this.stats.put(Stats.SPEED, 5);
        this.stats.put(Stats.EVASION, 5);
        this.stats.put(Stats.ACCURACY, 5);
        setStats(player);
    }

    @Override
    public ImageIcon getImage() {

        ImageCache.addImage("slime", "img/enemies/slimes/basic_slime.png");
        return new ImageIcon("img/enemies/slimes/basic_slime.png");
    }

    @Override
    public String attack(Player player) {

        double decision = Math.random();
        double splashProbability = 0.3;
        double healProbability = 0.1;
        double runProbability = 0.1;

        if (decision < splashProbability) {
            return splashAttack(player);
        } else if (decision < splashProbability + healProbability) {
            return heal();
        } else if (decision < splashProbability + healProbability + runProbability) {
            return run();
        } else {
            return plainAttack(player);
        }
    }

    protected String splashAttack(Player player) {

        player.takeDamage((int) (getStatus(Stats.ATTACK) * 1.15 - player.getStatus(Stats.DEFENSE)));
        return String.format("%s ataca a %s con un ataque de salpicadura.", this.getName(), player.getName());
    }

    protected String plainAttack(Player player) {

        player.takeDamage(getStatus(Stats.ATTACK) - player.getStatus(Stats.DEFENSE));
        return String.format("%s ataca a %s.", this.getName(), player.getName());
    }

    protected String heal() {

        increaseStat(Stats.HP, 2);
        return String.format("%s se cura.", this.getName());
    }

    protected String run() {

        stats.put(Stats.HP, 0);
        return String.format("%s huye.", this.getName());
    }
}
