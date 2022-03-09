package org.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.example.DatabaseConnection;
import org.example.exception.ConnectionException;

/**
 * Modifies the chat table.
 *
 * @author KavinilaE
 */
public class AdminDao {

    public static void insertNewAdmin(final String emailId, final String userName, final String password) {
        final String adminInsertQuery = "Insert into admin(emailid,username,password) values(?,?,?)";

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
