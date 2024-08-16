package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class GJSQLiteDataHelper {
    private static String gjDBPathConnection = "jdbc:sqlite:DataBase//GJEcuaFauna.sqlite"; 
    private static Connection gjConn = null;
    // protected SQLiteDataHelper(){}
    
    protected static synchronized Connection gjOpenConnection() throws Exception{
        try {
            if(gjConn == null)
                gjConn = DriverManager.getConnection(gjDBPathConnection);
        } catch (SQLException e) {
             throw e;   //new Exception(e,"SQLiteDataHelper","Fallo la coneccion a la base de datos");
        } 
        return gjConn;
    }

    protected static void GJcloseConnection() throws Exception{
        try {
            if (gjConn != null)
                gjConn.close();
        } catch (Exception e) {
            throw e;    //new Exception(e,"SQLiteDataHelper", "Fallo la conección con la base de datos");
        }
    }
}

