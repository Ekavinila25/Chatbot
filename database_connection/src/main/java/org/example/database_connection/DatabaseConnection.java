package org.example.database_connection;

//import org.example.database_connection.exception.ConnectionException;
//import sun.jvm.hotspot.debugger.DataSource;
//import com.mysql.cj.jdbc.MysqlDataSource;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.ResourceBundle;
//
///**
// * Gets connection.
// *
// * @author KavinilaE
// */
//public class DatabaseConnection {
//
//    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/kavinila";
//    private static final String DATABASE_NAME = "root";
//    private static final String DATABASE_PASSWORD = "Kavi@967761";
//    private static Connection connection;
//
//    public static final Connection getConnection() {
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection(JDBC_URL, DATABASE_NAME, DATABASE_PASSWORD);
//        } catch (Exception exception) {
//            throw new ConnectionException("Connection Failed");
//        }
//        return connection;
//    }
//
//}

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
//            InputStream fileInputStream = new FileInputStream("C:/karaf/etc/system.properties");
//            Properties properties = new Properties();
//            properties.load(fileInputStream);
//            String url = properties.getProperty("MySQL.path");
//            String username = properties.getProperty("MySQL.user");
//            String password = properties.getProperty("MySQL.pass");
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            final Connection connection = DriverManager.getConnection(url, username, password);
//            return connection;
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