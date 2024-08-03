package unitec.rpg.entities;

import unitec.rpg.entities.enums.Stats;

public abstract class Enemy extends BasicCharacter {

    private int experience;
    private int gold;

    public Enemy(String name) {
        super(name);
    }

    protected abstract String makeDecision(Player player);

    protected String attack(Player player) {

        if (this.getStatus(Stats.ACCURACY) > player.getStatus(Stats.EVASION)) {

            return makeDecision(player);
        } else {
            return String.format("%s ataca a %s y falla.", this.getName(), player.getName());
        }
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