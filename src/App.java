import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;
import UserInterface.Form.GJSplashScreenForm;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import UserInterface.Form.GJMainForm;

/**
 * @author: Jonathan Steven Guaman Maza
 */
public class App {
    /**
     * Método de Entrada Principal
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        FlatLightLaf.setup();
        FlatLightLaf.supportsNativeWindowDecorations();
        try {
                UIManager.setLookAndFeel(new FlatAtomOneDarkIJTheme());
            } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        GJSplashScreenForm.show();
        GJMainForm frmMain = new GJMainForm("GJEcuaFauna");
    }
}
