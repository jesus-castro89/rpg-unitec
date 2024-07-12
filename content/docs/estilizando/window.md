---
weight: 599
title: "La clase MainWindow"
description: "Creando la clase MainWindow para la interfaz de la aplicación."
icon: "construction"
date: "2024-07-11T18:07:09-06:00"
lastmod: "2024-07-11T18:07:09-06:00"
draft: false
toc: true
---

## La clase MainWindow

Para comenzar esta nueva etapa de nuestro juego, vamos a crear la clase `MainWindow` que será la encargada de manejar la
ventana principal de la aplicación. Esta clase será la encargada de crear la ventana principal de la aplicación y de
manejar los eventos de la misma.

Por lo tanto, deberemos crear un nuevo **GUI Form** en el paquete unitec.rpg.ui.windows llamado `MainWindow` y que
extienda de `JFrame`. Y sigue los siguientes pasos:

1. Abre el paquete `unitec.rpg.ui.windows`.
2. Haz clic derecho sobre el paquete y selecciona **New > Swing UI Designer > GUI Form**.
3. En el cuadro de diálogo **New GUI Form**, escribe `MainWindow` en el campo **Name**.
4. Nombra el panel inicial como `mainPanel`.
5. Haz que la clase here de `JFrame`.
6. Agrega tres paneles al panel principal y nómbralos como `topPanel`, `centerPanel` y `bottomPanel`.
7. Agrega a la clase un atributo de tipo JDesktopPane llamado `desktopPane`.
8. Agrega un método llamado `createDesktop` que inicialice los componentes de la ventana.
9. Agrega un constructor que inicialice la ventana.

{{< prism lang="java" line-numbers="true" >}}

{{</ prism>}}