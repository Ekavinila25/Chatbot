package com.chatbot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Insert the new user details to user table and doChat
 * 
 * @author KavinilaE
 */
public class UserDao {

    /**
     * Insert new user details into database
     * 
     * @param mobileNumber
     * @param userName
     * @param password
     */
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

    /**
     * Get the result from chatTable.
     * 
     * @author KavinilaE
     */
    public void doChat(final String userQuestion) {
        final String chatResult = "select question, answer from chatbot";

        try (Connection connection = DatabaseConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(chatResult)) {
            final String question = userQuestion;

            while (resultSet.next()) {
                final String questionResult = resultSet.getString(1);

                if (question.equalsIgnoreCase(questionResult)) {
                    System.out.println(resultSet.getString(2));
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}