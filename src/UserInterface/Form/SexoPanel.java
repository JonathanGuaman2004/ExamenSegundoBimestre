package UserInterface.Form;

import javax.swing.*;

import BusinessLogic.GJHormigaBL;
import DataAccess.DTO.GJHormiga_DTO;
import UserInterface.GJIAStyle;
import UserInterface.CustomerControl.PatButton;
import UserInterface.CustomerControl.PatLabel;
import UserInterface.CustomerControl.PatTextBox;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SexoPanel  extends JPanel implements ActionListener {
    private Integer rowNum = 0, idRowMaxSexo=0;
    private GJHormigaBL  gjHormigaBL  = new GJHormigaBL();
    private GJHormiga_DTO gjHormigaDAO = null;
    private String [] gjItemsGenoAlimento = {"X","XX","XY"};
    private String [] gjItemsIngestaNativa = {"Hervivoro","Carnivoro","Omnivoro","Insectivoro"};
    JComboBox<String> gjComboBoxGenoAlimento = new JComboBox<>(gjItemsGenoAlimento);
    JComboBox<String> gjComboBoxIngestaNativa = new JComboBox<>(gjItemsIngestaNativa);

/************************
* FormDesing : pat_mic
************************/ 
    private PatLabel 
        lblTitulo   = new PatLabel("SEXO"),
        lblrowNum   = new PatLabel(" Codigo:      "),
        lblNombre   = new PatLabel("*Descripción: "),
        lblTotalReg = new PatLabel(" 0 de 0 "),
        lblGenoAlimento  = new PatLabel("Geno - Alimento"),
        lblIngestaNativa = new PatLabel("Ingesta Nativa");
    private PatTextBox 
        txtrowNum   = new PatTextBox(),
        txtNombre   = new PatTextBox();
    private PatButton 
        btnPageIni  = new PatButton(" |< "),
        btnPageAnt  = new PatButton(" << "),
        btnPageSig  = new PatButton(" >> "),
        btnPageFin  = new PatButton(" >| "),

        btnRowIni   = new PatButton(" |< "),
        btnRowAnt   = new PatButton(" << "),
        btnRowSig   = new PatButton(" >> "),
        btnRowFin   = new PatButton(" >| "),

        btnCrear    = new PatButton("Crear Hormiga Larva"),
        btnAlimeGeno= new PatButton("Crear Hormiga Larva"),
        btnAlimeInge= new PatButton("Crear Hormiga Larva"),

        btnGuardar  = new PatButton("Guardar"),
        //btnCancelar = new PatButton("Cancelar"),
        btnEliminar = new PatButton("Eliminar");
    private JPanel 
        pnlTabla    = new JPanel(),
        pnlBtnRow   = new JPanel(new FlowLayout()),
        pnlBtnCrear = new JPanel(new FlowLayout()),
        pnlBtnGenoA = new JPanel(new FlowLayout()),
        pnlBtnInges = new JPanel(new FlowLayout()),
        //pnlBtnPage  = new JPanel(new FlowLayout()),
        pnlBtnCRUD  = new JPanel(new FlowLayout());

    public SexoPanel() {
        try {
            customizeComponent();
            loadRow();
            showRow();
            showTable();

            btnRowIni.addActionListener(this);
            btnRowAnt.addActionListener(this);
            btnRowSig.addActionListener(this);
            btnRowFin.addActionListener(this);
            
            btnCrear.addActionListener(     e -> {
                try {
                    btnNuevoClick();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });
            btnGuardar.addActionListener(   e -> btnGuardarClick());
            btnEliminar.addActionListener(  e -> btnEliminarClick());
            btnAlimeGeno.addActionListener(  e -> btnUpdateAlimeGeno());
            btnAlimeInge.addActionListener(  e -> btnUpdateAlimeInge());
        } catch (Exception e) {
            GJIAStyle.showMsg(e.getMessage());
        }
    }

    private void btnUpdateAlimeInge() {
        try {
            if (GJIAStyle.showConfirmYesNo("¿Seguro que desea ACTUALIZAR ?")){
                gjHormigaDAO.setGjIngestaNativa(gjObtenerDatoComboBox2(gjComboBoxIngestaNativa));
                if(gjHormigaBL.gjUpdateIngAliment(gjHormigaDAO)){
                    GJIAStyle.showMsg("Se actualizó la alimentación genética de la hormiga");
                }
                loadRow();
                showRow();
                showTable();
            }
        } catch (Exception e) {
            GJIAStyle.showMsgError(e.getMessage());
        }
    }

    private Integer gjObtenerDatoComboBox2(JComboBox<String> gjComboBoxDos) {
        if(gjComboBoxDos.getSelectedItem().equals("Carnivoro")){
            return 4;
        }else if(gjComboBoxDos.getSelectedItem().equals("Hervivoro")){
            return 5;
        }else if(gjComboBoxDos.getSelectedItem().equals("Omnivoro")){
            return 6;
        }else if(gjComboBoxDos.getSelectedItem().equals("Insectivoro")){
            return 7;
        }
        return -1;
    }

    private void btnUpdateAlimeGeno() {
        try {
            if (GJIAStyle.showConfirmYesNo("¿Seguro que desea ACTUALIZAR ?")){
                gjHormigaDAO.setGjGenoAlimento(gjObtenerDatoComboBox1(gjComboBoxGenoAlimento));
                if(gjHormigaBL.gjUpdateGenAliment(gjHormigaDAO)){
                    GJIAStyle.showMsg("Se actualizó la alimentación genética de la hormiga");
                }
                loadRow();
                showRow();
                showTable();
            }
        } catch (Exception e) {
            GJIAStyle.showMsgError(e.getMessage());
        }
    }

    private Integer gjObtenerDatoComboBox1(JComboBox<String> gjComboBoxUno) {
        if(gjComboBoxUno.getSelectedItem().equals("X")){
            return 8;
        }else if(gjComboBoxUno.getSelectedItem().equals("XX")){
            return 9;
        }else if(gjComboBoxUno.getSelectedItem().equals("XY")){
            return 10;
        }
        return -1;
    }

    private void loadRow()  {
        try {
            rowNum      = 1;
            gjHormigaDAO= gjHormigaBL.gjGetBy(rowNum);
            idRowMaxSexo= gjHormigaBL.gjGetRowCount();
        } catch (Exception e) {
            GJIAStyle.showMsg(e.getMessage());
        }
    }
///iMPORTANTE
    private void showRow() {
        boolean gjHormigaNull = (gjHormigaDAO == null);
        txtrowNum.setText((gjHormigaNull) ? " " : gjHormigaDAO.getGjIDHormiga().toString());
        txtNombre.setText((gjHormigaNull) ? " " : gjHormigaDAO.getGjTipoHormiga());
        lblTotalReg.setText(rowNum.toString() + " de " + idRowMaxSexo.toString());
    }

    private void btnNuevoClick() throws Exception{
        gjHormigaBL.gjAdd();
        //revisar sigulinea
        gjHormigaDAO = null;
        loadRow();
        showRow();
        showTable();
    }
    
    private void btnGuardarClick() {
        boolean gjHormigaNull = (gjHormigaDAO == null);
        // String buttonText = ((JButton) e.getSource()).getText();
        try {
            if (GJIAStyle.showConfirmYesNo("¿Seguro que desea " + ((gjHormigaNull) ? "AGREGAR ?" : "ACTUALIZAR ?"))){
                GJIAStyle.showMsg("Guardado Correctamente");
                loadRow();
                showRow();
                showTable();
            }
        } catch (Exception e) {
            GJIAStyle.showMsgError(e.getMessage());
        }
    }

    private void btnEliminarClick() {
        try {
            if (GJIAStyle.showConfirmYesNo("Seguro que desea Eliminar?")) {

                if (!gjHormigaBL.gjDelete(gjHormigaDAO.getGjIDHormiga()))
                    throw new Exception("Error al eliminar...!");
    
                loadRow();
                showRow();
                showTable();
            }
        } catch (Exception e) {
            GJIAStyle.showMsgError(e.getMessage());
        }
    }

    

    private void btnCancelarClick() {
        try {
            if(gjHormigaDAO == null)
                loadRow();
            showRow();
        } catch (Exception e) {}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRowIni)
            rowNum = 1;
        if (e.getSource() == btnRowAnt && (rowNum > 1))
            rowNum--;
        if (e.getSource() == btnRowSig && (rowNum < idRowMaxSexo))
            rowNum++;
        if (e.getSource() == btnRowFin)
            rowNum = idRowMaxSexo;
        try {
            gjHormigaDAO   = gjHormigaBL.gjGetBy(rowNum);  
            showRow(); 
        } catch (Exception ex) {}
    }

    private void showTable() throws Exception {
        String[] header = {"RN","ID","Tipo", "Geno Alimento", "Ingesta Nativa","Sexo","Localidad","Estado"};
        Object[][] data = new Object[gjHormigaBL.getAll().size()][8];
        int index = 0;
        for (GJHormiga_DTO s : gjHormigaBL.getAll()) {
            data[index][0] = s.getGjRowNum();
            data[index][1] = s.getGjIDHormiga();
            data[index][2] = s.getGjTipoHormiga();
            data[index][3] = s.getGjNombreGenoAlimento();
            data[index][4] = s.getGjNombreIngestaNativa();
            data[index][5] = s.getGjNombreSexo();
            data[index][6] = s.getGjNombreProvincia();
            data[index][7] = s.getGjEstadoCondición();
            index++;
        }

        JTable table = new JTable(data, header);
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.lightGray);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);

        table.setPreferredScrollableViewportSize(new Dimension(450, 150));
        table.setFillsViewportHeight(true);

        pnlTabla.removeAll();
        pnlTabla.add(new JScrollPane(table));

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int col = table.columnAtPoint(e.getPoint());
                if (row >= 0 && col >= 0) {
                    String strrowNum = table.getModel().getValueAt(row, 0).toString();
                    rowNum = Integer.parseInt(strrowNum);
                    try {
                        gjHormigaDAO = gjHormigaBL.gjGetBy(rowNum);
                        showRow();
                    } catch (Exception ignored) {
                    }
                    System.out.println("Tabla.Selected: " + strrowNum);
                }
            }
        });
    }



    public void customizeComponent() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        //txtrowNum.setEnabled(false);
        txtrowNum.setBorderLine();
        txtNombre.setBorderLine();

        //pnlBtnPage.add(btnPageIni);
        //pnlBtnPage.add(btnPageAnt);
        //pnlBtnPage.add(new PatLabel(" Page:( "));
        //pnlBtnPage.add(lblTotalReg); //cambiar
        //pnlBtnPage.add(new PatLabel(" ) "));
        //pnlBtnPage.add(btnPageSig);
        //pnlBtnPage.add(btnPageFin);

        pnlBtnRow.add(btnRowIni);
        pnlBtnRow.add(btnRowAnt);
        pnlBtnRow.add(lblTotalReg);
        pnlBtnRow.add(btnRowSig);
        pnlBtnRow.add(btnRowFin);

        pnlBtnCrear.add(btnCrear);
        pnlBtnGenoA.add(btnAlimeGeno);
        pnlBtnInges.add(btnAlimeInge);


        pnlBtnCRUD.add(btnEliminar);
        pnlBtnCRUD.add(btnGuardar);
        //pnlBtnCRUD.add(btnNuevo);
        //pnlBtnCRUD.add(btnCancelar);
        pnlBtnCRUD.setBorder(GJIAStyle.createBorderRect());

        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(lblTitulo, gbc);
