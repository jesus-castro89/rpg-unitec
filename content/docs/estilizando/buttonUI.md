---
weight: 504
title: "La UI de los botones"
description: "Creando la interfaz de los botones de la aplicación."
icon: "construction"
date: "2024-07-11T18:26:44-06:00"
lastmod: "2024-07-11T18:26:44-06:00"
draft: false
toc: true
---

## La UI

Como en el caso de los paneles, podemos crear de igual manera una UI para botones de Texto y de Imagen. En este caso,
crearemos una clase llamada `ButtonUI` en el paquete `unitec.rpg.ui`. Esta clase contendrá los métodos necesarios para
crear y mostrar los botones en la aplicación.

### Creando la interfaz

Para crear nuestra interfaz, crearemos una clase llamada `ButtonUI` en el paquete `unitec.rpg.ui`. Esta clase contendrá
los métodos necesarios para crear y mostrar los botones en la aplicación.

{{< prism lang="java" line-numbers="true" >}}

    package unitec.rpg.ui;
    
    import unitec.rpg.ui.cache.FontCache;
    import unitec.rpg.ui.cache.ImageCache;
    
    import javax.swing.*;
    import javax.swing.AbstractButton;
    import javax.swing.plaf.basic.BasicButtonUI;
    import java.awt.*;
    import java.awt.image.BufferedImage;
    
    public class ButtonUI extends BasicButtonUI {
    
        /**
         * Indica si el botón es de un jugador o del juego.
         */
        private final boolean player;
        /**
         * Imágenes de los lados del botón.
         */
        private BufferedImage leftSide, centerSide, rightSide;
    
        public ButtonUI(boolean player) {
    
            this.player = player;
            loadCache();
        }
    
        private static void loadCache() {
    
            // Imágenes de los botones de los lados. Para el jugador, en modo idle
            ImageCache.addImage("leftSidePlayerIdle",
                    "img/buttons/idle/user/leftSide.png");
            ImageCache.addImage("centerSidePlayerIdle",
                    "img/buttons/idle/user/centerSide.png");
            ImageCache.addImage("rightSidePlayerIdle",
                    "img/buttons/idle/user/rightSide.png");
            // Imágenes de los botones de los lados. Para el jugador, en modo hover
            ImageCache.addImage("leftSidePlayerHover",
                    "img/buttons/hover/user/leftSide.png");
            ImageCache.addImage("centerSidePlayerHover",
                    "img/buttons/hover/user/centerSide.png");
            ImageCache.addImage("rightSidePlayerHover",
                    "img/buttons/hover/user/rightSide.png");
            // Imágenes de los botones de los lados. Para el juego, en modo idle
            ImageCache.addImage("leftSideGameIdle",
                    "img/buttons/idle/ui/leftSide.png");
            ImageCache.addImage("centerSideGameIdle",
                    "img/buttons/idle/ui/centerSide.png");
            ImageCache.addImage("rightSideGameIdle",
                    "img/buttons/idle/ui/rightSide.png");
            // Imágenes de los botones de los lados. Para el juego, en modo hover
            ImageCache.addImage("leftSideGameHover",
                    "img/buttons/hover/ui/leftSide.png");
            ImageCache.addImage("centerSideGameHover",
                    "img/buttons/hover/ui/centerSide.png");
            ImageCache.addImage("rightSideGameHover",
                    "img/buttons/hover/ui/rightSide.png");
        }
    
        private void loadIdleImages() {
    
            leftSide = player ? ImageCache.getImage("leftSidePlayerIdle") :
                    ImageCache.getImage("leftSideGameIdle");
            centerSide = player ? ImageCache.getImage("centerSidePlayerIdle") :
                    ImageCache.getImage("centerSideGameIdle");
            rightSide = player ? ImageCache.getImage("rightSidePlayerIdle") :
                    ImageCache.getImage("rightSideGameIdle");
        }
    
        private void loadHoverImages() {
    
            leftSide = player ? ImageCache.getImage("leftSidePlayerHover") :
                    ImageCache.getImage("leftSideGameHover");
            centerSide = player ? ImageCache.getImage("centerSidePlayerHover") :
                    ImageCache.getImage("centerSideGameHover");
            rightSide = player ? ImageCache.getImage("rightSidePlayerHover") :
                    ImageCache.getImage("rightSideGameHover");
        }
    
        @Override
        protected void installDefaults(AbstractButton b) {
    
            FontCache.addFont("Retron2000", "fonts/Retron2000.ttf");
            Font font = FontCache.getFont("Retron2000").deriveFont(Font.BOLD, 14f);
            b.setDoubleBuffered(true);
            b.setOpaque(false);
            b.setBorderPainted(false);
            b.setFocusPainted(false);
            b.setContentAreaFilled(false);
            b.setIconTextGap(5);
            b.setCursor(new Cursor(Cursor.HAND_CURSOR));
            b.setFont(font);
        }
    
        @Override
        public Dimension getPreferredSize(JComponent c) {
    
            int width = Math.max(c.getFontMetrics(c.getFont()).stringWidth(((JButton) c).getText()) + 60, 80);
            return new Dimension(width, 48);
        }
    
        @Override
        public void paint(Graphics g, JComponent c) {
    
            Graphics2D g2d = (Graphics2D) g;
            boolean selected = ((JButton) c).getModel().isRollover();
            if (selected) {
                loadHoverImages();
            } else {
                loadIdleImages();
            }
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2d.drawImage(leftSide, 0, 0, null);
            g2d.drawImage(centerSide, leftSide.getWidth(), 0,
                    c.getWidth() - leftSide.getWidth() * 2, c.getHeight(), null);
            g2d.drawImage(rightSide, c.getWidth() - rightSide.getWidth(), 0, null);
            super.paint(g2d, c);
        }
    }

