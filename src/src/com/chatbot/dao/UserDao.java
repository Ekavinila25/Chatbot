package com.chatbot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Insert the new user details to user table and doChat
 * 
 * @author KavinilaE
 */
public class UserDao {

    /**
     * 
     * @param mobileNumber
     * @param userName
     * @param password
     */
    public static void userSignUp(final String mobileNumber, final String userName, final String password) {

        try (Connection connection = DatabaseConnection.getConnection();
                Statement statement = connection.createStatement()) {
            statement.executeUpdate(
                    "Insert into user values('" + mobileNumber + "','" + userName + "','" + password + "')");
        } catch (Exception e) {
            System.out.println("Sql Error");
        }
    }

    /**
     * Get the result from chatTable.
     * 
     * @author KavinilaE
     * @return
     */
    public String doChat(final String userQuestion) {
        String chatResult = "select question,answer from chatbot";

        try (Connection connection = DatabaseConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(chatResult)) {
            String question = userQuestion;

            while (resultSet.next()) {
                String Result = resultSet.getString(1);

                if (question.equalsIgnoreCase(Result)) {
                    System.out.println(resultSet.getString(2));
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        return chatResult;
    }
}