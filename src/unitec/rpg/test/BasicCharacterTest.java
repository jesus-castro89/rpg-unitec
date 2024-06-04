package unitec.rpg.test;

import unitec.rpg.entities.BasicCharacter;

public class BasicCharacterTest {

    public static void main(String[] args) {

        // Crear un nuevo personaje básico
        BasicCharacter character = new BasicCharacter("Alice");

        // Imprimir los atributos del personaje
        System.out.println("Nombre: " + character.getName());
        System.out.println("Salud: " + character.getHP() + "/" + character.getMaxHP());
        System.out.println("Magía: " + character.getMP() + "/" + character.getMaxMP());
    }
}