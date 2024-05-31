package unitec.rpg.entities;

import unitec.rpg.util.StatsMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que representa un personaje básico en un juego de rol. Contiene los atributos básicos de un personaje
 * como nombre, nivel, experiencia, puntos de vida, puntos de maná, fuerza, destreza, inteligencia, sabiduría,
 * carisma, constitución, velocidad, defensa, resistencia y suerte.
 */
public abstract class BasicCharacter {

    /**
     * Nombre del personaje.
     */
    protected String name;
    /**
     * Puntos de vida del personaje.
     */
    protected int hp;
    /**
     * Puntos de vida máximos del personaje.
     */
    protected int maxHP;
    /**
     * Puntos de magia del personaje.
     */
    protected int mp;
    /**
     * Puntos de magia máximos del personaje.
     */
    protected int maxMP;
    /**
     * Estadísticas del personaje.
     */
    protected StatsMap stats;

    /**
     * Constructor de la clase.
     *
     * @param name         Nombre del personaje.
     * @param strength     Fuerza del personaje.
     * @param dexterity    Destreza del personaje.
     * @param intelligence Inteligencia del personaje.
     * @param wisdom       Sabiduría del personaje.
     * @param charisma     Carisma del personaje.
     * @param constitution Constitución del personaje.
     * @param speed        Velocidad del personaje.
     * @param defense      Defensa del personaje.
     * @param resistance   Resistencia del personaje.
     * @param luck         Suerte del personaje.
     */
    public BasicCharacter(String name, int strength, int dexterity, int intelligence, int wisdom, int charisma,
                          int constitution, int speed, int defense, int resistance, int luck) {

        // Inicializar los atributos del personaje.
        this.name = name;
        this.hp = 50;
        this.maxHP = 50;
        this.mp = 20;
        this.maxMP = 20;
        // Inicializar las estadísticas del personaje.
        this.stats = new StatsMap(strength, dexterity, intelligence, wisdom, charisma, constitution, speed, defense,
                resistance, luck);
    }

    public BasicCharacter() {
        this("", 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
    }

    public void takeDamage(int damage) {

        this.hp -= damage;
        System.out.println(this.name + " recibe " + damage + " puntos de daño.");
        isDead();
    }

    private void isDead() {

        if (this.hp <= 0) {
            System.out.println(this.name + " ha sido derrotado.");
        }
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

    public StatsMap getStats() {
        return stats;
    }

    public void setStats(StatsMap stats) {
        this.stats = stats;
    }
}
