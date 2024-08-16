package UserInterface.Form;

import javax.swing.*;

import BusinessLogic.GJHormigaBL;
import BusinessLogic.Entities.Alimento.GJCarnivoro;
import BusinessLogic.Entities.Alimento.GJXY;
import BusinessLogic.Entities.Hormiga.GJLarva;
import DataAccess.DTO.GJHormiga_DTO;
import UserInterface.GJIAStyle;
import UserInterface.CustomerControl.GJPatButton;
import UserInterface.CustomerControl.GJPatLabel;
import UserInterface.CustomerControl.GJPatTextBox;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * panel para trabajar con las hormigas
 */
public class GJHormigaPanel  extends JPanel implements ActionListener {
    private Integer rowNum = 0, idRowMaxSexo=0;
    private GJHormigaBL  gjHormigaBL  = new GJHormigaBL();
    private GJHormiga_DTO gjHormigaDAO = null;
    private GJLarva larva = new GJLarva();
    private GJCarnivoro carne = new GJCarnivoro();
    private GJXY xy = new GJXY();
    private String [] gjItemsGenoAlimento = {"X","XX","XY"};
    private String [] gjItemsIngestaNativa = {"Herbivoro","Carnivoro","Omnivoro","Insectivoro","Nectanivoro"};
    JComboBox<String> gjComboBoxGenoAlimento = new JComboBox<>(gjItemsGenoAlimento);
    JComboBox<String> gjComboBoxIngestaNativa = new JComboBox<>(gjItemsIngestaNativa);


    private GJPatLabel
        lblTitulo   = new GJPatLabel("SIMULADOR"),
        lblNombre   = new GJPatLabel("Nombres: "),
        lblrowNum   = new GJPatLabel("Cedula:      "),
        lblTotalReg = new GJPatLabel(" 0 de 0 "),
        lblGenoAlimento  = new GJPatLabel("Geno - Alimento"),
        lblIngestaNativa = new GJPatLabel("Ingesta Nativa");
    private GJPatTextBox
        txtrowNum   = new GJPatTextBox(),
        txtNombre   = new GJPatTextBox();
    private GJPatButton
        btnRowIni   = new GJPatButton(" |< "),
        btnRowAnt   = new GJPatButton(" << "),
        btnRowSig   = new GJPatButton(" >> "),
        btnRowFin   = new GJPatButton(" >| "),

        btnCrear    = new GJPatButton("Crear Hormiga Larva"),
        btnAlimeGeno= new GJPatButton("Alimentar con GenoAliemnto"),
        btnAlimeInge= new GJPatButton("Alimentar con Ingesta Nativa"),

        btnGuardar  = new GJPatButton("Guardar"),
        btnEliminar = new GJPatButton("Eliminar");

    private JPanel
        pnlTabla    = new JPanel(),
        pnlBtnRow   = new JPanel(new FlowLayout()),
        pnlBtnCrear = new JPanel(new FlowLayout()),
        pnlBtnGenoA = new JPanel(new FlowLayout()),
        pnlBtnInges = new JPanel(new FlowLayout()),
        pnlBtnCRUD  = new JPanel(new FlowLayout());


