package unitec.rpg.ui.labels;

import unitec.rpg.ui.cache.FontCache;

import javax.swing.*;

public class BarLabel extends JLabel {

    private int barValue;
    private int maxValue;

    public BarLabel(BarType type, int barValue, int maxValue) {

        this.maxValue = maxValue;
        setBarValue(barValue);
        setUI(new BarLabelUI(type));
        //Esto permite agregar una fuente con su nombre y la dirección al archivo a la que hace referencia
        FontCache.addFont("Gamer", "fonts/Gamer.ttf");
        //Esto permite cargar la fuente que se agregó anteriormente y modificar su tamaño a 24px
        setFont(FontCache.getFont("Gamer").deriveFont(24f));
    }

    public void setBarValue(int value) {

        this.barValue = value;
        setText(String.format("%d/%d", value, maxValue));
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
