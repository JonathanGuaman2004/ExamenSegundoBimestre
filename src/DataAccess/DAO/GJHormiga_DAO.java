package DataAccess.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import DataAccess.GJIDAO;
import DataAccess.GJSQLiteDataHelper;
import DataAccess.DTO.GJHormiga_DTO;
import Framework.GJPatException;

public class GJHormiga_DAO extends GJSQLiteDataHelper implements GJIDAO<GJHormiga_DTO> {

    @Override
    public boolean gjCreate() throws Exception {
        String query = " INSERT INTO GJHormiga (TipoHormiga ,Sexo ,Provincia,GenoAlimento,IngestaNativa) VALUES (?,?,?,?,?)";
        try {
            Connection        conn  = gjOpenConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "Larva");
            pstmt.setInt(2, 4);
            pstmt.setInt(3, gjSeleccionarProvincia());
            pstmt.setInt(4, 3);
            pstmt.setInt(5, 3);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new GJPatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<GJHormiga_DTO> gjReadAll() throws Exception {
        List <GJHormiga_DTO> lst = new ArrayList<>();
        String query =" SELECT ROW_NUMBER () OVER ( ORDER BY IDHormiga ) RowNum   "
                     +" ,h.IDHormiga      "
                     +" ,h.TipoHormiga         "
                     +" ,a1.Nombre        "
                     +" ,a2.Nombre        "
                     +" ,s.Nombre "
                     +" ,l.Nombre "
                     +" ,h.EstadoCondición "
                     +" FROM GJHormiga h    "
                     +" JOIN GJAlimento a1 ON h.GenoAlimento  = a1.IDAlimento"
                     +" JOIN GJAlimento a2 ON h.IngestaNativa = a2.IDAlimento"
                     +" JOIN GJSexo s ON h.Sexo = s.IdSexo"
                     +" JOIN GJLocalidad l ON h.Provincia = l.IdLocalidad"
                     +" WHERE h.Estado ='A' ";
        try {
            Connection conn = gjOpenConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
            GJHormiga_DTO s = new GJHormiga_DTO(rs.getInt(1)
                ,rs.getInt(2)
                ,rs.getString(3)
                ,rs.getString(4)
                ,rs.getString(5)
                ,rs.getString(6)
                ,rs.getString(7)
                ,rs.getString(8));
            lst.add(s);
            }
        }
        catch (SQLException e) {
            throw new GJPatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst;
    }

    @Override
    public boolean gjDelete(int id) throws Exception {
        String query = " UPDATE GJHormiga SET Estado = 'X' WHERE IDHormiga = ?";
        try {
            Connection          conn = gjOpenConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new GJPatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public GJHormiga_DTO gjReadBy(Integer id) throws Exception {
        GJHormiga_DTO s = new GJHormiga_DTO();
        String query =
         " SELECT RowNum            "
        +"     ,sub.IDHormiga       "
        +"     ,sub.TipoHormiga     "
        +"     ,sub.NombreAlimento1 "
        +"     ,sub.NombreAlimento2 "
        +"     ,sub.Sexo            "
        +"     ,sub.provincia       "
        +"     ,sub.estadoCondicion "
        +" FROM (                   "
        +"     SELECT ROW_NUMBER() OVER (ORDER BY h.IDHormiga) AS RowNum "
        +"         ,h.IDHormiga     "
        +"         ,h.TipoHormiga        "
        +"         ,a1.Nombre AS NombreAlimento1"
        +"         ,a2.Nombre AS NombreAlimento2"
        +"         ,l.Nombre AS provincia"
        +"         ,s.Nombre AS Sexo"
        +"         ,h.EstadoCondición AS estadoCondicion"
        +"     FROM GJHormiga h        "
        +"     JOIN GJAlimento a1 ON h.GenoAlimento = a1.IDAlimento "
        +"     JOIN GJAlimento a2 ON h.IngestaNativa = a2.IDAlimento"
        +"     JOIN GJSexo s ON h.Sexo = s.IdSexo"
        +"     JOIN GJLocalidad l ON h.Provincia = l.IdLocalidad"
        +"     WHERE h.Estado = 'A'   "
        +" ) sub                    "
        +" WHERE RowNum = " + id.toString();
        try {
            Connection conn = gjOpenConnection();         // conectar a DB
            Statement  stmt = conn.createStatement();   // CRUD : select * ...
            ResultSet  rs   = stmt.executeQuery(query);    // ejecutar la
            System.out.println(query);
            while (rs.next()) {
                s = new GJHormiga_DTO(
                     rs.getInt(1)     // RowNum
                    ,rs.getInt(2)     // IdCatalogo
                    ,rs.getString(3)     // IdCatalogoTipo
                    ,rs.getString(4)  // Nombre
                    ,rs.getString(5)  // Descripcion
                    ,rs.getString(6)  // Descripcion
                    ,rs.getString(7)  // Descripcion
                    ,rs.getString(8));  // Estado
            }
        }
        catch (SQLException e) {
            throw new GJPatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return s;
    }

    @Override
    public Integer gjGetMaxRow() throws Exception {
        String query =" SELECT COUNT(*) TotalRegistros"
                     +" FROM    GJHormiga               "
                     +" WHERE   Estado ='A'           ";
        try {
            Connection conn = gjOpenConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                return rs.getInt(1);                    // TotalReg
            }
        } 
        catch (SQLException e) {
            throw new GJPatException(e.getMessage(), getClass().getName(), "getRowCount()");
        }
        return 0;
    }

    private int gjSeleccionarProvincia() {
        int min = 6;
        int max = 29;
        return (int)(Math.random() * (max - min + 1)) + min;
    }

    @Override
    public boolean gjUpdateGenoAlimento(GJHormiga_DTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE GJHormiga "
                     + " SET GenoAlimento = ?,"
                     + " Sexo             = ?,"
                     + " FechaModifica    = ?"
                     + " WHERE IDHormiga  = ?";
        try {
            Connection          conn = gjOpenConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getGjGenoAlimento());
            pstmt.setInt(2, verificarSexo(entity.getGjGenoAlimento()));
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setInt(4, entity.getGjIDHormiga());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new GJPatException(e.getMessage(), getClass().getName(), "update()");
        }
    }
    
    @Override
    public boolean gjUpdateIngestaNativa(GJHormiga_DTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE GJHormiga "
                     + " SET IngestaNativa = ?,"
                     + " TipoHormiga       = ?,"
                     + " FechaModifica     = ?"
                     + " WHERE IDHormiga   = ?";
        try {
            Connection          conn = gjOpenConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getGjIngestaNativa());
            pstmt.setString(2, verificarTipo(entity.getGjIngestaNativa()));
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setInt(4, entity.getGjIDHormiga());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new GJPatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    private String verificarTipo(Integer gjIngestaNativa) {
        if(gjIngestaNativa==4){
            return "Hormiga de la tierra";
        }else if(gjIngestaNativa==5){
            return "Hormiga de la madera";
        }else if(gjIngestaNativa==6){
            return "Hormiga de la hoja";
        }else if(gjIngestaNativa==7){
            return "Hormiga de la fruta";
        }
        return "no";
    }

    private int verificarSexo(Integer gjGenoAlimento) {
        if(gjGenoAlimento==8){
            return 3;
        }else if(gjGenoAlimento==9){
            return 2;
        }else if(gjGenoAlimento==10){
            return 1;
        }
        return -1;
    }
}