//-------------------------------------------------------------------------

        //gbc.gridy = 6;
        //gbc.gridx = 0;
        //gbc.gridwidth = 1;
        //add(new JLabel("■ Sección de datos: "), gbc);
        //gbc.gridy = 6;
        //gbc.gridx = 1;
        //add(pnlBtnPage, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.ipady = 150;
        gbc.ipadx = 450;
        pnlTabla.add(new Label("Loading data..."));
        add(pnlTabla, gbc);
//-------------------------------------------------------------------------
        gbc.ipady = 1;
        gbc.ipadx = 1;

        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(50, 0, 0, 0);  // Ajusta el valor superior a 50
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(Box.createRigidArea(new Dimension(0, 0)), gbc);

        gbc.insets = new Insets(10, 0, 0, 0);
//-------------------------------------------------------------------------

        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(new JLabel("■ Sección de registro: "), gbc);
        gbc.gridy = 5;
        gbc.gridx = 1;
        add(pnlBtnRow, gbc);
        //---------------------------------------
        
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(new JLabel("Hormiguero Virtual: "), gbc);
        gbc.gridy = 3;
        gbc.gridx = 1;
        add(pnlBtnCrear, gbc);
//******************************************************************* */
        gbc.gridy = 2;
        gbc.gridx = 0;
        add(lblrowNum, gbc);
        gbc.gridy = 2;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtrowNum, gbc);
//------------------------------------------------------------------
        gbc.gridy = 1;
        gbc.gridx = 0;
        add(lblNombre, gbc);
        gbc.gridy = 1;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtNombre, gbc);

        
        gbc.gridy = 6;
        gbc.gridx = 0;
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        //gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(lblGenoAlimento, gbc);
        gbc.gridy = 7;
        gbc.gridx = 0;
        //gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(gjComboBoxGenoAlimento, gbc);
        gbc.gridy = 8;
        gbc.gridx = 0;
        //gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(pnlBtnGenoA, gbc);

        gbc.gridy = 9;
        gbc.gridx = 0;
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        //gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(lblIngestaNativa, gbc);
        gbc.gridy =10;
        gbc.gridx = 0;
        //gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(gjComboBoxIngestaNativa, gbc);
        gbc.gridy = 11;
        gbc.gridx = 0;
        //gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(pnlBtnInges, gbc);

        gbc.gridy = 12;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pnlBtnCRUD, gbc);
    }

}