package com.chatbot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.chatbot.model.ChatBotUser;

/**
 * Modify the chat table
 * 
 * @author KavinilaE
 */
public class AdminDao {

    /**
     * Insert emailId,userName,password into Admin table.
     * 
     * @param emailId
     * @param userName
     * @param password
     */
    public static void insertNewAdmin(final ChatBotUser chatBotUser) {
       final String adminInsertQuery = "Insert into admin(emailid,username,password) values(?,?,?)";
       
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(adminInsertQuery)) {

            preparedStatement.setString(1, chatBotUser.getEmailId());
            preparedStatement.setString(2, chatBotUser.getUserName());
            preparedStatement.setString(3, chatBotUser.getPassword());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Sql Error");
        }
    }

    /**
     * Add the question and answer into table.
     * 
     * @param question
     * @param answer
     */
    public boolean addChat(final String question, final String answer) {
       final String chatbotInsertQuery = "Insert into chatbot(question,answer) values(?,?)";
        
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(chatbotInsertQuery)) {
            preparedStatement.setString(1, question);
            preparedStatement.setString(2, answer);
            
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Sql Error");
        }
        return false;
    }

    /**
     * Update the chat.
     * 
     * @param id
     * @param question
     * @param answer
     */
    public boolean updateChat(final int id, final String question, final String answer) {

        final String chatbotUpdateQuery = "update chatbot set question = ?,answer = ? where id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(chatbotUpdateQuery)) {

            preparedStatement.setString(1, question);
            preparedStatement.setString(2, answer);
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Sql Error");
        }
        return false;
    }

    /**
     * Delete the chat.
     * 
     * @param id
     */
    public boolean deleteChat(final int id) {
        final String chatbotDeleteQuery = ("DELETE FROM chatbot where id = ?");

        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(chatbotDeleteQuery);) {

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Sql Error");
        }
        return false;
    }
}
