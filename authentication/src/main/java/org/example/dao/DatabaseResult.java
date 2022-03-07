package org.example.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.example.CustomException;
import org.example.DatabaseConnection;

/**
 * Stores the database result.
 *
 * @author KavinilaE
 */
public class DatabaseResult {

    /**
     * Stores the admin result and return to service implementation.
     */
    public List<String> adminResult() {
        final List<String> adminResultList = new ArrayList<String>();
        final String adminResultQuery = "Select emailid,username,password from admin";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet existingAdminResult = statement.executeQuery(adminResultQuery)) {

            while (existingAdminResult.next()) {
                final String email = existingAdminResult.getString(1);
                final String userName = existingAdminResult.getString(2);
                final String password = existingAdminResult.getString(3);

                adminResultList.add(email);
                adminResultList.add(userName);
                adminResultList.add(password);
            }
        } catch (SQLException e) {
            throw new CustomException.AccessFailedException("deletion failed");
        }
        return adminResultList;
    }

    /**
     * Stores the user result and return to service implementation.
     */
    public List<String> userResult() {
        final List<String> userResultList = new ArrayList<String>();
        final String userResultQuery = "Select mobilenumber,username,password from user";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet existingUserResult = statement.executeQuery(userResultQuery)) {

            while (existingUserResult.next()) {
                final String mobileNumber = existingUserResult.getString(1);
                final String userName = existingUserResult.getString(2);
                final String password = existingUserResult.getString(3);

                userResultList.add(mobileNumber);
                userResultList.add(userName);
                userResultList.add(password);
            }
        } catch (SQLException e) {
            System.out.println("Sql Error");
        }
        return userResultList;
    }
}