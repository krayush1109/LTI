package com.wecp.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

   public static Connection createConnection(String dbUrl, String user, String password) {
//    public static Connection createConnection() {
    try {
        return DriverManager.getConnection(dbUrl, user, password);        
    } catch (SQLException e) {
        // TODO: handle exception
        e.printStackTrace();
    }
    return null;
   }
}
