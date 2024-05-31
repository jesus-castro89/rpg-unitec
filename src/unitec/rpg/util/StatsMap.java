package unitec.rpg.util;

import unitec.rpg.entities.Stats;

import java.util.HashMap;

public class StatsMap extends HashMap<Stats, Integer> {

    public StatsMap() {

        super();
        for (Stats stat : Stats.values()) {
            put(stat, 0);
        }
    }

    public StatsMap(int strength, int dexterity, int intelligence, int wisdom, int charisma,
                    int constitution, int speed, int defense, int resistance, int luck) {
        super();
        put(Stats.STRENGTH, strength);
        put(Stats.DEXTERITY, dexterity);
        put(Stats.INTELLIGENCE, intelligence);
        put(Stats.WISDOM, wisdom);
        put(Stats.CHARISMA, charisma);
        put(Stats.CONSTITUTION, constitution);
        put(Stats.SPEED, speed);
        put(Stats.DEFENSE, defense);
        put(Stats.RESISTANCE, resistance);
        put(Stats.LUCK, luck);
    }

    public int getStrength() {
        return get(Stats.STRENGTH);
    }

    public int getDexterity() {
        return get(Stats.DEXTERITY);
    }

    public int getIntelligence() {
        return get(Stats.INTELLIGENCE);
    }

    public int getWisdom() {
        return get(Stats.WISDOM);
    }

    public int getCharisma() {
        return get(Stats.CHARISMA);
    }

    public int getConstitution() {
        return get(Stats.CONSTITUTION);
    }

    public int getSpeed() {
        return get(Stats.SPEED);
    }

    public int getDefense() {
        return get(Stats.DEFENSE);
    }

    public int getResistance() {
        return get(Stats.RESISTANCE);
    }

    public int getLuck() {
        return get(Stats.LUCK);
    }

    public void setStrength(int strength) {
        put(Stats.STRENGTH, strength);
    }

    public void setDexterity(int dexterity) {
        put(Stats.DEXTERITY, dexterity);
    }

    public void setIntelligence(int intelligence) {
        put(Stats.INTELLIGENCE, intelligence);
    }

    public void setWisdom(int wisdom) {
        put(Stats.WISDOM, wisdom);
    }

    public void setCharisma(int charisma) {
        put(Stats.CHARISMA, charisma);
    }

    public void setConstitution(int constitution) {
        put(Stats.CONSTITUTION, constitution);
    }

    public void setSpeed(int speed) {
        put(Stats.SPEED, speed);
    }

    public void setDefense(int defense) {
        put(Stats.DEFENSE, defense);
    }

    public void setResistance(int resistance) {
        put(Stats.RESISTANCE, resistance);
    }

    public void setLuck(int luck) {
        put(Stats.LUCK, luck);
    }

    public void add(StatsMap stats) {
        for (Stats stat : Stats.values()) {
            put(stat, get(stat) + stats.get(stat));
        }
    }

    public void subtract(StatsMap stats) {
        for (Stats stat : Stats.values()) {
            put(stat, get(stat) - stats.get(stat));
        }
    }

    public void multiply(int factor) {
        for (Stats stat : Stats.values()) {
            put(stat, get(stat) * factor);
        }
    }

    public void divide(int factor) {
        for (Stats stat : Stats.values()) {
            put(stat, get(stat) / factor);
        }
    }

    public void add(Stats stat, int value) {
        put(stat, get(stat) + value);
    }

    public void subtract(Stats stat, int value) {
        put(stat, get(stat) - value);
    }

    public void multiply(Stats stat, int factor) {
        put(stat, get(stat) * factor);
    }
}