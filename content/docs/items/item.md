---
weight: 401
title: "Item"
description: "Definición de un objeto del juego."
icon: "article"
date: "2024-05-31T14:30:15-06:00"
lastmod: "2024-05-31T14:30:15-06:00"
draft: false
toc: true
---

## Definición de un objeto del juego

Un objeto del juego es un elemento que se puede recoger, usar, comprar, vender o intercambiar en el juego. Los objetos
pueden ser armas, armaduras, pociones, hechizos, llaves, tesoros, etc. Cada objeto tiene un nombre, una descripción, un
precio y otros atributos que lo definen. Los objetos pueden ser parte del inventario del jugador, del botín de
un enemigo, de un cofre del tesoro o de una tienda. Los objetos pueden tener efectos positivos o negativos en el
jugador, como aumentar la salud, la magia, la fuerza, la defensa, la velocidad, etc. o disminuir la salud, la magia, la
fuerza, la defensa, la velocidad, etc.

### Definiendo la clase `Item`

Para definir la clase `Item`, necesitamos crear un nuevo archivo llamado `Item.java` en el paquete `unitec.rpg.entities`
y agregar el siguiente código:

{{< prism lang="java" line-numbers="true" line="43-49">}}

    package unitec.rpg.entities;
    
    public class Item {
    
        private String name;
        private String description;
        private int value;
    
        public Item(String name, String description, int value) {
            this.name = name;
            this.description = description;
            this.value = value;
        }

        // Getters and setters
    }

{{< /prism >}}

En este código, hemos definido la clase `Item` con tres atributos: `name` (nombre), `description` (descripción)
y `value` (costo). También hemos definido un constructor que inicializa los valores de los atributos. La clase `Item` 
es una clase base que puede ser extendida para crear diferentes tipos de objetos del juego, como armas, armaduras, pociones,
hechizos, llaves, tesoros, etc.

### Creando un objeto del juego

Para crear un objeto del juego, necesitamos instanciar la clase `Item` con un nombre, una descripción y un valor. Por
ejemplo, para crear una espada mágica llamada "Excalibur" con una descripción "Una espada legendaria que corta a través
de la oscuridad" y un valor de 1000 monedas de oro, podemos hacer lo siguiente:

{{< prism lang="java line-numbers="true">}}

    // Crear un nuevo objeto del juego
    Item sword = new Item("Excalibur", "Una espada legendaria que corta a través de la oscuridad", 1000);

{{< /prism >}}

En este ejemplo, hemos creado un nuevo objeto del juego llamado `sword` con el nombre "Excalibur", la descripción "Una
espada legendaria que corta a través de la oscuridad" y un valor de 1000 monedas de oro. Este objeto puede ser usado
por el jugador, vendido en una tienda, encontrado en un cofre del tesoro, etc.