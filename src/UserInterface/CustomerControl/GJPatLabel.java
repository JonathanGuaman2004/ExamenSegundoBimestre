package UserInterface.CustomerControl;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import UserInterface.GJIAStyle;

/**
 * clase para los label
 */
public class GJPatLabel extends JLabel{
    /**
     * Constructor Vacio
     */
    public GJPatLabel(){
        customizeComponent();
    }

    /**
     * Constructor
     * @param text: text
     */
    public GJPatLabel(String text){
        setText(text);
        customizeComponent();
    }

    /**
     * metodo para customizar componenetes
     */
    private void customizeComponent(){
        setCustomizeComponent(getText(), GJIAStyle.FONT, GJIAStyle.COLOR_FONT_LIGHT, GJIAStyle.ALIGNMENT_LEFT);
    }

    /**
     * Metodo para customizar
     * @param text: text
     * @param font: font
     * @param color: color
     * @param alignment: alignment
     */
    public void setCustomizeComponent(String text, Font  font, Color color, int alignment) {
        setText(text);
        setFont(font);
        setOpaque(false);
        setBackground(null);
        setForeground(color);
        setHorizontalAlignment(alignment);
    }
}