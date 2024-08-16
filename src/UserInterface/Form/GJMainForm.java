package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * clase para las acciones de los botones del menu
 */
public class GJMainForm extends JFrame{
    GJMenuPanel pnlMenu = new GJMenuPanel();
    JPanel      pnlMain = new GJMainPanel();
    GJLoginPanel pnlLogin = new GJLoginPanel();

    /**
     * metodo para las acciones de los botones
     * @param tilteApp
     */
    public GJMainForm(String tilteApp) {
        customizeComponent(tilteApp);
        pnlMenu.btnHome.addActionListener(      e -> setPanel(new GJMainPanel()));
        pnlMenu.btnLogin.addActionListener(     e -> setPanel(new GJLoginPanel()));
        pnlMenu.btnSimulador.addActionListener(      e -> setPanel(new GJHormigaPanel()));
    }

    /**
     * ajustes del panel
     * @param formularioPanel: formularioPanel
     */
    private void setPanel(JPanel formularioPanel) {
        Container container = getContentPane();
        container.remove(pnlMain);
        pnlMain = formularioPanel;
        container.add(pnlMain, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
     
    /**
     * metodo para customizar los componentes
     * @param tilteApp: tilteApp
     */
    private void customizeComponent(String tilteApp) {
        setTitle(tilteApp);
        setSize(950, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        container.add(pnlMenu, BorderLayout.WEST);
        container.add(pnlMain, BorderLayout.CENTER);
        setVisible(true);
    }
}