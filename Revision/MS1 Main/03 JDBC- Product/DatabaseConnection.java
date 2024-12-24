import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/supplychain_jdbc_wecp";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "hellowecp";
    // complete the implementation here

    // static Connection getConnection() {
    static Connection getConnection() throws SQLException{
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return connection;
    }

}
