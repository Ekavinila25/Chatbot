package org.example.database_connection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;
import java.util.Properties;

import org.example.database_connection.exception.ConnectionException;

/**
 * Get the database connection.
 */
public class DatabaseConnection {

    private static Map<String, String> property;
    public static Connection getConnection() {

        try {
         return connection;
            Class.forName("com.mysql.cj.jdbc.Driver");
            final Connection connection = DriverManager.getConnection(property.get("MySQL.path"),
                    property.get("MySQL.user"), property.get("MySQL.pass"));
            return connection;
        } catch (Exception exception) {
            throw new ConnectionException("FAILED TO CONNECTION");
        }
    }
    public static void databaseConnection(Map<String, String> properties) {
        property = properties;
    }
}
