package unitec.rpg.entities;

import unitec.rpg.entities.enums.Stats;

public class Enemy extends BasicCharacter {

    private int experience;
    private int gold;

    public Enemy(String name) {
        super(name);
        stats.put(Stats.HP, 50);
        stats.put(Stats.MAX_HP, 50);
        stats.put(Stats.ATTACK, 5);
        stats.put(Stats.DEFENSE, 2);
        stats.put(Stats.SPEED, 2);
        stats.put(Stats.LUCK, 2);
        stats.put(Stats.ACCURACY, 2);
        stats.put(Stats.EVASION, 2);
        stats.put(Stats.CRITICAL_HIT_CHANCE, 2);
        stats.put(Stats.CRITICAL_HIT_DAMAGE, 150);
        this.experience = 10;
        this.gold = 5;
    }

    public Enemy() {
        this("Goblin");
    }

    public String dropLoot(Player player) {

        return gainExperience(player) + "\n" + gainGold(player);
    }

    public String gainExperience(Player player) {

        return String.format("%s gana %d puntos de experiencia.", player.getName(), this.experience);
    }

    public String gainGold(Player player) {

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
}