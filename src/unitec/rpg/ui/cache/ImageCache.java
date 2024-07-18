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