package unitec.rpg.ui.labels;

import unitec.rpg.ui.cache.FontCache;

public class BarLabel extends ImageLabel {

    public BarLabel(BarType type) {

        super(type.getImage());
        setBarValue(0);
        setUI(new BarLabelUI());
        //Esto permite agregar una fuente con su nombre y la dirección al archivo a la que hace referencia
        FontCache.addFont("Gamer", "fonts/Gamer.ttf");
        //Esto permite cargar la fuente que se agregó anteriormente y modificar su tamaño a 24px
        setFont(FontCache.getFont("Gamer").deriveFont(24f));
    }

    public void setBarValue(int value) {

        setText(String.format("%d/%d", value, 100));
    }
}
