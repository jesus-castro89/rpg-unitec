package unitec.rpg.entities;

public class Player extends BasicCharacter {

    private int experience;
    private int level;
    private int gold;

    public Player(String name) {
        super(name);
        this.attack = 10;
        this.defense = 5;
        this.experience = 0;
        this.level = 1;
    }

    public Player() {
        this("John Doe");
    }

    public void levelUp() {

        this.level++;
        this.maxHP += 10;
        this.hp = this.maxHP;
        this.maxMP += 5;
        this.mp = this.maxMP;
        this.attack += 2;
        this.defense += 1;
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
}