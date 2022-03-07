package org.example.dao;

import org.example.CustomException.AccessFailedException;
import org.example.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Admin  able to add,update,delete the chat.
 */
public class AdminCrud {

    /**
     * Adds the chat
     *
     * @param question
     * @param answer
     * @return
     */
    public boolean addChat(final String question, final String answer) {
        final String chatbotInsertQuery = "Insert into chatbot(question,answer) values(?,?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(chatbotInsertQuery);) {
            preparedStatement.setString(1, question);
            preparedStatement.setString(2, answer);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new AccessFailedException("Insertion failed");
        }
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
            throw new AccessFailedException("update failed");
        }
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
            throw new AccessFailedException("deletion failed");
        }
    }
}


