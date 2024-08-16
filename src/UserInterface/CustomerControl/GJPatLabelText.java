package UserInterface.CustomerControl;

import javax.swing.*;
import UserInterface.GJIAStyle;
import java.awt.*;

/**
 * clase para los label text
 */
public class GJPatLabelText extends JPanel{
    private GJPatLabel    lblEtiqueta = new GJPatLabel();
    private GJPatTextBox  txtContenido= new GJPatTextBox();

    /**
     * Contructor Uno
     * @param etiqueta: etiqueta
     */
    public GJPatLabelText(String etiqueta) {
        setLayout(new BorderLayout());

        lblEtiqueta.setCustomizeComponent(  etiqueta, 
                                            GJIAStyle.FONT_SMALL, 
                                            GJIAStyle.COLOR_FONT_LIGHT, 
                                            GJIAStyle.ALIGNMENT_LEFT); 
        txtContenido.setBorderLine();
        add(lblEtiqueta, BorderLayout.NORTH);
        add(txtContenido, BorderLayout.CENTER);
    }
}
