package com.chatbot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
	public static void insertNewAdmin(final String emailId, final String userName, final String password) {

		try (Connection connection = DatabaseConnection.getConnection();
				Statement statement = connection.createStatement()) {
			statement.executeUpdate("Insert into admin values('" + emailId + "','" + userName + "','" + password + "')");
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

		try (Connection connection = DatabaseConnection.getConnection();
				Statement statement = connection.createStatement()) {
			statement.executeUpdate("Insert into chatbot(question,answer) values('" + question + "','" + answer + "')");
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

		String chatbotUpdateQuery = "update chatbot set question = ?,answer = ? where id = ?";

		try (Connection connection = DatabaseConnection.getConnection();
				Statement statement = connection.createStatement();
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
		String chatbotDeleteQuery = ("DELETE FROM chatbot where id = ?");

		try (Connection connection = DatabaseConnection.getConnection();
				Statement statement = connection.createStatement();
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
