import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;

import UserInterface.Form.GJSplashScreenForm;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import UserInterface.Form.MainForm;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        // Create a new instance of the Scanner class
        //SplashScreenForm x = new SplashScreenForm();
        //x.show();
        FlatLightLaf.setup();
        FlatLightLaf.supportsNativeWindowDecorations();
        try {
                UIManager.setLookAndFeel(new FlatAtomOneDarkIJTheme());
            } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        GJSplashScreenForm.show();
        MainForm frmMain = new MainForm("GJEcuaFauna");
    }
}
