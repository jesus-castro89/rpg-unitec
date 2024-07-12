---
weight: 304
title: "El enemigo básico"
description: "Creando el enemigo básico."
icon: "swords"
date: "2024-05-10T00:32:41-06:00"
lastmod: "2024-05-10T00:32:41-06:00"
draft: false
toc: true
---

## Creando el enemigo básico

Para crear un enemigo básico, necesitamos hacer lo siguiente:

- Heredar de la clase `BasicCharacter`: El enemigo básico será una subclase de la clase `BasicCharacter` con algunos
  atributos y métodos adicionales.
- Definir los atributos del enemigo básico: El enemigo básico tendrá los siguientes atributos:
    - `attack`: El ataque del enemigo.
    - `defense`: La defensa del enemigo.
    - `experience`: La experiencia que otorga el enemigo al ser derrotado.
    - `gold`: El oro que otorga el enemigo al ser derrotado.
- Implementar los métodos `getters` y `setters` para acceder y modificar los atributos de la clase `Enemy`.
- Implementar el método `attack` para atacar al jugador.
- Implementar el método `defend` para defenderse del ataque del jugador.
- Implementar el método `dropLoot` para otorgar recompensas al jugador al ser derrotado.
- Implementar el método `gainExperience` para ganar experiencia al ser derrotado.
- Implementar el método `gainGold` para ganar oro al ser derrotado.

### Definiendo la clase `Enemy`

Para definir la clase `Enemy`, necesitamos crear un nuevo archivo llamado `Enemy.java` en el
paquete `unitec.rpg.entities` y agregar el siguiente código:

{{< prism lang="java" line-numbers="true">}}

    package unitec.rpg.entities;

    public class Enemy extends BasicCharacter {

        private int attack;
        private int defense;
        private int experience;
        private int gold;

        public Enemy(String name) {
            super(name);
            this.attack = 5;
            this.defense = 2;
            this.experience = 10;
            this.gold = 5;
        }

        public Enemy() {
            this("Goblin");
        }

        public void attack(Player player) {
            int damage = this.attack - player.getDefense();
            if (damage > 0) {
                player.takeDamage(damage);
                System.out.println(this.getName() + " ataca a " + player.getName() + " y le hace " + damage + " puntos de daño.");
            } else {
                System.out.println(this.getName() + " ataca a " + player.getName() + " pero no le hace daño.");
            }
        }

        public void defend() {
            System.out.println(this.getName() + " se defiende.");
        }

        public void dropLoot(Player player) {
            player.gainExperience(this.experience);
            player.gainGold(this.gold);
        }

        public void gainExperience(Player player) {
            System.out.println(player.getName() + " gana " + this.experience + " puntos de experiencia.");
        }

        public void gainGold(Player player) {
            System.out.println(player.getName() + " gana " + this.gold + " monedas de oro.");
        }
    }

{{< /prism >}}