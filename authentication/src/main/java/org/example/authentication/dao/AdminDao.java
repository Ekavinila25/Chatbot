package org.example.authentication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.example.database_connection.DatabaseConnection;
import org.example.database_connection.exception.ConnectionException;

/**
 * Modifies the chat table.
 *
 * @author KavinilaE
 */
public class AdminDao {

    public static void insertNewAdmin(final String emailId, final String userName, final String password) {
        final String adminInsertQuery = "Insert into admin(emailid,username,password) values(?,?,?)";
        System.out.println(emailId);
        System.out.println("Hello");
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(adminInsertQuery);) {
            preparedStatement.setString(1, emailId);
            preparedStatement.setString(2, userName);
            preparedStatement.setString(3, password);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new ConnectionException("connection failed");
        }
    }
}
