package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para crear la conexion
 */
public abstract class GJSQLiteDataHelper {
    private static String gjDBPathConnection = "jdbc:sqlite:DataBase//GJEcuaFauna.sqlite"; 
    private static Connection gjConn = null;
    
    /**
     * metodo para abrir una conexion con la base de datos
     * @return retorna la conexion
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public static synchronized Connection gjOpenConnection() throws Exception{
        try {
            if(gjConn == null)
                gjConn = DriverManager.getConnection(gjDBPathConnection);
        } catch (SQLException e) {
             throw e;
        }
        return gjConn;
    }

    /**
     * metodo para cerrar la conexion
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    protected static void GJcloseConnection() throws Exception{
        try {
            if (gjConn != null)
                gjConn.close();
        } catch (Exception e) {
            throw e;
        }
    }
}

