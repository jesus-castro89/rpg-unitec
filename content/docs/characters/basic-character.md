---
weight: 301
title: "BasicCharacter"
description: "Creando el personaje básico."
icon: "person"
date: "2024-05-10T00:11:44-06:00"
lastmod: "2024-05-10T00:11:44-06:00"
draft: false
toc: true
tags: [ "personaje", "personajes", "jugador", "principal", "secundarios", "crear", "diseñar" ]
---

## Creando el personaje básico

Para crear un personaje básico, necesitamos definir los siguientes atributos:

- Nombre del personaje (Name): El nombre del personaje.
- Nivel (Level): El nivel del personaje.
- Experiencia (Experience): La experiencia del personaje.
- Oro (Gold): La cantidad de oro del personaje.
- Salud (HP) y Salud Máxima (MaxHP): La salud y la salud máxima del personaje.
- Magía (MP) y Magía Máxima (MaxMP): La magía y la magía máxima del personaje.
- Fuerza (Strength): La fuerza del personaje.
- Destreza (Dexterity): La destreza del personaje.
- Inteligencia (Intelligence): La inteligencia del personaje.
- Sabiduría (Wisdom): La sabiduría del personaje.
- Carisma (Charisma): El carisma del personaje.
- Constitución (Constitution): La constitución del personaje.
- Velocidad (Speed): La velocidad del personaje.
- Defensa (Defense): La defensa del personaje.
- Resistencia (Resistance): La resistencia del personaje.
- Suerte (Luck): La suerte del personaje.
- Otros atributos: Pueden incluirse otros atributos como oro, habilidades, hechizos, etc.

Por ahora, usaremos los atributos mencionados anteriormente, sin embargo, eventualmente agregaremos más atributos a
medida que avancemos en el desarrollo del juego.

### Definiendo la clase `BasicCharacter`

Para definir la clase `BasicCharacter`, necesitamos crear un nuevo archivo llamado `BasicCharacter.java` en el
paquete `unitec.rpg.entities` y agregar el siguiente código:

{{< prism lang="java" line-numbers="true">}}

    package unitec.rpg.entities;
    
    public class BasicCharacter {

        private String name;
        private int level;
        private int experience;
        private int hp;
        private int maxHP;
        private int mp;
        private int maxMP;
        private int strength;
        private int dexterity;
        private int intelligence;
        private int wisdom;
        private int charisma;
        private int constitution;
        private int speed;
        private int defense;
        private int resistance;
        private int luck;
    
        public BasicCharacter(String name, int strength, int dexterity, int intelligence, int wisdom, int charisma,
                          int constitution, int speed, int defense, int resistance, int luck) {
            this.name = name;
            this.level = 1;
            this.experience = 0;
            this.hp = 50;
            this.maxHP = 50;
            this.mp = 20;
            this.maxMP = 20;
            this.strength = strength;
            this.dexterity = dexterity;
            this.intelligence = intelligence;
            this.wisdom = wisdom;
            this.charisma = charisma;
            this.constitution = constitution;
            this.speed = speed;
            this.defense = defense;
            this.resistance = resistance;
            this.luck = luck;
        }
    
        // Getters and Setters
    }

{{< /prism >}}

En este código, hemos definido la clase `BasicCharacter` con los atributos mencionados anteriormente y un constructor
que inicializa los valores de los atributos.

Ahora deberás implementar los métodos `getters` y `setters` para acceder y modificar los atributos de la clase
`BasicCharacter`.

Así mismo deberás crear un nuevo constructor sin parámetros para inicializar los atributos con valores predeterminados.

En el siguiente tutorial, aprenderás a probar la clase `BasicCharacter` y a crear instancias de personajes básicos.

## Referencias

- [Clases y Objetos en Java](https://docs.oracle.com/javase/tutorial/java/javaOO/index.html)
- [Constructores en Java](https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html)
- [Métodos Getters y Setters en Java](https://docs.oracle.com/javase/tutorial/java/javaOO/getters.html)
- [Encapsulamiento en Java](https://docs.oracle.com/javase/tutorial/java/javaOO/encapsulation.html)