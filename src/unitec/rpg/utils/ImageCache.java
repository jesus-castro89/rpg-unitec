package unitec.rpg.utils;

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
     * Método que se encarga de obtener una imagen de la caché, o agregarla si no está.
     *
     * @param imageName Ruta de la imagen.
     * @return Imagen.
     */
    public static BufferedImage getImage(String imageName, String imagePath) {

        if (cache.containsKey(imageName)) {
            return cache.get(imageName);
        } else {
            BufferedImage image = ImageLoader.loadImage(imagePath);
            cache.put(imageName, image);
            return image;
        }
    }

    public static BufferedImage getImage(String imageName) {

        return cache.getOrDefault(imageName, null);
    }

    /**
     * Método que se encarga de limpiar la caché.
     */
    public static void clearCache() {
        cache.clear();
    }

    /**
     * Método que se encarga de borrar una imagen a la caché.
     *
     * @param imageName Ruta de la imagen.
     */
    public static void removeImage(String imageName) {
        cache.remove(imageName);
    }

    /**
     * Método que se encarga de añadir una imagen a la caché.
     *
     * @param imageName Ruta de la imagen.
     * @param image     Imagen.
     */
    public static void addImage(String imageName, BufferedImage image) {

        if (!containsImage(imageName) && !containsImage(image)) {
            cache.put(imageName, image);
        }
    }

    /**
     * Método que se encarga de comprobar si la caché contiene una imagen.
     *
     * @param imageName Nombre de la imagen.
     * @return True si la imagen está en la caché, false en caso contrario.
     */
    public static boolean containsImage(String imageName) {
        return cache.containsKey(imageName);
    }

    /**
     * Método que se encarga de comprobar si la caché contiene una imagen.
     *
     * @param image Imagen a buscar en la cache.
     * @return True si la imagen está en la caché, false en caso contrario.
     */
    public static boolean containsImage(BufferedImage image) {
        return cache.containsValue(image);
    }

    /**
     * Método que se encarga de borra una imagen de la caché.
     *
     * @param imageName Nombre de la imagen.
     */
    public static void clearImage(String imageName) {
        cache.remove(imageName);
    }

    /**
     * Método que se encarga de limpiar la caché.
     */
    public static void clearAll() {
        cache.clear();
    }

    /**
     * Método que se encarga de obtener el tamaño de la caché.
     *
     * @return Tamaño de la caché.
     */
    public static int size() {
        return cache.size();
    }

    /**
     * Método que se encarga de comprobar si la caché está vacía.
     *
     * @return True si la caché está vacía, false en caso contrario.
     */
    public static boolean isEmpty() {
        return cache.isEmpty();
    }

    /**
     * Método que se encarga de obtener la caché.
     *
     * @return Caché.
     */
    public static Map<String, BufferedImage> getCache() {
        return cache;
    }
}