package unitec.rpg.gui.animations;

import javax.swing.*;
import java.util.HashMap;

public class Character {

    private final HashMap<String, Animation> animations;
    private Animation currentAnimation;
    private String currentAnimationName;
    private final SpriteSheet spriteSheet;

    public Character(String path, int spriteWidth, int spriteHeight, int rows, int cols) {
        spriteSheet = new SpriteSheet(path, spriteWidth, spriteHeight, rows, cols);
        animations = new HashMap<>();
    }

    public void addAnimation(String name, int frameDelay, boolean loop, int... indexes) {

        Animation animation = new Animation(frameDelay, loop);
        for (int index : indexes) {
            animation.addFrame(spriteSheet.getSprite(index));
        }
        animation.setFrameCount(indexes.length);
        animations.put(name, animation);
    }

    public void playAnimation(String name) {
        if (currentAnimationName != null && currentAnimationName.equals(name)) return;
        currentAnimation = animations.get(name);
        currentAnimationName = name;
        currentAnimation.restart();
    }

    public void update() {
        if (currentAnimation != null) {
            currentAnimation.update();
        }
    }

    public void stopAnimation() {
        if (currentAnimation != null) {
            currentAnimation.stop();
        }
    }

    public void resetAnimation() {
        if (currentAnimation != null) {
            currentAnimation.reset();
        }
    }

    public void restartAnimation() {
        if (currentAnimation != null) {
            currentAnimation.restart();
        }
    }

    public Animation getCurrentAnimation() {
        return currentAnimation;
    }

    public String getCurrentAnimationName() {
        return currentAnimationName;
    }

    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }
}
