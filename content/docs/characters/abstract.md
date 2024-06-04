---
weight: 306
title: "Cambiando el personaje a una clase abstracta"
description: "Creando una clase abstracta para el personaje."
icon: "science"
date: "2024-05-10T00:25:18-06:00"
lastmod: "2024-05-10T00:25:18-06:00"
draft: false
toc: true
---

## Creando una clase abstracta para el personaje

Modificaremos nuestra clase `BasicCharacter` para que sea una clase abstracta. Una clase abstracta es una clase que no
se puede instanciar directamente, pero se puede utilizar como superclase para otras clases. Para hacer que una clase sea
abstracta, simplemente agregamos la palabra clave `abstract` antes de la palabra clave `class`.

{{< prism lang="java" line-numbers="true">}}

    package unitec.rpg.entities;
    
    public abstract class BasicCharacter {
    
        protected String name;
        protected int hp;
        protected int maxHP;
        protected int mp;
        protected int maxMP;
    
        public BasicCharacter(String name) {
            this.name = name;
            this.hp = 50;
            this.maxHP = 50;
            this.mp = 20;
            this.maxMP = 20;
        }
    
        public BasicCharacter() {
            this("John Doe");
        }
    
        public void takeDamage(int damage) {
            this.hp -= damage;
            if (this.hp < 0) {
                this.hp = 0;
            }
        }
    
        public boolean isAlive() {
            return this.hp > 0;
        }
    
        public void defend(int damage) {
            this.hp -= damage;
            if (this.hp < 0) {
                this.hp = 0;
            }
        }
    
        // Getters and setters...
    }

{{< /prism >}}

Con esto nuestra clase `BasicCharacter` se ha convertido en una clase abstracta. Ahora nuestras clases `Player`
y `Enemy` pueden compartir el mismo código común en la clase `BasicCharacter`.

Recuerda eliminar las clases del paquete `unitec.rpg.test` que ya no se utilizan.