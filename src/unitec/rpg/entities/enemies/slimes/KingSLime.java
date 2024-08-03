package unitec.rpg.entities.enemies.slimes;

import annotations.BossEnemy;
import unitec.rpg.entities.Player;
import unitec.rpg.entities.enums.Stats;

@BossEnemy
public class KingSLime extends SimpleSlime {

    public KingSLime() {

        setName("Rey Slime");
        stats.put(Stats.HP, 50);
        stats.put(Stats.ATTACK, 14);
        stats.put(Stats.DEFENSE, 22);
        stats.put(Stats.ACCURACY, 60);
        stats.put(Stats.EVASION, 25);
        setExperience(25);
        setGold(25);
    }

    @Override
    protected String makeDecision(Player player) {

        double decision = Math.random();
        double acidAttackProbability = 0.3;
        double bodySlamProbability = 0.3;
        double rollOutProbability = 0.3;

        if (decision < acidAttackProbability) {
            return acidAttack(player);
        } else if (decision < acidAttackProbability + bodySlamProbability) {
            return bodySlam(player);
        } else if (decision < acidAttackProbability + bodySlamProbability + rollOutProbability) {
            return rollOut(player);
        } else {
            return heal();
        }
    }


    @Override
    protected String heal() {

        increaseStat(Stats.HP, 5);
        return String.format("%s se cura.", this.getName());
    }

    private String acidAttack(Player player) {

        player.takeDamage((int) (getStatus(Stats.ATTACK) * 1.25 - player.getStatus(Stats.DEFENSE)));
        return String.format("%s ataca a %s con un ataque de ácido.", this.getName(), player.getName());
    }

    private String bodySlam(Player player) {

        player.takeDamage((int) (getStatus(Stats.ATTACK) * 1.5 - player.getStatus(Stats.DEFENSE)));
        return String.format("%s ataca a %s con un ataque de cuerpo.", this.getName(), player.getName());
    }

    private String rollOut(Player player) {

        player.takeDamage((int) (getStatus(Stats.ATTACK) * 1.75 - player.getStatus(Stats.DEFENSE)));
        return String.format("%s ataca a %s con un ataque de rodar.", this.getName(), player.getName());
    }
}
