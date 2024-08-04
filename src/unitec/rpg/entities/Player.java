package unitec.rpg.entities;

import unitec.rpg.entities.enums.Stats;
import unitec.rpg.items.Inventory;

public class Player extends BasicCharacter {

    private int experience;
    private int level;
    private int gold;
    private final Inventory inventory;

    public Player(String name) {

        super(name);
        this.stats.put(Stats.HP, 100);
        this.stats.put(Stats.MAX_HP, 100);
        this.stats.put(Stats.MP, 50);
        this.stats.put(Stats.MAX_MP, 50);
        this.stats.put(Stats.ATTACK, 10);
        this.stats.put(Stats.DEFENSE, 5);
        this.stats.put(Stats.SPEED, 5);
        this.stats.put(Stats.LUCK, 5);
        this.stats.put(Stats.ACCURACY, 5);
        this.stats.put(Stats.EVASION, 5);
        this.stats.put(Stats.CRITICAL_HIT_CHANCE, 5);
        this.stats.put(Stats.CRITICAL_HIT_DAMAGE, 150);
        this.gold = 0;
        this.experience = 0;
        this.level = 1;
        this.inventory = new Inventory();
    }

    public Player() {
        this("John Doe");
    }

    public void levelUp() {

        this.level++;
        this.increaseStat(Stats.MAX_HP, 10);
        this.increaseStat(Stats.MAX_MP, 5);
        this.increaseStat(Stats.ATTACK, 2);
        this.increaseStat(Stats.DEFENSE, 1);
        this.increaseStat(Stats.SPEED, 1);
        this.increaseStat(Stats.LUCK, 1);
        this.increaseStat(Stats.ACCURACY, 1);
        this.increaseStat(Stats.EVASION, 1);
        this.increaseStat(Stats.CRITICAL_HIT_CHANCE, 1);
        this.experience = 0;
    }

    public void gainExperience(int exp) {
        this.experience += exp;
        if (this.experience >= 100 * this.level) {
            levelUp();
        }
    }

    public void gainGold(int gold) {
        this.gold += gold;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Inventory getInventory() {
        return inventory;
    }
}