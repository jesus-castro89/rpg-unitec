package unitec.rpg.entities;

public class BasicEnemy extends BasicCharacter {

    private int damage;

    public BasicEnemy() {
        super();
        this.damage = 10;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void attack(BasicCharacter target) {

        System.out.println(this.getName() + " ataca a " + target.getName() + " y le inflige " + this.damage + " puntos de daño.");
        target.takeDamage(this.damage);
    }
}
