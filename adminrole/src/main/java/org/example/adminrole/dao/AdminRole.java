package org.example.adminrole.dao;

import org.example.adminrole.model.Conversation;
import org.example.database_connection.DatabaseConnection;
import org.example.database_connection.exception.ConnectionException;
import org.example.exception.CustomException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.database_connection.DatabaseConnection.getConnection;

/**
 * Admin  able to add,update,delete the chat.
 */
public class AdminRole {

    /**
     * Adds the chat.
     *
     * @param question
     * @param answer
     */
    public static boolean addChat(final String question, final String answer) {
        final String chatbotInsertQuery = "Insert into chatbot(question,answer) values(?,?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(chatbotInsertQuery);) {
            preparedStatement.setString(1, question);
            preparedStatement.setString(2, answer);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new ConnectionException("connection failed");
        }
    }

    /**
     * Updates the chat.
     *
     * @param id
     * @param question
     * @param answer
     */
    public static boolean updateChat(final int id, final String question, final String answer) {
        final String chatbotUpdateQuery = "update chatbot set question = ?,answer = ? where id = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(chatbotUpdateQuery);) {

            preparedStatement.setString(1, question);
            preparedStatement.setString(2, answer);
            preparedStatement.setInt(3, id);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new ConnectionException("connection failed");
        }
    }

    /**
     * Deletes the chat.
     *
     * @param id
     */
    public static boolean deleteChat(final int id) {
        final String chatbotDeleteQuery = ("DELETE FROM chatbot where id = ?");

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(chatbotDeleteQuery);) {

            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new ConnectionException("connection failed");
        }
    }

    /**
     * view the chat.
     */
    public List<Conversation> viewChat() {
        final List<Conversation> userChatList = new ArrayList<Conversation>();
        final String userResultQuery = "Select id,question,answer from chatbot";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet existingUserResult = statement.executeQuery(userResultQuery)) {

            while (existingUserResult.next()) {
               final Conversation conversation=new Conversation();

                conversation.setId(existingUserResult.getInt(1));
                conversation.setQuestion(existingUserResult.getString(2));
                conversation.setAnswer(existingUserResult.getString(3));

                userChatList.add(conversation);

            }
        } catch (SQLException e) {
            throw new CustomException.AccessFailedException("Accessfailed");
        }
        return userChatList;
    }
}
