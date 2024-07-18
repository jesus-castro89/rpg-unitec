---
weight: 502
title: "Las Cache de la aplicación"
description: "Creando una cache para almacenar las imágenes y fuentes de la aplicación."
icon: "construction"
date: "2024-07-11T18:26:44-06:00"
lastmod: "2024-07-11T18:26:44-06:00"
draft: false
toc: true
---

## Las Cache de la aplicación

En muchas aplicaciones, es común que se utilicen imágenes y fuentes en varios lugares de la interfaz de usuario. Cargar
estas imágenes y fuentes cada vez que se necesitan puede ser ineficiente y ralentizar la aplicación. Para evitar esto,
podemos utilizar una caché para almacenar las imágenes y fuentes que se utilizan con frecuencia.

En nuestro caso, crearemos dos clases, `ImageCache` y `FontCache`, que nos permitirán almacenar las imágenes y fuentes
que se utilizan en nuestra aplicación. Estas clases utilizarán un `HashMap` para almacenar las imágenes y fuentes en
memoria, de modo que puedan ser accedidas rápidamente cuando se necesiten.

### Cache de imágenes

Para crear la caché de imágenes, crearemos una clase llamada `ImageCache` en el paquete `unitec.rpg.ui.cache`. Esta
clase contendrá un `HashMap` que almacenará las imágenes en caché, así como los métodos necesarios para añadir y obtener
imágenes de la caché.

{{< prism lang="java" line-numbers="true" >}}

    package unitec.rpg.ui.cache;
    
    import javax.swing.*;
    import java.awt.image.BufferedImage;
    import java.util.HashMap;
    import java.util.Map;
    
    /**
     * Clase que se encarga de almacenar en caché las imágenes que se cargan en la aplicación.
     */
    public class ImageCache {
    
        /**
         * Mapa que almacena las imágenes en caché.
         */
        private static final Map<String, BufferedImage> cache = new HashMap<>();
    
        /**
         * Método que se encarga de añadir una imagen a la caché.
         *
         * @param imageName Nombre de la imagen.
         * @param imagePath Ruta de la imagen.
         */
        public static BufferedImage addImage(String imageName, String imagePath) {
    
            BufferedImage image;
            if (!cache.containsKey(imageName)) {
    
                image = ImageLoader.loadImage(imagePath);
                cache.put(imageName, image);
            } else {
                image = cache.get(imageName);
            }
            return image;
        }
    
        /**
         * Método que se encarga de obtener una imagen de la caché.
         *
         * @param imageName Nombre de la imagen.
         * @return Imagen a retornar de la cáche o null en caso de que la imagen a buscar no exista.
         */
        public static BufferedImage getImage(String imageName) {
    
            return cache.getOrDefault(imageName, null);
        }
    
        /**
         * Método que se encarga de obtener el tamaño de la caché.
         *
         * @param imageName Nombre de la imagen.
         * @return ImageIcon de la imagen a retornar de la caché o null en caso de que la imagen a buscar no exista.
         */
        public static ImageIcon getImageIcon(String imageName) {
    
            return new ImageIcon(getImage(imageName));
        }
    }

{{</ prism>}}

Como podrás notar, la clase `ImageCache` contiene un `HashMap` llamado `cache` que almacena las imágenes en caché. Los
métodos `addImage`, `getImage` e `getImageIcon` se encargan de añadir una imagen a la caché, obtener una imagen de la
caché y obtener un `ImageIcon` de la imagen de la caché, respectivamente.

De igual manera deberemos de crear la clase `ImageLoader` que se encargará de cargar las imágenes en la aplicación:

