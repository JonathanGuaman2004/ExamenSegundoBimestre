package UserInterface.Form;

import java.awt.*;
import javax.swing.*;

import UserInterface.CustomerControl.GJPatButton;
import UserInterface.CustomerControl.GJPatLabel;
import UserInterface.CustomerControl.GJPatTextBox;

/**
 * panel del login
 */
public class GJLoginPanel extends JPanel {
    private GJPatLabel        lblUsername,
                            lblPassword;
    private GJPatTextBox      txtUsername;
    private GJPatTextBox  txpPassword;
    private JButton         btnLogin;

    /**
     * Contructor Vacio
     */
    public GJLoginPanel() {
        initializeComponents();
        btnLogin.addActionListener(e -> btnLoginClick());
    }

    /**
     * acciona al clicquear en el boton
     */
    private void btnLoginClick() {
        String username = txtUsername.getText();
        String password = txpPassword.getText();
        if(username.equals("1234")&&password.equals("1234")){
            JOptionPane.showMessageDialog(GJLoginPanel.this, "Usuario: " + username + "\nContraseña: " + new String(password), "Login Exitoso", JOptionPane.INFORMATION_MESSAGE);
            txtUsername.setText("");
            txpPassword.setText("");

        }else{
            JOptionPane.showMessageDialog(this, "Invalid username or password");
        }
    }

    /**
     * inicializando los componentes
     */
    private void initializeComponents() {
        lblUsername = new GJPatLabel("Username:");
        lblPassword = new GJPatLabel("Password:");
        txtUsername = new GJPatTextBox();
        txpPassword = new GJPatTextBox();
        btnLogin    = new JButton("Login");

        txtUsername.setBorderLine();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(lblUsername, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtUsername, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(lblPassword, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(txpPassword, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnLogin, gbc);

    }
}
