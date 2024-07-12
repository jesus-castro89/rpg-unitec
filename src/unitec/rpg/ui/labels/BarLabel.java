package unitec.rpg.ui.labels;

import javax.swing.*;

public class BarLabel extends ImageLabel {

    public BarLabel(BarType type) {

        super(type.getImage());
        setBarValue(27);
        setUI(new BarLabelUI());
    }

    public void setBarValue(int value) {

        setText(String.format("%d/%d", value, 100));
    }
}
