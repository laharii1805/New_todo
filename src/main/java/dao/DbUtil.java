package dao;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
    private static Connection conn;
    
//class method
    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo_db", "root", "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}