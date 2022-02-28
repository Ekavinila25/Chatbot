package com.launchclub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Modifies the chat table.
 *
 * @author KavinilaE
 */
public class AdminDao {

    /**
     * Inserts the details of new user.
     *
     * @param emailId
     * @param userName
     * @param password
     */
    public static void insertNewAdmin(final String emailId, final String userName, final String password) {
        final String adminInsertQuery = "Insert into admin(emailid,username,password) values(?,?,?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(adminInsertQuery);) {
            preparedStatement.setString(1, emailId);
            preparedStatement.setString(2, userName);
            preparedStatement.setString(3, password);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Sql Error");
        }
    }

    /**
     * Adds the question and answer into table.
     *
     * @param question
     * @param answer
     */
    public boolean addChat(final String question, final String answer) {
        final String chatbotInsertQuery = "Insert into chatbot(question,answer) values(?,?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(chatbotInsertQuery);) {
            preparedStatement.setString(1, question);
            preparedStatement.setString(2, answer);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Sql Error");
        }
        return false;
    }

    /**
     * Updates the chat.
     *
     * @param id
     * @param question
     * @param answer
     */
    public boolean updateChat(final int id, final String question, final String answer) {
        final String chatbotUpdateQuery = "update chatbot set question = ?,answer = ? where id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(chatbotUpdateQuery);) {

            preparedStatement.setString(1, question);
            preparedStatement.setString(2, answer);
            preparedStatement.setInt(3, id);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Sql Error");
        }
        return false;
    }

    /**
     * Deletes the chat.
     *
     * @param id
     */
    public boolean deleteChat(final int id) {
        final String chatbotDeleteQuery = ("DELETE FROM chatbot where id = ?");

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(chatbotDeleteQuery);) {
             preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Sql Error");
        }
        return false;
    }
}
