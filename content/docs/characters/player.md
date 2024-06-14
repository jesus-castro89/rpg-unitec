---
weight: 203
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
- Definir los atributos del jugador principal: El jugador principal tendrá los siguientes atributos:
    - `attack`: El ataque del jugador.
    - `defense`: La defensa del jugador.
    - `experience`: La experiencia del jugador.
    - `level`: El nivel del jugador.
    - `gold`: El oro del jugador.
- Implementar los métodos `getters` y `setters` para acceder y modificar los atributos de la clase `Player`.
- Implementar el método `levelUp` para subir de nivel al jugador.
- Implementar el método `gainExperience` para ganar experiencia.
- Implementar el método `attack` para atacar a un enemigo.
- Implementar el método `defend` para defenderse de un ataque enemigo.

### Definiendo la clase `Player`

Para definir la clase `Player`, necesitamos crear un nuevo archivo llamado `Player.java` en el
paquete `unitec.rpg.entities`
y agregar el siguiente código:

{{< prism lang="java" line-numbers="true">}}

    package unitec.rpg.entities;

    public class Player extends BasicCharacter {

        private int attack;
        private int defense;
        private int experience;
        private int level;
        private int gold;
    
        public Player(String name) {
            super(name);
            this.attack = 10;
            this.defense = 5;
            this.experience = 0;
            this.level = 1;
        }
    
        public Player() {
            this("John Doe");
        }
    
        public void attack(Enemy enemy) {
            int damage = this.attack - enemy.getDefense();
            if (damage > 0) {
                System.out.println(this.getName() + " ataca a " + enemy.getName() + " y le hace " + damage + " puntos de daño.");
                enemy.takeDamage(damage);
            } else {
                System.out.println(this.getName() + " ataca a " + enemy.getName() + " pero no le hace daño.");
            }
        }
    
        public void defend(Enemy enemy) {
            int damage = enemy.getAttack() - this.defense;
            this.takeDamage(damage);
        }
    
        public void levelUp() {
            this.level++;
            this.maxHP += 10;
            this.hp = this.maxHP;
            this.maxMP += 5;
            this.mp = this.maxMP;
            this.attack += 2;
            this.defense += 1;
        }
    
        public void gainExperience(int exp) {
            this.experience += exp;
            if (this.experience >= 100 * this.level) {
                levelUp();
            }
        }
    
        public void gainGold(int gold) {
            this.gold += gold;
        }

        // Getters and Setters
    }

{{< /prism >}}

En este código, hemos definido la clase `Player` con los atributos mencionados anteriormente y un constructor
que inicializa los valores de los atributos.

Ahora deberás implementar los métodos `getters` y `setters` para acceder y modificar los atributos de la clase
`Player`.

{{% alert context="danger" %}}
Si notas que el sistema marca como error la clase `Enemy`, es porque aún no la hemos definido. Puedes
seguir adelante con la definición de la clase `Player` y luego definir la clase `Enemy`.
{{% /alert %}}