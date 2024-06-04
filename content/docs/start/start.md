---
weight: 201
title: "Creando el proyecto y la primera clase"
icon: "rocket_launch"
date: "2024-05-09T11:58:11-06:00"
lastmod: "2024-05-09T11:58:11-06:00"
draft: false
toc: true
---

Para iniciar el proyecto de UNITEC RPG en Java con Swing, necesitas tener instalado un IDE de Java, como Eclipse o
IntelliJ IDEA. En este tutorial, vamos a utilizar IntelliJ IDEA para crear el proyecto.

## Paso 1: Crear un nuevo proyecto

Abre IntelliJ IDEA y selecciona la opción "New > Project" en la pantalla de bienvenida. Selecciona "Java" en la
lista de opciones y haz clic en "Create". En nuestro caso usaremos Java 22.

{{< figure src="/rpg-unitec/images/start/img.png" alt="Descripción de la imagen" >}}

## Paso 2: Crear un nuevo paquete

Una vez que hayas creado el proyecto, crea un nuevo paquete llamado `unitec.rpg` en el directorio `src`. Haz clic
derecho en el directorio `src` y selecciona "New > Package". Escribe `unitec.rpg` en el campo y presiona enter.

{{< figure src="/rpg-unitec/images/start/img_1.png" alt="Descripción de la imagen"  >}}

## Paso 3: Crear una nueva clase

Dentro del paquete `unitec.rpg`, crea una nueva clase llamada `Main`. Haz clic derecho en el paquete `unitec.rpg`
y selecciona "New > Java Class". Escribe `Main` en el campo y presiona enter.

{{< figure src="/rpg-unitec/images/start/img_2.png" alt="Descripción de la imagen"  >}}

{{< figure src="/rpg-unitec/images/start/img_3.png" alt="Descripción de la imagen"  >}}

## Paso 4: Escribir el código inicial

Abre la clase `Main` y escribe el siguiente código:

{{< prism lang="java" line-numbers="true">}}

    package unitec.rpg;

    public class Main {
        public static void main(String[] args) {
        
            System.out.println("Hola, UNITEC RPG!");
        }
    }

{{< /prism >}}

Este código imprimirá "Hola, UNITEC RPG!", en la consola cuando ejecutes el programa.

## Paso 5: Ejecutar el programa

Para ejecutar el programa, haz clic derecho en la clase `Main` y selecciona "Run 'Main.main()'". Verás la salida
"Hola, UNITEC RPG!", en la consola de IntelliJ IDEA.

{{< figure src="/rpg-unitec/images/start/img_4.png" alt="Descripción de la imagen"  >}}

¡Felicidades! Has iniciado el proyecto de UNITEC RPG en Java con Swing. En los siguientes tutoriales, aprenderás a
crear la interfaz gráfica del juego y a implementar sus funcionalidades.

# Referencias

- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [Java](https://www.java.com/es/)
- [Swing](https://docs.oracle.com/javase/8/docs/technotes/guides/swing/)