---
weight: 303
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
- Definir los atributos específicos del enemigo: Además de los atributos heredados de `BasicCharacter`, el enemigo
  básico tendrá atributos específicos como `damage` (daño), etc.
- Implementar métodos específicos del enemigo: El enemigo básico tendrá métodos específicos como `attack` (atacar),
  `defend` (defender), etc.
- Crear una clase de prueba para el enemigo: Necesitamos crear una clase de prueba para el enemigo básico para probar
  sus métodos y atributos.
- Agregar más enemigos: Eventualmente, agregaremos más enemigos al juego con diferentes atributos y habilidades.
- Crear una interfaz gráfica para los enemigos: En el futuro, crearemos una interfaz gráfica para mostrar los enemigos
  en la pantalla.
- Implementar la lógica del combate: Implementaremos la lógica del combate para que los enemigos puedan atacar al
  jugador y viceversa.
- Mejorar la inteligencia artificial de los enemigos: Implementaremos una inteligencia artificial básica para que los
  enemigos puedan tomar decisiones durante el combate.
- Añadir sonidos y efectos visuales: Añadiremos sonidos y efectos visuales para mejorar la experiencia del jugador
  durante el combate.
- Balancear la dificultad del juego: Ajustaremos la dificultad del juego para que sea desafiante pero no imposible.
- Implementar recompensas y botín: Implementaremos recompensas y botín para que el jugador pueda obtener recompensas
  después de derrotar a los enemigos.
- Añadir jefes y enemigos especiales: Añadiremos jefes y enemigos especiales con habilidades únicas y desafiantes.
- Crear misiones y eventos: Crearemos misiones y eventos que involucren a los enemigos y proporcionen una experiencia
  de juego más inmersiva.
- Testear y depurar: Testearemos y depuraremos los enemigos para asegurarnos de que funcionen correctamente y sean
  equilibrados.
- Documentar y mantener: Documentaremos los enemigos y mantendremos su código para futuras actualizaciones y
  mejoras.
- ¡Diviértete creando enemigos!: ¡Diviértete creando enemigos y desafiando a los jugadores en tu juego de rol!

### Definiendo la clase `BasicEnemy

Para definir la clase `BasicEnemy`, necesitamos crear un nuevo archivo llamado `BasicEnemy` en el paquete
`unitec.rpg.entities` y agregar el siguiente código:

{{< prism lang="java" line-numbers="true">}}

    package unitec.rpg.entities;

    public class BasicEnemy extends BasicCharacter {

      private int damage;
  
      public BasicEnemy() {
          super();
          this.damage = 10;
      }
  
      public int getDamage() {
          return damage;
      }
  
      public void setDamage(int damage) {
          this.damage = damage;
      }
  
      public void attack(BasicCharacter target) {
          System.out.println(this.getName() + " ataca a " + target.getName() + " y le inflige " + this.damage + " puntos de daño.");
          target.takeDamage(this.damage);
      }
    }

{{< /prism >}}

### Actualizando la clase `BasicCharacter`

Para actualizar la clase `BasicCharacter`, necesitamos agregar un nuevo método llamado `takeDamage` que permita al
personaje recibir daño durante el combate. A continuación, se muestra el código actualizado de la clase
`BasicCharacter`:

{{< prism lang="java" line-numbers="true" line="43-49">}}

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
    
        public BasicCharacter() {
            this.name = "Unknown";
            this.level = 1;
            this.experience = 0;
            this.hp = 50;
            this.maxHP = 50;
            this.mp = 20;
            this.maxMP = 20;
            this.strength = 10;
            this.dexterity = 10;
            this.intelligence = 10;
            this.wisdom = 10;
            this.charisma = 10;
            this.constitution = 10;
            this.speed = 10;
            this.defense = 10;
            this.resistance = 10;
            this.luck = 10;
        }
    
        public void takeDamage(int damage) {
            this.hp -= damage;
            System.out.println(this.name + " recibe " + damage + " puntos de daño.");
            if (this.hp <= 0) {
                System.out.println(this.name + " ha sido derrotado.");
            }
        }
    
        // Getters and Setters
    }

{{< /prism >}}

En este código, hemos agregado el método `takeDamage` a la clase `BasicCharacter` para permitir que el personaje reciba
daño durante el combate. Cuando el personaje recibe daño, su salud disminuye y se comprueba si ha sido derrotado. Si la
salud del personaje llega a cero o menos, se muestra un mensaje indicando que ha sido derrotado.

En el próximo tutorial, crearemos una clase de prueba para el enemigo básico y probaremos sus métodos y atributos.
¡Sigue aprendiendo y divirtiéndote creando tu juego de rol en Java con Swing!