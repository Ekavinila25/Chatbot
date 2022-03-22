package org.example.database_connection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.example.database_connection.exception.ConnectionException;

/**
 * Get the database connection.
 */
public class DatabaseConnection {

    public static Connection getConnection() {

        try {
            InputStream fileInputStream = new FileInputStream("C:/karaf/etc/system.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);
            String url = properties.getProperty("MySQL.path");
            String username = properties.getProperty("MySQL.user");
            String password = properties.getProperty("MySQL.pass");
            Class.forName("com.mysql.cj.jdbc.Driver");
            final Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (Exception exception) {
            throw new ConnectionException("FAILED TO CONNECTION");
        }
    }
}
