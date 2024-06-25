package unitec.rpg.gui.animations;

import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Animation {

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private int frameCount; // Counts ticks for change
    private int frameDelay; // frame delay 1-12 (You will have to play around with this)
    private int currentFrame; // animations current frame
    private int totalFrames; // total amount of frames for your animation
    private boolean stopped; // has animations stopped
    private boolean loop; // should it loop
    private boolean done; // has it played through once
    private ArrayList<BufferedImage> sprites;

    public Animation(int frameDelay, boolean loop) {

        this.frameDelay = frameDelay;
        this.loop = loop;
        frameCount = 0;
        currentFrame = 0;
        stopped = true;
        done = false;
        sprites = new ArrayList<>();
    }

    public void addFrame(BufferedImage sprite) {
        sprites.add(sprite);
        totalFrames = sprites.size();
    }

    public void start() {

        if (!stopped) return;
        if (sprites.isEmpty()) return;
        stopped = false;
    }

    public void stop() {

        if (sprites.isEmpty()) return;
        stopped = true;
        setDone(false);
    }

    public void restart() {

        if (sprites.isEmpty()) return;
        stopped = false;
        currentFrame = 0;
    }

    public void reset() {

        stopped = true;
        done = false;
        currentFrame = 0;
    }

    public void update() {
        if (!stopped) {
            frameCount++;

            if (frameCount > frameDelay) {
                frameCount = 0;
                currentFrame++;

                if (currentFrame == totalFrames) {
                    currentFrame = 0;
                    done = true;

                    if (!loop) {
                        stop();
                    }
                }
            }
        }
    }

    public BufferedImage getSprite() {
        return sprites.get(currentFrame);
    }

    public boolean isStopped() {
        return stopped;
    }

    public boolean isDone() {
        return done;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public void setFrameDelay(int frameDelay) {
        this.frameDelay = frameDelay;
    }

    public void setSprites(ArrayList<BufferedImage> sprites) {
        this.sprites = sprites;
    }

    public void setTotalFrames(int totalFrames) {
        this.totalFrames = totalFrames;
    }

    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }

    public void setFrameCount(int frameCount) {
        this.frameCount = frameCount;
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    public void setDone(boolean done) {
        boolean oldDone = this.done;
        this.done = done;
        support.firePropertyChange("done", oldDone, done);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public PropertyChangeSupport getSupport() {
        return support;
    }
}
