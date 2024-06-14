---
weight: 302
title: "La batalla"
description: "Imprimamos la batalla en la consola"
icon: "swords"
date: "2024-06-13T15:18:10-06:00"
lastmod: "2024-06-13T15:18:10-06:00"
draft: false
toc: true
---

## La batalla

Para la batalla, vamos a imprimir la batalla en la consola. La batalla se llevará a cabo entre el jugador y un enemigo.
El jugador y el enemigo tendrán un conjunto de estadísticas que se compararán para determinar el resultado de la
batalla.

### Modificando la clase `BasicCharacter`

Para poder obtener la información de ataque de un personaje, vamos a modificar la clase `BasicCharacter` para que tenga
los atributos de ataque y defensa, además de un método `attack()` que devuelva un String con la información de ataque.

{{< prism lang="java" line-numbers="true" >}}

    protected int attack;
    protected int defense;

    public String attack(BasicCharacter character) {

        int damage = this.attack - character.getDefense();
        String message;
        if (damage > 0) {
            message = String.format("%s ataca a %s y le hace %d puntos de daño.\n", this.getName(), character.getName(),
                    damage);
            message += character.takeDamage(damage);
        } else {
            message = String.format("%s ataca a %s pero no le hace daño.\n", this.getName(), character.getName());
        }
        return message;
    }

{{< /prism >}}

De igual manera, modificaremos el método `takeDamage()` para que imprima un mensaje en la consola cuando un
personaje reciba daño.

{{< prism lang="java" line-numbers="true" >}}

    public String takeDamage(int damage) {

        String message;
        this.hp -= damage;
        message = String.format("%s recibe %d puntos de daño.\n", this.getName(), damage);
        if (this.hp <= 0) {

            message += String.format("%s ha muerto.\n", this.getName());
        }
        return message;
    }

{{< /prism >}}

### Modificando la clase `Player`

Deberemos eliminar los métodos `attack()` de la clase `Player` ya que ahora se encuentra en la clase `BasicCharacter`.

{{< prism lang="java" line-numbers="true" >}}

    package unitec.rpg.entities;
    
    public class Player extends BasicCharacter {

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
    }

{{< /prism >}}

### Modificando la clase `Enemy`

De igual manera, eliminaremos los métodos `attack()` de la clase `Enemy` ya que ahora se encuentra en la
clase `BasicCharacter`, además de modificar las funciones `dropLoot()`, `gainExperience()` y `gainGold()` para que
retornen un mensaje para imprimir en la consola además de que cuando un enemigo muera, el jugador ganará experiencia y
oro.

{{< prism lang="java" line-numbers="true" >}}

    package unitec.rpg.entities;
    
    public class Enemy extends BasicCharacter {

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
    
        public String dropLoot(Player player) {
    
            return gainExperience(player) + "\n" + gainGold(player);
        }
    
        public String gainExperience(Player player) {
    
            return String.format("%s gana %d puntos de experiencia.", player.getName(), this.experience);
        }
    
        public String gainGold(Player player) {
    
            return String.format("%s gana %d monedas de oro.", player.getName(), this.gold);
        }
    }

{{< /prism >}}

## Conclusiones

Hemos modificado las clases `BasicCharacter`, `Player` y `Enemy` para que tengan un método `attack()` que devuelva un
mensaje con la información de la batalla. En el siguiente capítulo, crearemos un método que simule una batalla entre el
jugador y un enemigo.