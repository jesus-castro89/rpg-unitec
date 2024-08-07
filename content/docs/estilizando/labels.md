---
weight: 505
title: "La UI de las etiquetas"
description: "Creando la interfaz de los paneles de la aplicación."
icon: "construction"
date: "2024-07-11T18:26:44-06:00"
lastmod: "2024-07-11T18:26:44-06:00"
draft: false
toc: true
---

## ImageLabel

{{< prism lang="java" line-numbers="true" >}}

    package unitec.rpg.ui.labels;
    
    import javax.swing.*;
    import java.awt.*;
    
    public class ImageLabel extends JLabel {
    
        public ImageLabel(ImageIcon icon) {
            super(icon);
        }
    
        @Override
        protected void paintComponent(Graphics g) {
    
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            super.paintComponent(g2d);
        }
    }

{{< /prism >}}

## BarLabelUI

{{< prism lang="java" line-numbers="true" >}}

    package unitec.rpg.ui.labels;
    
    import unitec.rpg.ui.cache.FontCache;
    import unitec.rpg.ui.dimensions.ElementsDimension;
    
    import javax.swing.*;
    import javax.swing.border.LineBorder;
    import javax.swing.plaf.basic.BasicLabelUI;
    import java.awt.*;
    
    public class BarLabelUI extends BasicLabelUI {
    
        private BarType type;
    
        public BarLabelUI(BarType type) {
    
            this.type = type;
            //Esto permite agregar una fuente con su nombre y la dirección al archivo a la que hace referencia
            FontCache.addFont("Gamer", "fonts/Gamer.ttf");
        }
    
        private int getBarValue(JLabel c) {
            return ((BarLabel) c).getBarValue();
        }
    
        private int getMaxBarValue(JLabel c) {
            return ((BarLabel) c).getMaxValue();
        }
    
        private int getBarWidth(JLabel c) {
    
            int value = getBarValue(c);
            int max = getMaxBarValue(c);
            if (value > max) {
                value = max;
            }
            if (value>0 && value <= 25) {
                value = 18;
            }
            return (int) (value * 1.0 / max * 130);
        }
    
        @Override
        protected void installDefaults(JLabel c) {
    
            c.setForeground(new Color(241, 229, 227));
            c.setIconTextGap(30);
        }
    
        @Override
        public void paint(Graphics g, JComponent c) {
    
            Graphics2D g2d = (Graphics2D) g;
            int textX = (getPreferredSize(c).width - c.getFontMetrics(c.getFont()).stringWidth(((JLabel) c).getText())) / 2;
            int textY = getPreferredSize(c).height - c.getFontMetrics(c.getFont()).getHeight() / 2;
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g2d.drawImage(type.getContainer().getImage(), c.getWidth() - 150, 1, 150, 50, null);
            g2d.drawImage(type.getBar().getImage(), 32, 10, getBarWidth((JLabel) c), 14, null);
            g2d.drawImage(type.getIcon().getImage(), 0, 0, 51, 51, null);
            g2d.setColor(Color.BLACK);
            paintEnabledText((JLabel) c, g, ((JLabel) c).getText(), textX, textY);
        }
    
        @Override
        protected void paintEnabledText(JLabel l, Graphics g, String s, int textX, int textY) {
    
            textX = l.getIconTextGap() +
                    ((ElementsDimension.BAR_LABEL.width - l.getFontMetrics(l.getFont()).stringWidth(s)) / 2);
            textY = (ElementsDimension.BAR_LABEL.height - l.getFontMetrics(l.getFont()).getHeight() / 2)
                    + 5;
            super.paintEnabledText(l, g, s, textX, textY);
        }
    
        @Override
        public Dimension getPreferredSize(JComponent c) {
            return ElementsDimension.BAR_LABEL;
        }
    }

{{< /prism >}}

## BarLabel

