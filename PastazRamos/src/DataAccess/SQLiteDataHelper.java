/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| pdavila0113@gmail.com      BaphomeT-T  |
|----------------------------------------|
Autor : BaphomeT-T
Fecha : 25.feb.2k24
*/
package DataAccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class SQLiteDataHelper {
    private static String DBPathConnection = "jdbc:sqlite:database//ANTBOT.sqlite";
    private static Connection conn = null;
    protected SQLiteDataHelper(){

    }
    protected static synchronized Connection openConnection() throws Exception{
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(DBPathConnection);
                }
        } catch (SQLException e) {
            throw e;
        }
        return conn;
    }
    protected static void closeConnection() throws Exception{
        try {
            if (conn != null)
            conn.close(); 
        } catch (Exception e) {
            throw e;
        }
    }
}
