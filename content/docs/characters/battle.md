---
weight: 305
title: "Probando el combate"
description: "Pruebas de la clase Player y Enemy."
icon: "science"
date: "2024-05-10T00:25:18-06:00"
lastmod: "2024-05-10T00:25:18-06:00"
draft: false
toc: true
---

## Pruebas de la clase `Player` y `Enemy`

Para probar las clases `Player` y `Enemy`, necesitamos crear una clase de prueba llamada `BattleTest` en el
paquete `unitec.rpg.test` y agregar el siguiente código:

{{< prism lang="java" line-numbers="true">}}

    package unitec.rpg.test;

    import unitec.rpg.entities.Player;
    import unitec.rpg.entities.Enemy;

    public class BattleTest {

        public static void main(String[] args) {

            // Crear un nuevo jugador
            Player player = new Player("Alice");

            // Crear un nuevo enemigo
            Enemy enemy = new Enemy("Goblin");

            // Imprimir los atributos del jugador y el enemigo
            System.out.println("Jugador: " + player.getName());
            System.out.println("Salud: " + player.getHP() + "/" + player.getMaxHP());
            System.out.println("Magía: " + player.getMP() + "/" + player.getMaxMP());
            System.out.println("Ataque: " + player.getAttack());
            System.out.println("Defensa: " + player.getDefense());
            System.out.println("Experiencia: " + player.getExperience());
            System.out.println("Nivel: " + player.getLevel());
            System.out.println("Oro: " + player.getGold());

            System.out.println("Enemigo: " + enemy.getName());
            System.out.println("Salud: " + enemy.getHP() + "/" + enemy.getMaxHP());
            System.out.println("Magía: " + enemy.getMP() + "/" + enemy.getMaxMP());
            System.out.println("Ataque: " + enemy.getAttack());
            System.out.println("Defensa: " + enemy.getDefense());
            System.out.println("Experiencia: " + enemy.getExperience());
            System.out.println("Oro: " + enemy.getGold());

            // Realizar una batalla entre el jugador y el enemigo
            while (player.isAlive() && enemy.isAlive()) {
                player.attack(enemy);
                if (enemy.isAlive()) {
                    enemy.attack(player);
                }
            }
            if (player.isAlive()) {
                System.out.println("¡" + player.getName() + " ha derrotado a " + enemy.getName() + "!");
                enemy.dropLoot(player);
            } else {
                System.out.println("¡" + enemy.getName() + " ha derrotado a " + player.getName() + "!");
            }
        }
    }

{{< /prism >}}

En este código, hemos creado una clase de prueba `BattleTest` que crea un nuevo jugador con el nombre "Alice" y un nuevo
enemigo con el nombre "Goblin". Luego, imprimimos los atributos del jugador y el enemigo en la consola.

Después, simulamos una batalla entre el jugador y el enemigo, donde cada uno ataca al otro hasta que uno de ellos es
derrotado. Si el jugador gana la batalla, se otorgan recompensas al jugador en forma de experiencia y oro.

Para ejecutar la clase de prueba, haz clic derecho en la clase `BattleTest` y selecciona "Run `BattleTest.main()`".
Verás la salida con los atributos del jugador y el enemigo, así como el resultado de la batalla en la consola de
IntelliJ IDEA.

Con esto, hemos probado con éxito las clases `Player` y `Enemy` y hemos verificado que los personajes pueden luchar
entre sí en una batalla. En los próximos tutoriales, agregaremos más funcionalidades al juego y crearemos un mundo
completo para explorar.

¡Felicitaciones por completar esta lección! 🎉