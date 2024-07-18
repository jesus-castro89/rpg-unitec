---
weight: 501
title: "Las Dimensiones de nuestros componentes"
description: "Cómo establecer el tamaño de nuestros componentes en Swing."
icon: "construction"
date: "2024-07-11T18:26:44-06:00"
lastmod: "2024-07-11T18:26:44-06:00"
draft: false
toc: true
---

## Las Dimensiones de nuestros componentes

En Swing, el tamaño de los componentes es un aspecto importante a considerar al momento de diseñar la interfaz de
usuario. Por defecto, los componentes tienen un tamaño mínimo que se ajusta a su contenido. Sin embargo, en muchos casos
es necesario establecer un tamaño específico para los componentes, ya sea para que se ajusten a un diseño específico o
para mejorar la usabilidad de la aplicación.

En nuestro caso para gestionar esta tarea, crearemos una interfaz llamada `ElementsDimension` que nos permitirá
establecer el tamaño de los componentes de la interfaz de usuario.

Para ello, crearemos una nueva interfaz en el paquete `unitec.rpg.ui.dimensions` llamada `ElementsDimension` y que
contendrá las siguiente constantes:

{{< prism lang="java" line-numbers="true" >}}

    package unitec.rpg.ui.dimensions;
    
    import javax.swing.border.EmptyBorder;
    import java.awt.*;
    
    public interface ElementsDimension {
    
        int MARGIN = 15;
        EmptyBorder MARGIN_BORDER = new EmptyBorder(MARGIN, MARGIN, MARGIN, MARGIN);
        Dimension WINDOW_SIZE = new Dimension(1280, 720);
        Dimension TOP_PANEL_SIZE = new Dimension(WINDOW_SIZE.width - (2 * MARGIN), 234);
        Dimension BOTTOM_PANEL_SIZE = new Dimension(WINDOW_SIZE.width - (2 * MARGIN), 50);
        Dimension CENTER_PANEL_SIZE = new Dimension(WINDOW_SIZE.width - (2 * MARGIN), WINDOW_SIZE.height
                - (2 * MARGIN) - TOP_PANEL_SIZE.height - BOTTOM_PANEL_SIZE.height);
    }

{{</ prism>}}

## Resumen

En este capítulo, hemos aprendido cómo establecer el tamaño de los componentes en Swing. Hemos creado una interfaz
llamada `ElementsDimension` que nos permite establecer el tamaño de los componentes de la interfaz de usuario. Esta
interfaz contiene constantes que representan el tamaño de la ventana principal y de los paneles superior, central e
inferior de la interfaz de usuario. Estas constantes nos permiten establecer un tamaño fijo para los componentes de la
interfaz de usuario, lo que nos ayuda a diseñar una interfaz coherente y atractiva para nuestra aplicación.

Esta interfaz se irá actualizando conforme vayamos necesitando más tamaños de componentes en nuestra aplicación,
recuerda que deberás de añadir las dimensiones extras que consideres para tu aplicación.