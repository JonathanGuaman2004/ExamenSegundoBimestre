package UserInterface.Form;

import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UserInterface.GJIAStyle;
import UserInterface.CustomerControl.GJPatButton;

/**
 * Clase para el panel de menu principal
 */
public class GJMenuPanel extends JPanel {
    public  GJPatButton
            btnHome     = new GJPatButton("Home"),
            btnLogin    = new GJPatButton("Login"),
            btnSimulador= new GJPatButton("Simulador");
            
    /**
     * contructor vacio
     */
    public GJMenuPanel(){
        customizeComponent();
    }

    /**
     * metodo para customizar los componentes
     */
    private void customizeComponent() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(350, getHeight())); 

        try {
            Image logo = ImageIO.read(GJIAStyle.URL_LOGO);
            logo = logo.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            add(new JLabel(new ImageIcon(logo)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        add(btnHome);
        add(btnLogin);
        add(btnSimulador);
        add(new JLabel("\u00A9 2024 Jonathan_Guaman"));
    }
}
