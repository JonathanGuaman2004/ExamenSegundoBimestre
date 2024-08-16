package UserInterface.Form;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import UserInterface.GJIAStyle;

/**
 * clase para el panel principal
 */
public class GJMainPanel extends JPanel{
    
    /**
     * Contructor vacio
     */
    public GJMainPanel(){
        customizeComponent();
    }

    /**
     * curtomizador de los componentes
     */
    private void customizeComponent() {
        try {
            ImageIcon imageIcon = new ImageIcon(GJIAStyle.URL_MAIN);
            add(new JLabel(imageIcon),BorderLayout.CENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
