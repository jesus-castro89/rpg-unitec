package unitec.rpg.gui.animations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TestAnimation extends JFrame {
    private JPanel mainPanel;
    private JButton attackButton;
    private JButton evadeButton;
    private JPanel animationPanel;
    private JLabel animationLabel;
    private JButton damageButton;
    private JButton castButton;
    private JLabel attackLabel;
    private Character character;

    public TestAnimation() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((AnimationLabel) animationLabel).playAnimation("attack");
                ((AnimationLabel) animationLabel).getCurrentAnimation().getSupport().addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {

                        if (evt.getPropertyName().equals("done") && !(boolean) evt.getNewValue()
                                && ((AnimationLabel) animationLabel).getCurrentAnimationName().equals("attack")) {
                            ((AnimationLabel) animationLabel).playAnimation("idle");
                        }
                    }
                });
            }
        });
        evadeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((AnimationLabel) animationLabel).playAnimation("evade");
                ((AnimationLabel) animationLabel).getCurrentAnimation().getSupport().addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {

                        if (evt.getPropertyName().equals("done") && !(boolean) evt.getNewValue()
                                && ((AnimationLabel) animationLabel).getCurrentAnimationName().equals("evade")) {
                            ((AnimationLabel) animationLabel).playAnimation("idle");
                        }
                    }
                });
            }
        });
        damageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((AnimationLabel) animationLabel).playAnimation("damage");
                ((AnimationLabel) animationLabel).getCurrentAnimation().getSupport().addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {

                        if (evt.getPropertyName().equals("done") && !(boolean) evt.getNewValue()
                                && ((AnimationLabel) animationLabel).getCurrentAnimationName().equals("damage")) {
                            ((AnimationLabel) animationLabel).playAnimation("idle");
                        }
                    }
                });
            }
        });
        castButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((AnimationLabel) animationLabel).playAnimation("cast");
                ((AnimationLabel) animationLabel).getCurrentAnimation().getSupport().addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {

                        if (evt.getPropertyName().equals("done") && !(boolean) evt.getNewValue()
                                && ((AnimationLabel) animationLabel).getCurrentAnimationName().equals("cast")) {
                            ((AnimationLabel) animationLabel).playAnimation("idle");
                        }
                    }
                });
            }
        });
    }

    public static void main(String[] args) {
        new TestAnimation();
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        if (((AnimationLabel) animationLabel).getCurrentAnimation().isStopped()) {

            ((AnimationLabel) animationLabel).playAnimation("idle");
            animationLabel.repaint();
        }
    }

    private void createUIComponents() {
        character = new Character("img/actor.png", 64, 64,
                6, 9);
        character.addAnimation("idle", 3, true,
                6, 7, 8);
        character.addAnimation("attack", 5, false, 33, 34, 35, 3, 4, 5);
        character.addAnimation("evade", 5, false, 51, 52, 53);
        character.addAnimation("damage", 5, false, 42, 43, 44);
        character.addAnimation("cast", 5, false, 12, 13, 14, 21, 22, 23, 23);
        animationLabel = new AnimationLabel(character, 12);
        ((AnimationLabel) animationLabel).playAnimation("idle");
        ((AnimationLabel) animationLabel).start();
        animationLabel.setSize(64, 64);
        animationLabel.setPreferredSize(animationLabel.getSize());

        Character attack = new Character("img/animations/fire_spin.png", 128, 128, 4, 4);
        attack.addAnimation("explosion", 2, true, 1, 2, 3, 4, 5, 6, 7, 8, 9,10);
        attackLabel = new AnimationLabel(attack, 5);
        ((AnimationLabel) attackLabel).playAnimation("explosion");
        ((AnimationLabel) attackLabel).start();
    }
}
