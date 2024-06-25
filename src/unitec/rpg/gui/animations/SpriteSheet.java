package unitec.rpg.gui.animations;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SpriteSheet {

    private BufferedImage sheet;
    private int spriteWidth;
    private int spriteHeight;
    private int rows;
    private int cols;
    private ArrayList<BufferedImage> sprites;

    public SpriteSheet(String path, int spriteWidth, int spriteHeight, int rows, int cols) {
        try {
            sheet = ImageIO.read(new File(path));
            this.spriteWidth = spriteWidth;
            this.spriteHeight = spriteHeight;
            this.rows = rows;
            this.cols = cols;
            sprites = new ArrayList<>();
            loadSprites();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadSprites() {
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                sprites.add(sheet.getSubimage(x * spriteWidth, y * spriteHeight, spriteWidth, spriteHeight));
            }
        }
    }

    public BufferedImage getSprite(int index) {
        return sprites.get(index);
    }

    public Dimension getSpriteSize() {
        return new Dimension(spriteWidth, spriteHeight);
    }
}