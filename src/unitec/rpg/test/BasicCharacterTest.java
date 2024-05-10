package unitec.rpg.test;

import unitec.rpg.entities.BasicCharacter;

public class BasicCharacterTest {

    public static void main(String[] args) {

        // Crear un nuevo personaje básico
        BasicCharacter character = new BasicCharacter();

        // Establecer los atributos del personaje
        character.setName("Aragorn");
        character.setLevel(1);
        character.setExperience(0);
        character.setHP(100);
        character.setMaxHP(100);
        character.setMP(50);
        character.setMaxMP(50);
        character.setStrength(10);
        character.setDexterity(10);
        character.setIntelligence(10);
        character.setWisdom(10);
        character.setCharisma(10);

        // Mostrar los atributos del personaje
        System.out.println("Nombre: " + character.getName());
        System.out.println("Nivel: " + character.getLevel());
        System.out.println("Experiencia: " + character.getExperience());
        System.out.println("Salud: " + character.getHP() + "/" + character.getMaxHP());
        System.out.println("Magía: " + character.getMP() + "/" + character.getMaxMP());
        System.out.println("Fuerza: " + character.getStrength());
        System.out.println("Destreza: " + character.getDexterity());
        System.out.println("Inteligencia: " + character.getIntelligence());
        System.out.println("Sabiduría: " + character.getWisdom());
        System.out.println("Carisma: " + character.getCharisma());
    }
}
