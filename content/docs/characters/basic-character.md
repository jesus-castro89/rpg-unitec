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
- Salud (HP) y Salud Máxima (MaxHP): La salud y la salud máxima del personaje.
- Magía (MP) y Magía Máxima (MaxMP): La magía y la magía máxima del personaje.

Así mismo, la clase contará con los siguientes métodos:

- `getters` y `setters`: Para acceder y modificar los atributos de la clase.
- `takeDamage`: Para recibir daño.
- `isAlive`: Para verificar si el personaje sigue con vida.

Estos atributos son comunes a todos los personajes del juego y se pueden extender en subclases para agregar más
características específicas de cada personaje.

Por ahora, usaremos los atributos mencionados anteriormente, sin embargo, eventualmente agregaremos más atributos a
medida que avancemos en el desarrollo del juego.

### Definiendo la clase `BasicCharacter`

Para definir la clase `BasicCharacter`, necesitamos crear un nuevo archivo llamado `BasicCharacter.java` en el
paquete `unitec.rpg.entities` y agregar el siguiente código:

{{< prism lang="java" line-numbers="true">}}

    package unitec.rpg.entities;
    
    public class BasicCharacter {
    
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
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }

        // Getters and Setters
    }

{{< /prism >}}

En este código, hemos definido la clase `BasicCharacter` con los atributos mencionados anteriormente y un constructor
que inicializa los valores de los atributos.

Ahora deberás implementar los métodos `getters` y `setters` para acceder y modificar los atributos de la clase
`BasicCharacter`.

### Implementando los métodos `getters` y `setters`

Para implementar los métodos get y set de cada atributo, puedes emplear la funcionalidad de autogeneración de código
de tu IDE o escribirlos manualmente. A continuación, se muestra un ejemplo de cómo implementar los métodos `getters` y
`setters` para el atributo `name`:

{{< prism lang="java" line-numbers="true">}}

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

{{< /prism >}}

{{% alert context="primary" %}}
En IntelliJ puedes invocar la autogeneración mediante las teclas `Ctrl` + `Insert` y seleccionar la
opción `Getter and Setter`.
{{< figure src="/rpg-unitec/images/start/img_5.png" alt="Menu Generate"  >}}
Posteriormente seleccionar todos los atributos de la clase y por último dar clic al botón `OK`.
{{< figure src="/rpg-unitec/images/start/img_6.png" alt="Selección de Atributos"  >}}
Este proceso puedes realizarlo en todas las clases del proyecto en las que necesites los métodos `getters` y `setters`.
{{% /alert %}}

Así mismo deberás crear un nuevo constructor sin parámetros para inicializar los atributos con valores predeterminados.

{{% alert context="primary" %}}
En IntelliJ puedes invocar la autogeneración mediante las teclas `Ctrl` + `Insert` y seleccionar la
opción `Constructor`.
{{< figure src="/rpg-unitec/images/start/img_5.png" alt="Menu Generate"  >}}
Posteriormente seleccionar todos los atributos de la clase y por último dar clic al botón `OK`.
{{< figure src="/rpg-unitec/images/start/img_7.png" alt="Selección de Atributos"  >}}
Este proceso puedes realizarlo en todas las clases del proyecto en las que necesites un constructor sin parámetros.
{{% /alert %}}

En el siguiente tutorial, aprenderás a probar la clase `BasicCharacter` y a crear instancias de personajes básicos.

## Referencias

- [Clases y Objetos en Java](https://docs.oracle.com/javase/tutorial/java/javaOO/index.html)
- [Constructores en Java](https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html)
- [Métodos Getters y Setters en Java](https://docs.oracle.com/javase/tutorial/java/javaOO/getters.html)
- [Encapsulamiento en Java](https://docs.oracle.com/javase/tutorial/java/javaOO/encapsulation.html)