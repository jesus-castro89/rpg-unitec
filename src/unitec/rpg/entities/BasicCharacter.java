package unitec.rpg.entities;

/**
 * Clase que representa un personaje básico en un juego de rol. Contiene los atributos básicos de un personaje
 * como nombre, nivel, experiencia, puntos de vida, puntos de maná, fuerza, destreza, inteligencia, sabiduría,
 * carisma, constitución, velocidad, defensa, resistencia y suerte.
 */
public class BasicCharacter {

    /**
     * Nombre del personaje.
     */
    private String name;
    /**
     * Nivel del personaje.
     */
    private int level;
    /**
     * Experiencia del personaje.
     */
    private int experience;
    /**
     * Oro del personaje.
     */
    private int gold;
    /**
     * Puntos de vida del personaje.
     */
    private int hp;
    /**
     * Puntos de vida máximos del personaje.
     */
    private int maxHP;
    /**
     * Puntos de magia del personaje.
     */
    private int mp;
    /**
     * Puntos de magia máximos del personaje.
     */
    private int maxMP;
    /**
     * Fuerza del personaje.
     */
    private int strength;
    /**
     * Defensa del personaje.
     */
    private int defense;
    /**
     * Destreza del personaje.
     */
    private int dexterity;
    /**
     * Inteligencia del personaje.
     */
    private int intelligence;
    /**
     * Sabiduría del personaje.
     */
    private int wisdom;
    /**
     * Carisma del personaje.
     */
    private int charisma;
    /**
     * Constitución del personaje.
     */
    private int constitution;
    /**
     * Velocidad del personaje.
     */
    private int speed;
    /**
     * Resistencia del personaje.
     */
    private int resistance;
    /**
     * Suerte del personaje.
     */
    private int luck;

    public BasicCharacter(String name, int strength, int dexterity, int intelligence, int wisdom, int charisma,
                          int constitution, int speed, int defense, int resistance, int luck) {

        this.name = name;
        this.level = 1;
        this.experience = 0;
        this.gold = 0;
        this.hp = 50;
        this.maxHP = 50;
        this.mp = 20;
        this.maxMP = 20;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.constitution = constitution;
        this.speed = speed;
        this.defense = defense;
        this.resistance = resistance;
        this.luck = luck;
    }

    public BasicCharacter() {
        this("", 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
    }

    public void takeDamage(int damage) {

        this.hp -= damage;
        System.out.println(this.name + " recibe " + damage + " puntos de daño.");
        if (this.hp <= 0) {
            System.out.println(this.name + " ha sido derrotado.");
        }
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
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

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }
}
