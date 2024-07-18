---
weight: 503
title: "La UI de los paneles"
description: "Creando la interfaz de los paneles de la aplicación."
icon: "construction"
date: "2024-07-11T18:26:44-06:00"
lastmod: "2024-07-11T18:26:44-06:00"
draft: false
toc: true
---

## La UI

En esta sección, crearemos la interfaz de usuario para los paneles de la aplicación. Los paneles son componentes que se
utilizan para mostrar información o interactuar con el usuario.

### Creando la interfaz

Para crear nuestra interfaz, crearemos una clase llamada `PanelUI` en el paquete `unitec.rpg.ui`. Esta clase contendrá
los métodos necesarios para crear y mostrar los paneles en la aplicación.

{{< prism lang="java" line-numbers="true" >}}

    package unitec.rpg.ui;
    
    import unitec.rpg.ui.cache.ImageCache;
    import unitec.rpg.ui.dimensions.ElementsDimension;
    
    import javax.swing.*;
    import javax.swing.plaf.basic.BasicPanelUI;
    import java.awt.*;
    import java.awt.image.BufferedImage;
    
    /**
     * Clase responsable de la apariencia de los paneles del juego.
     */
    public class PanelUI extends BasicPanelUI {
    
        /**
         * Constructor de la clase. Que se encarga de agregar a la cáche las imágenes de los paneles.
         */
        public PanelUI() {
    
            ImageCache.addImage("mainPanel", "img/panels/backgroundPanel.png");
            ImageCache.addImage("topPanel", "img/panels/statusPanel.png");
            ImageCache.addImage("centerPanel", "img/panels/mainBackground.png");
            ImageCache.addImage("bottomPanel", "img/panels/battlePanel.png");
            ImageCache.addImage("dialogPanel", "img/panels/skillPanel.png");
        }
    
        /**
         * Método que se encarga de instalar los valores por defecto de los paneles.
         *
         * @param p Panel al que se le instalarán los valores por defecto.
         */
        @Override
        protected void installDefaults(JPanel p) {
    
            p.setOpaque(false);
            if (p.getName().equals("mainPanel")) {
                p.setBorder(ElementsDimension.MARGIN_BORDER);
            } else {
                p.setBorder(BorderFactory.createEmptyBorder());
            }
        }
    
        /**
         * Método que se encarga de recuperar las dimensiones por defecto de los paneles.
         *
         * @param c Componente al que se le recuperarán las dimensiones.
         */
        @Override
        public Dimension getPreferredSize(JComponent c) {
    
            return switch (c.getName()) {
                case "topPanel" -> ElementsDimension.TOP_PANEL_SIZE;
                case "centerPanel" -> ElementsDimension.CENTER_PANEL_SIZE;
                case "bottomPanel" -> ElementsDimension.BOTTOM_PANEL_SIZE;
                case "dialogPanel" -> ElementsDimension.CONTAINER_SIZE;
                default -> ElementsDimension.WINDOW_SIZE;
            };
        }
    
        /**
         * Método que se encarga de pintar los paneles.
         *
         * @param g Gráficos del panel.
         * @param c Componente al que se le pintará.
         */
        @Override
        public void paint(Graphics g, JComponent c) {
    
            Graphics2D g2d = (Graphics2D) g;
            BufferedImage image;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            switch (c.getName()) {
                case "topPanel" -> image = ImageCache.getImage("topPanel");
                case "centerPanel" -> image = ImageCache.getImage("centerPanel");
                case "bottomPanel" -> image = ImageCache.getImage("bottomPanel");
                case "dialogPanel" -> image = ImageCache.getImage("dialogPanel");
                default -> image = ImageCache.getImage("mainPanel");
            }
            g2d.drawImage(image, 0, 0, c.getWidth(), c.getHeight(), null);
        }
    }

{{< /prism >}}

En este caso, podrás notar que se agregan imágenes a la caché en el constructor de la clase. Estas imágenes se utilizan
para pintar los paneles en la aplicación. Además, se sobrescriben los métodos `installDefaults`, `getPreferredSize` y
`paint` para instalar los valores por defecto de los paneles, recuperar las dimensiones por defecto de los paneles y
pintar los paneles, respectivamente.

Recuerda que esta clase deberá de ser adaptada a los paneles e imágenes de tu aplicación.

## Usando el UI

Para poder usar la UI, deberemos de hacer que los paneles de nuestra aplicación tengan esta UI, y además deberemos de
nombrar a las variables de manera adecuada y también deberemos de colocar el atributo `name` de la misma manera.

Recuerda que este proceso de nombrado podrás hacerlo desde la vista de diseño de tus ventanas. Y posteriormente agregar
la siguiente línea en el constructor de acuerdo a tus necesidades y a cada panal de tu interfaz.

{{< prism lang="java" >}}

    // La función setName puedes omitirla si agregas el valor en la vista de diseño.
    panel.setName("mainPanel");
    // La función setUI deberás agregarla a cada panel para que el sistema comprenda e interprete que imagen 
    // y que dimensión deberá de tener cada uno de tus paneles.
    panel.setUI(new PanelUI());

{{< /prism >}}

Recuerda que deberás de agregar la clase `PanelUI` a tu proyecto y adaptarla a tus necesidades.

## Conclusión

En esta sección, hemos creado la interfaz de usuario para los paneles de la aplicación. Hemos creado una clase llamada
`PanelUI` que nos permite instalar los valores por defecto de los paneles, recuperar las dimensiones por defecto de los
paneles y pintar los paneles en la aplicación. Además, hemos visto cómo usar esta clase en los paneles de la aplicación.