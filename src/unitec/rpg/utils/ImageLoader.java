package unitec.rpg.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * Clase que se encarga de cargar las imágenes.
 */
public class ImageLoader {

    /**
     * Método que se encarga de cargar una imagen.
     * @param path Ruta de la imagen.
     * @return Imagen.
     */
    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
