package org.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.example.DatabaseConnection;

/**
 * Inserts the new user details to user table.
 *
 * @author KavinilaE
 */
public class UserDao {

    public static void userSignUp(final String mobileNumber, final String userName, final String password) {
        final String userInsertQuery = "Insert into user(mobilenumber, userName, password) values(?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(userInsertQuery)) {
            preparedStatement.setString(1, mobileNumber);
            preparedStatement.setString(2, userName);
            preparedStatement.setString(3, password);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Sql Error");
        }
    }
}