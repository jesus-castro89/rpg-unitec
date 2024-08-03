package unitec.rpg.entities.enemies.slimes;

import annotations.RegularEnemy;
import unitec.rpg.entities.Enemy;
import unitec.rpg.entities.Player;
import unitec.rpg.entities.enums.Stats;

@RegularEnemy
public class SimpleSlime extends Enemy {

    public SimpleSlime() {

        super("Slime Básico");
        stats.put(Stats.HP, 10);
        stats.put(Stats.ATTACK, 2);
        stats.put(Stats.DEFENSE, 1);
        stats.put(Stats.ACCURACY, 50);
        stats.put(Stats.EVASION, 10);
        setExperience(5);
        setGold(5);
    }

    @Override
    protected String makeDecision(Player player) {

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
