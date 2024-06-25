package unitec.rpg.gui.animations;

import javax.swing.*;
import java.awt.*;

public class AnimationLabel extends JLabel {

    private final Character character;
    private final Timer timer;

    public AnimationLabel(Character character, int delay) {

        this.character = character;
        setPreferredSize(character.getSpriteSheet().getSpriteSize());
        setSize(character.getSpriteSheet().getSpriteSize());
        timer = new Timer(delay, e -> {
            character.update();
            repaint();
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(character.getCurrentAnimation().getSprite(), 0, 0, null);
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void playAnimation(String name) {
        character.playAnimation(name);
    }

    public void stopAnimation() {
        character.stopAnimation();
    }

    public void resetAnimation() {
        character.resetAnimation();
    }

    public void restartAnimation() {
        character.restartAnimation();
    }

    public Animation getCurrentAnimation() {
        return character.getCurrentAnimation();
    }

    public String getCurrentAnimationName() {
        return character.getCurrentAnimationName();
    }

    public void setDelay(int delay) {
        timer.setDelay(delay);
    }

    public int getDelay() {
        return timer.getDelay();
    }

    public void setLoop(boolean loop) {
        character.getCurrentAnimation().setLoop(loop);
    }
}
