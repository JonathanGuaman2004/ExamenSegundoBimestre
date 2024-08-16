package UserInterface.CustomerControl;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import UserInterface.GJIAStyle;
import javax.swing.ImageIcon;

/**
 * clase para editar los botones
 */
public class GJPatButton  extends JButton implements MouseListener {
    public GJPatButton(String text){
        gjCustomizeComponent(text);
    }
    public GJPatButton(String text, String iconPath){
        gjCustomizeComponent(text, iconPath);
    }

    /**
     * Metodo para customizar
     * @param text: el texto
     * @param iconPath: iconPath
     */
    public void gjCustomizeComponent(String text, String iconPath){
        
        setSize(20, 70);
        addMouseListener(this);
        gjCustomizeComponent(text);
        setBounds(50, 30, 90, 20);
        
        setIcon(new ImageIcon(iconPath));
        setFont(GJIAStyle.FONT);
    }

    /**
     * Metodo para customizar
     * @param text: el texto
     */
    public void gjCustomizeComponent(String text) {
        setText(text);
        setOpaque(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setForeground(GJIAStyle.COLOR_FONT);
        setHorizontalAlignment(GJIAStyle.ALIGNMENT_LEFT);
        setFont(GJIAStyle.FONT);
        
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setForeground(Color.BLACK);
        setCursor(GJIAStyle.CURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setForeground(Color.GRAY);
        setCursor(GJIAStyle.CURSOR_DEFAULT);
    }
}
