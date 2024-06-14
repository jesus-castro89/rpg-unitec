package unitec.rpg.entities;

public abstract class BasicCharacter {

    protected String name;
    protected int hp;
    protected int maxHP;
    protected int mp;
    protected int maxMP;
    protected int attack;
    protected int defense;

    public BasicCharacter(String name) {
        this.name = name;
        this.hp = 50;
        this.maxHP = 50;
        this.mp = 20;
        this.maxMP = 20;
    }

    public BasicCharacter() {
        this("John Doe");
    }

    public String attack(BasicCharacter character) {

        int damage = this.attack - character.getDefense();
        String message;
        if (damage > 0) {
            message = String.format("%s ataca a %s y le hace %d puntos de daño.\n", this.getName(), character.getName(),
                    damage);
            message += character.takeDamage(damage);
        } else {
            message = String.format("%s ataca a %s pero no le hace daño.\n", this.getName(), character.getName());
        }
        return message;
    }

    public void defend(BasicCharacter character) {

        int damage = character.getAttack() - this.defense;
        this.takeDamage(damage);
    }

    public String takeDamage(int damage) {

        String message;
        this.hp -= damage;
        message = String.format("%s recibe %d puntos de daño.\n", this.getName(), damage);
        if (this.hp <= 0) {

            message += String.format("%s ha muerto.\n", this.getName());
        }
        return message;
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    @Override
    public String toString() {
        return "BasicCharacter{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", maxHP=" + maxHP +
                ", mp=" + mp +
                ", maxMP=" + maxMP +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHP() {
        return hp;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getMP() {
        return mp;
    }

    public void setMP(int mp) {
        this.mp = mp;
    }

    public int getMaxMP() {
        return maxMP;
    }

    public void setMaxMP(int maxMP) {
        this.maxMP = maxMP;
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
}