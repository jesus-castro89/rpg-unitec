---
weight: 304
title: "El Jugador"
description: "Creando al jugador principal."
icon: "swords"
date: "2024-05-10T00:32:41-06:00"
lastmod: "2024-05-10T00:32:41-06:00"
draft: false
toc: true
---

## Creando al jugador principal

Para crear al jugador principal, necesitamos hacer lo siguiente:

- Heredar de la clase `BasicCharacter`: El jugador principal será una subclase de la clase `BasicCharacter` con algunos
  atributos y métodos adicionales.
- Definir los atributos específicos del jugador: Además de los atributos heredados de `BasicCharacter`, el jugador
  principal tendrá atributos específicos como `experience` (experiencia), `gold` (oro), `inventory` (inventario), etc.
- Implementar métodos específicos del jugador: El jugador principal tendrá métodos específicos como `levelUp` (subir de
  nivel), `gainExperience` (ganar experiencia), `earnGold` (ganar oro), `addItemToInventory` (añadir objeto al
  inventario),
  etc.
- Crear una clase de prueba para el jugador: Necesitamos crear una clase de prueba para el jugador principal para probar
  sus métodos y atributos.
- Agregar más jugadores: Eventualmente, agregaremos más jugadores al juego con diferentes atributos y habilidades.
- Crear una interfaz gráfica para el jugador: En el futuro, crearemos una interfaz gráfica para mostrar al jugador
  principal en la pantalla.
- Implementar la lógica del juego: Implementaremos la lógica del juego para que el jugador pueda interactuar con el
  mundo del juego.
- Mejorar la inteligencia artificial del jugador: Implementaremos una inteligencia artificial básica para que el jugador
  pueda tomar decisiones durante el juego.
- Añadir sonidos y efectos visuales: Añadiremos sonidos y efectos visuales para mejorar la experiencia del jugador
  durante el juego.

### Definiendo la clase `Player`

Para definir la clase `Player`, necesitamos crear un nuevo archivo llamado `Player.java` en el
paquete `unitec.rpg.entities`
y agregar el siguiente código:

{{< prism lang="java line-numbers="true">}}

    package unitec.rpg.entities;

    import java.util.ArrayList;
    import java.util.List;

    public class Player extends BasicCharacter {

        private int experience;
        private int gold;
        private List<Item> inventory;

        public Player() {
            super();
            this.experience = 0;
            this.gold = 0;
            this.inventory = new ArrayList<>();
        }

        public void levelUp() {
            setLevel(getLevel() + 1);
            setMaxHP(getMaxHP() + 10);
            setMaxMP(getMaxMP() + 5);
            setStrength(getStrength() + 1);
            setDexterity(getDexterity() + 1);
            setIntelligence(getIntelligence() + 1);
            setWisdom(getWisdom() + 1);
            setCharisma(getCharisma() + 1);
            setHP(getMaxHP());
            setMP(getMaxMP());
        }

        public void gainExperience(int amount) {
            experience += amount;
            if (experience >= 100) {
                levelUp();
                experience -= 100;
            }
        }

        public void earnGold(int amount) {
            gold += amount;
        }

        public void addItemToInventory(Item item) {
            inventory.add(item);
        }

        // Getters and setters
    }

{{< /prism >}}

En este código, hemos definido la clase `Player` que hereda de la clase `BasicCharacter` y agrega atributos y métodos
específicos del jugador. El jugador principal tiene atributos como `experience` (experiencia), `gold` (oro) e
`inventory` (inventario) que le permiten interactuar con el mundo del juego. También hemos implementado métodos como
`levelUp` (subir de nivel), `gainExperience` (ganar experiencia), `earnGold` (ganar oro) y `addItemToInventory` (añadir
objeto al inventario) para permitir al jugador mejorar sus habilidades, ganar experiencia, ganar oro y recoger objetos
durante el juego.

### Creando al jugador principal

Para crear al jugador principal, necesitamos instanciar la clase `Player` y configurar sus atributos. Por ejemplo, para
crear un nuevo jugador llamado "Hero" con una fuerza de 10, una destreza de 10, una inteligencia de 10, una sabiduría de
10, un carisma de 10, una constitución de 10, una velocidad de 10, una defensa de 10, una resistencia de 10, una suerte
de 10, 0 puntos de experiencia, 0 monedas de oro y un inventario vacío, podemos hacer lo siguiente:

{{< prism lang="java line-numbers="true">}}

    // Crear un nuevo jugador principal
    Player hero = new Player();
    hero.setName("Hero");
    hero.setStrength(10);
    hero.setDexterity(10);
    hero.setIntelligence(10);
    hero.setWisdom(10);
    hero.setCharisma(10);
    hero.setConstitution(10);
    hero.setSpeed(10);
    hero.setDefense(10);
    hero.setResistance(10);
    hero.setLuck(10);
    hero.setExperience(0);
    hero.setGold(0);
    hero.setInventory(new ArrayList<>());

{{< /prism >}}

En este ejemplo, hemos creado un nuevo jugador principal llamado `hero` con el nombre "Hero" y los atributos mencionados
anteriormente. Este jugador puede ser controlado por el jugador durante el juego y puede interactuar con el mundo del
juego a través de sus atributos y métodos.

¡Ahora que hemos creado al jugador principal, podemos comenzar a diseñar el mundo del juego y las mecánicas de juego
para proporcionar una experiencia de juego inmersiva y emocionante para los jugadores!