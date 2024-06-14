package unitec.rpg.entities;

public class Enemy extends BasicCharacter {

    private int experience;
    private int gold;

    public Enemy(String name) {
        super(name);
        this.attack = 5;
        this.defense = 2;
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