    /**
     * Constructor Vacio
     */
    public GJHormigaPanel() {
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

    /**
     * metodo paea upgradear la ingesta nativa
     */
    private void btnUpdateAlimeInge() {
        try {
            if (GJIAStyle.showConfirmYesNo("¿Seguro que desea ACTUALIZAR ?")){
                gjHormigaDAO.setGjNombreIngestaNativa(gjComboBoxIngestaNativa.getSelectedItem().toString());
                if(larva.gjComerIngestaNativa(gjHormigaDAO, carne)){
                    GJIAStyle.showMsg("Se actualizó la alimentación genética de la hormiga");
                }
                /*gjHormigaDAO.setGjIngestaNativa(gjObtenerDatoComboBox2(gjComboBoxIngestaNativa));
                if(gjHormigaBL.gjUpdateIngAliment(gjHormigaDAO)){
                    GJIAStyle.showMsg("Se actualizó la alimentación genética de la hormiga");
                }*/
                loadRow();
                showRow();
                showTable();
            }
        } catch (Exception e) {
            GJIAStyle.showMsgError(e.getMessage());
        }
    }

    /**
     * Metodo para obtener los integer que representan los datos de las combobox
     * @param gjComboBoxDos: gjComboBox
     * @return retorna un valor entero
     */
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

    /**
     * metodo paea upgradear el geno alimento
     */
    private void btnUpdateAlimeGeno() {
        try {
            if (GJIAStyle.showConfirmYesNo("¿Seguro que desea ACTUALIZAR ?")){
                gjHormigaDAO.setGjNombreGenoAlimento(gjComboBoxGenoAlimento.getSelectedItem().toString());
                if(larva.gjComerGenoAlimento(gjHormigaDAO, xy)){
                    GJIAStyle.showMsg("Se actualizó la alimentación genética de la hormiga");
                }
                /*
                gjHormigaDAO.setGjGenoAlimento(gjObtenerDatoComboBox1(gjComboBoxGenoAlimento));
                if(gjHormigaBL.gjUpdateGenAliment(gjHormigaDAO)){
                    GJIAStyle.showMsg("Se actualizó la alimentación genética de la hormiga");
                }*/
                loadRow();
                showRow();
                showTable();
            }
        } catch (Exception e) {
            GJIAStyle.showMsgError(e.getMessage());
        }
    }

    /**
     * Metodo para obtener los integer que representan los datos de las combobox
     * @param gjComboBoxUno: gjComboBox
     * @return retorna un valor entero
     */
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

    /**
     * metodo para cargar la tabla
     */
    private void loadRow()  {
        try {
            rowNum      = 1;
            gjHormigaDAO= gjHormigaBL.gjGetBy(rowNum);
            idRowMaxSexo= gjHormigaBL.gjGetRowCount();
        } catch (Exception e) {
            GJIAStyle.showMsg(e.getMessage());
        }
    }

    /**
     * metodo para mostrar la tabla
     */
    private void showRow() {
        boolean gjHormigaNull = (gjHormigaDAO == null);
        txtrowNum.setText("1726395781");
        txtNombre.setText("Jonathan Steven Guaman Maza");
        lblTotalReg.setText(rowNum.toString() + " de " + idRowMaxSexo.toString());
    }

    /**
     * metodo para las acciones con un nuevo click
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    private void btnNuevoClick() throws Exception{
        gjHormigaBL.gjAdd();
        gjHormigaDAO = null;
        loadRow();
        showRow();
        showTable();
    }
    
    /**
     * metodo para guardar datos seleccionados
     */
    private void btnGuardarClick() {
        boolean gjHormigaNull = (gjHormigaDAO == null);
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

    /**
     * metodo para eliminar objetos
     */
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

    /**
     * metodo para mostrar las tabla
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    private void showTable() throws Exception {
        String[] header = {"RegNro","ID","Tipo", "Geno Alimento", "Ingesta Nativa","Sexo","Ubicación","Estado","ChipIa"};
        Object[][] data = new Object[gjHormigaBL.getAll().size()][9];
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
            //****** */
            data[index][8] = imprimirMsg(s.getGjEstadoCondición());
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

    private Object imprimirMsg(String gjEstadoCondición) {
        if(gjEstadoCondición.equals("Viva")){
            return "Aprendiendo espanol";
        }
        return "Ya no";
    }

    /**
     * metodo customizador de posiciones de los componentes
     */
    public void customizeComponent() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        txtrowNum.setEnabled(false);
        txtNombre.setEnabled(false);
        txtrowNum.setBorderLine();
        txtNombre.setBorderLine();

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

        pnlBtnCRUD.setBorder(GJIAStyle.createBorderRect());

        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(lblTitulo, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.ipady = 150;
        gbc.ipadx = 450;
        pnlTabla.add(new Label("Loading data..."));
        add(pnlTabla, gbc);

        gbc.ipady = 1;
        gbc.ipadx = 1;

        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(50, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(Box.createRigidArea(new Dimension(0, 0)), gbc);

        gbc.insets = new Insets(10, 0, 0, 0);


        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(new JLabel("■ Sección de registro: "), gbc);
        gbc.gridy = 5;
        gbc.gridx = 1;
        add(pnlBtnRow, gbc);

        
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(new JLabel("Hormiguero Virtual: "), gbc);
        gbc.gridy = 3;
        gbc.gridx = 1;
        add(pnlBtnCrear, gbc);


        gbc.gridy = 2;
        gbc.gridx = 0;
        add(lblrowNum, gbc);
        gbc.gridy = 2;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(txtrowNum, gbc);


        gbc.gridy = 1;
        gbc.gridx = 0;
        add(lblNombre, gbc);
        gbc.gridy = 1;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(txtNombre, gbc);

        
        gbc.gridy = 6;
        gbc.gridx = 0;
        add(lblGenoAlimento, gbc);
        gbc.gridy = 7;
        gbc.gridx = 0;
        add(gjComboBoxGenoAlimento, gbc);
        gbc.gridy = 8;
        gbc.gridx = 0;
        add(pnlBtnGenoA, gbc);

        gbc.gridy = 9;
        gbc.gridx = 0;
        add(lblIngestaNativa, gbc);
        gbc.gridy =10;
        gbc.gridx = 0;
        add(gjComboBoxIngestaNativa, gbc);
        gbc.gridy = 11;
        gbc.gridx = 0;
        add(pnlBtnInges, gbc);

        gbc.gridy = 12;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pnlBtnCRUD, gbc);
    }
}