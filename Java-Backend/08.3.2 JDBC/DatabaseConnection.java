package com.wecp.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
    public static Connection createConnection(String dbUrl, String user, String password) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}