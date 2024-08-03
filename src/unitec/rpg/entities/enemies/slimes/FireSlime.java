package unitec.rpg.entities.enemies.slimes;

import unitec.rpg.entities.Player;
import unitec.rpg.entities.enums.Stats;

public class FireSlime extends SimpleSlime {

    public FireSlime() {

        setName("Slime de Fuego");
        stats.put(Stats.HP, 15);
        stats.put(Stats.ATTACK, 4);
        stats.put(Stats.DEFENSE, 2);
        stats.put(Stats.ACCURACY, 55);
        stats.put(Stats.EVASION, 15);
        setExperience(7);
        setGold(7);
    }

    @Override
    protected String makeDecision(Player player) {

        double decision = Math.random();
        double magmaBlastProbability = 0.4;
        double burnProbability = 0.2;
        double healProbability = 0.1;

        if (decision < magmaBlastProbability) {
            return magmaBlast(player);
        } else if (decision < magmaBlastProbability + burnProbability) {
            return burn(player);
        } else if (decision < magmaBlastProbability + burnProbability + healProbability) {
            return heal();
        } else {
            return plainAttack(player);
        }
    }

    protected String fireball(Player player) {

        player.takeDamage((int) (getStatus(Stats.ATTACK) * 1.2 - player.getStatus(Stats.DEFENSE)));
        return String.format("%s ataca a %s con una bola de fuego.", this.getName(), player.getName());
    }

    @Override
    protected String plainAttack(Player player) {
        return fireball(player);
    }

    @Override
    protected String heal() {

        increaseStat(Stats.HP, 3);
        return String.format("%s se cura.", this.getName());
    }

    protected String magmaBlast(Player player) {

        player.takeDamage((int) (getStatus(Stats.ATTACK) * 1.5 - player.getStatus(Stats.DEFENSE));
        return String.format("%s ataca a %s con una explosión de magma.", this.getName(), player.getName());
    }

    protected String burn(Player player) {

        player.takeDamage((int) (getStatus(Stats.ATTACK) * 1.1 - player.getStatus(Stats.DEFENSE));
        return String.format("%s ataca a %s con un ataque de quemadura.", this.getName(), player.getName());
    }
}
