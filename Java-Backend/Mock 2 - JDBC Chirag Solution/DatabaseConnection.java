import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ecommerce_jdbc_wecp";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "hellowecp";
    
    // public static void main(String[] args){
    public static Connection getConnection() throws SQLException{

        Connection conn = null;

        // complete the implementation here
        try{
            conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);        
        } catch(SQLException e){
            e.printStackTrace();
        }
        return conn;        
    }
}
