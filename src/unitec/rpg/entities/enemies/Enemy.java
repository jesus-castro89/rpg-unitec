package unitec.rpg.entities.enemies;

import unitec.rpg.entities.BasicCharacter;
import unitec.rpg.entities.Player;
import unitec.rpg.entities.enums.Stats;

import javax.swing.*;

public abstract class Enemy
        extends BasicCharacter {

    protected int experience;
    protected int gold;
    protected int maxLevel;
    protected final double adjustLevel = 1.15;
    protected final Player player;

    public abstract ImageIcon getImage();

    public Enemy(Player player) {

        this.player = player;
        initStats();
    }

    protected abstract void initStats();

    protected void setStats(Player player) {

        stats.put(Stats.HP, getAdjustedStat(Stats.HP, player));
        stats.put(Stats.MAX_HP, getStatus(Stats.HP));
        stats.put(Stats.ATTACK, getAdjustedStat(Stats.ATTACK, player));
        stats.put(Stats.DEFENSE, getAdjustedStat(Stats.DEFENSE, player));
        stats.put(Stats.SPEED, getAdjustedStat(Stats.SPEED, player));
        stats.put(Stats.EVASION, getAdjustedStat(Stats.EVASION, player));
        stats.put(Stats.ACCURACY, getAdjustedStat(Stats.ACCURACY, player));
        experience = (int) (experience * (player.getLevel() * adjustLevel));
    }

    public abstract String attack(Player player);

    protected int getAdjustedStat(Stats stat, Player player) {

        return (int) (stats.get(stat) * (player.getLevel() * adjustLevel));
    }

    public String dropLoot(Player player) {

        return gainExperience(player) + "\n" + gainGold(player) + "\n";
    }

    public String gainExperience(Player player) {

        return player.gainExperience(this.experience);
    }

    public String gainGold(Player player) {

        player.gainGold(this.gold);
        return String.format("%s gana %d monedas de oro.", player.getName(), this.gold);
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public boolean isBoss() {

        return this.getClass().isAnnotationPresent(unitec.rpg.entities.enemies.annotations.BossEnemy.class);
    }
}