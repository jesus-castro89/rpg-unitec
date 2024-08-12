package unitec.rpg.exceptions;

public class PlayerDeadException extends Exception {

    public PlayerDeadException() {
        super("El jugador ha muerto.");
    }
}