{{< prism lang="java" line-numbers="true" >}}

    package unitec.rpg.ui.labels;
    
    import unitec.rpg.ui.cache.FontCache;
    
    import javax.swing.*;
    
    public class BarLabel extends JLabel {
    
        private int barValue;
        private int maxValue = 100;
    
        public BarLabel(BarType type) {
    
            setBarValue(45);
            setUI(new BarLabelUI(type));
            //Esto permite agregar una fuente con su nombre y la dirección al archivo a la que hace referencia
            FontCache.addFont("Gamer", "fonts/Gamer.ttf");
            //Esto permite cargar la fuente que se agregó anteriormente y modificar su tamaño a 24px
            setFont(FontCache.getFont("Gamer").deriveFont(24f));
        }
    
        public void setBarValue(int value) {
    
            this.barValue = value;
            setText(String.format("%d/%d", value, 100));
        }
    
        public int getBarValue() {
            return barValue;
        }
    
        public void setMaxValue(int value) {
            this.maxValue = value;
        }
    
        public int getMaxValue() {
            return maxValue;
        }
    }

{{< /prism >}}

## BarType

{{< prism lang="java" line-numbers="true" >}}

    package unitec.rpg.ui.labels;
    
    import unitec.rpg.ui.cache.ImageCache;
    
    import javax.swing.*;
    
    public enum BarType {
    
        LIFE, MAGIC, EXPERIENCE;
    
        ImageIcon container;
        ImageIcon icon;
        ImageIcon bar;
    
        BarType() {
            switch (this) {
                case LIFE -> {
                    ImageCache.addImage("life_container", "img/bars/life/container.png");
                    ImageCache.addImage("life_icon", "img/bars/life/icon.png");
                    ImageCache.addImage("life_bar", "img/bars/life/bar.png");
                    container = ImageCache.getImageIcon("life_container");
                    icon = ImageCache.getImageIcon("life_icon");
                    bar = ImageCache.getImageIcon("life_bar");
                }
                case MAGIC -> {
                    ImageCache.addImage("magic_container", "img/bars/magic/container.png");
                    ImageCache.addImage("magic_icon", "img/bars/magic/icon.png");
                    ImageCache.addImage("magic_bar", "img/bars/magic/bar.png");
                    container = ImageCache.getImageIcon("magic_container");
                    icon = ImageCache.getImageIcon("magic_icon");
                    bar = ImageCache.getImageIcon("magic_bar");
                }
                case EXPERIENCE -> {
                    ImageCache.addImage("experience_container", "img/bars/experience/container.png");
                    ImageCache.addImage("experience_icon", "img/bars/experience/icon.png");
                    ImageCache.addImage("experience_bar", "img/bars/experience/bar.png");
                    container = ImageCache.getImageIcon("experience_container");
                    icon = ImageCache.getImageIcon("experience_icon");
                    bar = ImageCache.getImageIcon("experience_bar");
                }
            }
        }
    
        public ImageIcon getContainer() {
            return container;
        }
    
        public ImageIcon getIcon() {
            return icon;
        }
    
        public ImageIcon getBar() {
            return bar;
        }
    }

{{< /prism >}}

## GoldLabel

{{< prism lang="java" line-numbers="true" >}}

    package unitec.rpg.ui.labels;
    
    import unitec.rpg.ui.dimensions.ElementsDimension;
    
    import javax.swing.*;
    import javax.swing.border.LineBorder;
    import java.awt.*;
    import java.io.File;
    import java.io.IOException;
    
    public class GoldLabel extends ImageLabel {
    
        public GoldLabel() {
            super(new ImageIcon("img/labels/goldLabel.png"));
            setText(0 + " G");
            setIconTextGap(55);
            setVerticalTextPosition(SwingConstants.CENTER);
            setHorizontalTextPosition(SwingConstants.CENTER);
            Font font = null;
            try {
                font = Font.createFont(Font.TRUETYPE_FONT,
                        new File("fonts/Gamer.ttf")).deriveFont(35f);
            } catch (FontFormatException | IOException e) {
                throw new RuntimeException(e);
            }
            setFont(font);
        }
    
        @Override
        public Dimension getPreferredSize() {
            return ElementsDimension.BAR_LABEL;
        }
    
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            int textX = getIconTextGap();
            int textY = getPreferredSize().height / 2 + getFontMetrics(getFont()).getHeight() / 4;
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            g2d.drawImage(((ImageIcon) getIcon()).getImage(), 0,0,
                    getPreferredSize().width, getPreferredSize().height, null);
            g2d.drawString(getText(), textX, textY);
        }
    }

{{< /prism >}}