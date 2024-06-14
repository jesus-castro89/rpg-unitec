package unitec.rpg.gui.animations;

import java.awt.image.BufferedImage;

public class Animation {
    private int frameCount; // Counts ticks for change
    private int frameDelay; // frame delay 1-12 (You will have to play around with this)
    private int currentFrame; // animations current frame
    private int totalFrames; // total amount of frames for your animation

    private boolean stopped; // has animations stopped

    private BufferedImage[] sprites;

    public Animation(BufferedImage[] sprites, int frameDelay) {
        this.sprites = sprites;
        this.frameDelay = frameDelay;
        this.stopped = true;

        this.frameCount = 0;
        this.currentFrame = 0;
        this.totalFrames = this.sprites.length;
    }

    public void start() {
        if (!stopped) {
            return;
        }

        stopped = false;
    }

    public void stop() {
        if (stopped) {
            return;
        }

        stopped = true;
    }

    public void restart() {
        stopped = true;
        currentFrame = 0;
    }

    public void update() {
        if (stopped) {
            return;
        }

        frameCount++;

        if (frameCount > frameDelay) {
            frameCount = 0;
            currentFrame += 1;

            if (currentFrame > totalFrames - 1) {
                currentFrame = 0;
            }
        }
    }

    public BufferedImage getSprite() {
        return sprites[currentFrame];
    }
}