{{< prism lang="java" line-numbers="true" >}}

    package unitec.rpg.ui.cache;
    
    import javax.imageio.ImageIO;
    import javax.swing.*;
    import java.awt.image.BufferedImage;
    import java.io.File;
    import java.io.IOException;
    
    /**
     * Clase que se encarga de cargar las imágenes.
     */
    public class ImageLoader {
    
        /**
         * Método que se encarga de cargar una imagen.
         *
         * @param path Ruta de la imagen.
         * @return Imagen.
         */
        public static BufferedImage loadImage(String path) {
    
            try {
    
                return ImageIO.read(new File(path));
            } catch (IOException e) {
                JOptionPane.showConfirmDialog(null, "Error al cargar la imagen: " + path,
                        "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            }
            return null;
        }
    }

{{</ prism>}}

### Cache de fuentes

Para crear la caché de fuentes, crearemos una clase llamada `FontCache` en el paquete `unitec.rpg.ui.cache`. Esta clase
contendrá un `HashMap` que almacenará las fuentes en caché, así como los métodos necesarios para añadir y obtener
fuentes de la caché.

{{< prism lang="java" line-numbers="true" >}}

    package unitec.rpg.ui.cache;
    
    import java.awt.*;
    import java.util.HashMap;
    import java.util.Map;
    
    /**
     * Clase que se encarga de almacenar en caché las fuentes que se cargan en la aplicación.
     */
    public class FontCache {
    
        /**
         * Mapa que almacena las fuentes en caché.
         */
        private static final Map<String, Font> cache = new HashMap<>();
    
        /**
         * Método que se encarga de añadir una fuente a la caché.
         *
         * @param fontName Nombre de la fuente.
         * @param fontPath Ruta de la fuente.
         */
        public static Font addFont(String fontName, String fontPath) {
    
            Font font;
            if (!cache.containsKey(fontName)) {
    
                font = FontLoader.loadFont(fontPath);
                cache.put(fontName, font);
            } else {
                font = cache.get(fontName);
            }
            return font;
        }
    
        /**
         * Método que se encarga de obtener una fuente de la caché.
         *
         * @param fontName Nombre de la fuente.
         * @param style    Estilo de la fuente.
         * @param size     Tamaño de la fuente.
         * @return Fuente a retornar de la caché o la fuente Arial en caso de que la fuente a buscar no exista.
         */
        public static Font getFont(String fontName, int style, int size) {
    
            return cache.getOrDefault(fontName, Font.getFont("Arial")).deriveFont(style, size);
        }
    
        /**
         * Método que se encarga de obtener una fuente de la caché.
         *
         * @param fontName Nombre de la fuente.
         * @return Fuente a retornar de la caché o la fuente Arial en caso de que la fuente a buscar no exista.
         */
        public static Font getFont(String fontName) {
    
            return getFont(fontName, Font.PLAIN, 12);
        }
    
        /**
         * Método que se encarga de obtener una fuente de la caché.
         *
         * @param fontName Nombre de la fuente.
         * @param size     Tamaño de la fuente.
         * @return Fuente a retornar de la caché o la fuente Arial en caso de que la fuente a buscar no exista.
         */
        public static Font getFont(String fontName, int size) {
    
            return getFont(fontName, Font.PLAIN, size);
        }
    }

{{</ prism>}}

De igual manera deberemos de crear la clase `FontLoader` que se encargará de cargar las fuentes en la aplicación:

{{< prism lang="java" line-numbers="true" >}}

    package unitec.rpg.ui.cache;
    
    import javax.swing.*;
    import java.awt.*;
    import java.io.File;
    
    /**
     * Clase que se encarga de cargar las fuentes.
     */
    public class FontLoader {
    
        /**
         * Método que se encarga de cargar una fuente.
         *
         * @param path Ruta de la fuente.
         * @return La fuente ya cargada en formato simple y tamaño 12px. En caso de error se regresará la fuente Arial 12.
         */
        public static Font loadFont(String path) {
    
            try {
    
                return Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(12f);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cargar la fuente: " + path,
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
            return Font.getFont("Arial").deriveFont(12f);
        }
    }

{{</ prism>}}

## Resumen

En este capítulo, hemos aprendido cómo crear una caché para almacenar las imágenes y fuentes que se utilizan en nuestra
aplicación. Hemos creado las clases `ImageCache` y `FontCache` que nos permiten almacenar las imágenes y fuentes en
caché, respectivamente. Estas clases utilizan un `HashMap` para almacenar las imágenes y fuentes en memoria, de modo que
puedan ser accedidas rápidamente cuando se necesiten.