{{< /prism >}}

Como podrás notar en este caso, se están creando dos categorías de botones en esta UI, una para botones del jugador y
otra para los botones de información del sistema.

En ambos casos se crearán dos estados: `idle` y `hover`, que cambiarán la apariencia de los botones en caso de que el
usuario coloque el Mouse sobre ellos.

De igual forma se está usando una fuente de ejemplo que podrás adecuar a tus necesidades, al igual que la forma,
segmentos y componentes de tu botón.

## El botón abstracto

Para poder utilizar esta UI en los botones de la aplicación, se creará una clase abstracta llamada `AbstractButton` en
el paquete `unitec.rpg.ui.buttons`. Esta clase contendrá los métodos necesarios para crear y mostrar los botones en la
aplicación.

{{< prism lang="java" line-numbers="true" >}}

    package unitec.rpg.ui.buttons;
    
    import unitec.rpg.ui.ButtonUI;
    
    import javax.swing.*;
    import java.awt.*;
    
    public abstract class AbstractButton extends JButton {
    
        public AbstractButton(String text, boolean player) {
    
            super(text);
            setUI(new ButtonUI(player));
        }
    
        public abstract void addAction();
    
        @Override
        public Dimension getSize(Dimension rv) {
    
            return getPreferredSize();
        }
    }

{{< /prism >}}

De esta clase podrás heredar los botones que necesites y además podrás agregar iconos a los mismos si así lo necesitas.

Como la siguiente clase por ejemplo:

{{< prism lang="java" line-numbers="true" >}}

    package unitec.rpg.ui.buttons;
    
    import unitec.rpg.ui.cache.ImageCache;
    
    import javax.swing.*;
    
    public class BlackSmithButton extends AbstractButton {
    
        public BlackSmithButton() {
    
            super("Herrero", true);
            ImageCache.addImage("blackSmithIdle", "img/icons/blackSmithIdle.png");
            ImageCache.addImage("blackSmithHover", "img/icons/blackSmithHover.png");
            setIcon(ImageCache.getImageIcon("blackSmithIdle"));
            setRolloverIcon(ImageCache.getImageIcon("blackSmithHover"));
        }
    
        @Override
        public void addAction() {
    
        }
    }

{{< /prism >}}

En este caso se agregó un icono que saldrá a la izquierda del texto en sus dos estados. Sin embargo, en tu caso puedes o
no hacer uso de estos iconos que como puedes notar, son imágenes, que se recomienda sean de no más de 32 x 32 píxeles de
tamaño.

Y para usar estos botones, deberás de marcar en la vista de diseño de tus paneles la opción `Custom Create` y asignar al
botón un objeto de la clase correspondiente en la función `private void createUIComponents()` de la siguiente manera:

{{< prism lang="java" >}}

    private void createUIComponents() {

        //Botones
        inventoryButton = new InventoryButton();
        shopButton = new ShopButton();
        blackSmithButton = new BlackSmithButton();
        attackButton = new AttackButton();
        fleeButton = new FleeButton();
        saveButton = new SaveButton();
        exitButton = new ExitButton();
    }

{{< /prism >}}