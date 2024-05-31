package unitec.rpg.entities;

public class Player extends BasicCharacter {

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
     * Constructor del Personaje que recibe todos los atributos e inicializa el nivel, la experiencia y el oro.
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
    public Player(String name, int strength, int dexterity, int intelligence, int wisdom, int charisma,
                  int constitution, int speed, int defense, int resistance, int luck) {

        super(name, strength, dexterity, intelligence, wisdom, charisma, constitution, speed, defense, resistance, luck);
        this.level = 1;
        this.experience = 0;
        this.gold = 0;
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

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
