package unitec.rpg.entities;

/**
 * Tipo Enumerado que representa las estadísticas de un personaje en un juego de rol.
 */
public enum Stats {

    /**
     * Fuerza del personaje.
     */
    STRENGTH("Fuerza"),
    /**
     * Defensa del personaje.
     */
    DEFENSE("Defensa"),
    /**
     * Destreza del personaje.
     */
    DEXTERITY("Destreza"),
    /**
     * Inteligencia del personaje.
     */
    INTELLIGENCE("Inteligencia"),
    /**
     * Sabiduría del personaje.
     */
    WISDOM("Sabiduría"),
    /**
     * Carisma del personaje.
     */
    CHARISMA("Carisma"),
    /**
     * Constitución del personaje.
     */
    CONSTITUTION("Constitución"),
    /**
     * Velocidad del personaje.
     */
    SPEED("Velocidad"),
    /**
     * Suerte del personaje.
     */
    LUCK("Suerte"),
    /**
     * Resistencia del personaje.
     */
    RESISTANCE("Resistencia");

    /**
     * Nombre de la estadística.
     */
    private final String name;

    /**
     * Constructor de la clase.
     *
     * @param name Nombre de la estadística.
     */
    Stats(String name) {

        this.name = name;
    }

    /**
     * Método que devuelve el nombre de la estadística.
     *
     * @return Nombre de la estadística.
     */
    public String getName() {

        return name;
    }
}
