package unitec.rpg.ui.labels;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BarLabel extends ImageLabel {

    public BarLabel(BarType type)  {

        super(type.getImage());
        setBarValue(100);
        setUI(new BarLabelUI());
        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT,
                    new File("fonts/Gamer.ttf")).deriveFont(25.5f);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
        setFont(font);
    }

    public void setBarValue(int value) {

        setText(String.format("%d/%d", value, 100));
    }
}
