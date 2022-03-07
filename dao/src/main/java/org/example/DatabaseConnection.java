package org.example;

import org.example.CustomException.ConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Gets connection.
 *
 * @author KavinilaE
 */
public class DatabaseConnection {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/kavinila";
    private static final String DATABASE_NAME = "root";
    private static final String DATABASE_PASSWORD = "Kavi@967761";
    private static Connection connection;

    public static final Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, DATABASE_NAME, DATABASE_PASSWORD);
        } catch (Exception exception) {
            throw new ConnectionException("Connection Failed");
        }
        return connection;
    }
}