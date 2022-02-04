package com.chatbot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Insert the emailId, userName and password into table.
 * 
 * @author KavinilaE
 *
 */
public class AdminDao {

	/**
	 * Insert into emailId,userName,password admin table.
	 * 
	 * @param emailId
	 * @param userName
	 * @param password
	 * @return
	 */
	public static boolean adminSignUp(final String emailId, final String userName, final String password) {

		try (Connection connection = DatabaseConnection.getConnection();
				Statement statement = connection.createStatement()) {
			statement.executeUpdate("Insert into admin values('" + emailId + "','" + userName + "','" + password + "')");
			return true;
		} catch (SQLException e) {
			System.out.println("Sql Error");
		}
		return false;
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
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		
		try (Connection connection = DatabaseConnection.getConnection();
				Statement statement = connection.createStatement()) {
			resultSet = statement.executeQuery("Select * from chatbot");

			while (resultSet.next()) {
				System.out.println("\n" + "Id :" + resultSet.getString(1) + "\t" + "Question" + ": "
						+ resultSet.getString(2) + "\t" + "answer:" + resultSet.getString(3));
			}
			preparedStatement = connection.prepareStatement("update chatbot set question =?,answer=? where id=? ");
			preparedStatement.setString(1, question);
			preparedStatement.setString(2, answer);
			preparedStatement.setInt(3, id);

			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Sql Error");
		} finally {
			
			try {
				resultSet.close();
				preparedStatement.close();
			} catch (Exception e) {
				System.out.println("Error");
			}
		}
		return false;
	}

	/**
	 * Delete the chat.
	 * 
	 * @param id
	 */
	public boolean deleteChat(final int id) {
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try (Connection connection = DatabaseConnection.getConnection();
				Statement statement = connection.createStatement();) {
			resultSet = statement.executeQuery("Select * from chatbot");

			while (resultSet.next()) {
				System.out.println("\n" + "Id :" + resultSet.getString(1) + "\t" + "Question" + ": "
						+ resultSet.getString(2) + "\t" + "answer:" + resultSet.getString(3));
			}
			preparedStatement = connection.prepareStatement("DELETE FROM chatbot where id=? ");
			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Sql Error");
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
			} catch (Exception e) {
				System.out.println("Error");
			}
		}
		return false;
	}
}
