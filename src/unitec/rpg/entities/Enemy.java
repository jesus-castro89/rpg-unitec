package unitec.rpg.entities;

public class Enemy extends BasicCharacter {

    private int attack;
    private int defense;
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

    public void attack(Player player) {
        int damage = this.attack - player.getDefense();
        if (damage > 0) {
            player.takeDamage(damage);
            System.out.println(this.getName() + " ataca a " + player.getName() + " y le hace " + damage + " puntos de daño.");
        } else {
            System.out.println(this.getName() + " ataca a " + player.getName() + " pero no le hace daño.");
        }
    }

    public void defend() {
        System.out.println(this.getName() + " se defiende.");
    }

    public void dropLoot(Player player) {
        player.gainExperience(this.experience);
        player.gainGold(this.gold);
    }

    public void gainExperience(Player player) {
        System.out.println(player.getName() + " gana " + this.experience + " puntos de experiencia.");
    }

    public void gainGold(Player player) {
        System.out.println(player.getName() + " gana " + this.gold + " monedas de oro.");
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
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