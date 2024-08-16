package UserInterface.CustomerControl;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import UserInterface.GJIAStyle;

public class GJPatTextBox extends JTextField {

    /**
     * Constructor Vacio
     */
    public GJPatTextBox() {
        customizeComponent();
    }

    /**
     * metodo customizador de componenetes
     */
    private void customizeComponent() {
        setBorderRect();
        setFont(GJIAStyle.FONT);
        setForeground(GJIAStyle.COLOR_FONT_LIGHT);
        setCaretColor(GJIAStyle.COLOR_CURSOR);
        setMargin(new Insets(5, 5, 5, 5));
        setOpaque(false);
    }

    /**
     * metodo que cusomiza el borde
     */
    public void setBorderRect() {
        Border lineBorder = BorderFactory.createLineBorder(GJIAStyle.COLOR_BORDER);
        Border emptyBorder = new EmptyBorder(5, 5, 5, 5);  // Márgenes internos
        setBorder( new CompoundBorder(lineBorder, emptyBorder));
    }

    /**
     * metodo que cusomiza la linea
     */
    public void setBorderLine(){
        int thickness = 1;
        setBorder(  BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(0, 0, thickness, 0),
                    BorderFactory.createMatteBorder(0, 0, thickness, 0, GJIAStyle.COLOR_BORDER) 
        ));
    }
}
