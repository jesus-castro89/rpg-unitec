---
weight: 202
title: "Probando BasicCharacter"
description: "Pruebas de la clase BasicCharacter."
icon: "science"
date: "2024-05-10T00:25:18-06:00"
lastmod: "2024-05-10T00:25:18-06:00"
draft: false
toc: true
---

## Pruebas de la clase `BasicCharacter`

Para probar la clase `BasicCharacter`, necesitamos crear una clase de prueba llamada `BasicCharacterTest` en el
paquete `unitec.rpg.test` y agregar el siguiente código:

{{< prism lang="java" line-numbers="true">}}

    package unitec.rpg.test;

    import unitec.rpg.entities.BasicCharacter;

    public class BasicCharacterTest {

        public static void main(String[] args) {

            // Crear un nuevo personaje básico
            BasicCharacter character = new BasicCharacter("Alice");

            // Imprimir los atributos del personaje
            System.out.println("Nombre: " + character.getName());
            System.out.println("Salud: " + character.getHP() + "/" + character.getMaxHP());
            System.out.println("Magía: " + character.getMP() + "/" + character.getMaxMP());
        }
    }

{{< /prism >}}

En este código, hemos creado una clase de prueba `BasicCharacterTest` que crea un nuevo personaje básico con el nombre
"Alice" y muestra los atributos del personaje en la consola.

Para ejecutar la clase de prueba, haz clic derecho en la clase `BasicCharacterTest` y selecciona "Run
`BasicCharacterTest.main()`". Verás la salida con los atributos del personaje en la consola de IntelliJ IDEA.

Con esto, hemos probado con éxito la clase `BasicCharacter` y hemos verificado que los atributos del personaje se
inicializan correctamente. En los próximos tutoriales, agregaremos más funcionalidades a la clase `BasicCharacter` y
crearemos otros personajes para nuestro juego.

¡Felicitaciones por completar esta lección! 🎉