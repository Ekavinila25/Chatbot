package com.chatbot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			statement.executeUpdate("Insert into user values('" + mobileNumber + "','" + userName + "','" + password + "')");
		} catch (Exception e) {
			System.out.println("Sql Error");
		}
	}

	/**
	 * Get the result from chatTable.
	 * 
	 * @author KavinilaE
	 * @throws SQLException
	 */
	public void doChat(final String userQuestion) throws SQLException {

		Connection connection = DatabaseConnection.getConnection();
		Statement statement = connection.createStatement();

		String name2 = userQuestion;
		ResultSet resultSet = statement.executeQuery("select* from chatbot");
		int f = 0;

		while (resultSet.next()) {
			String Result = resultSet.getString(2);
			if (name2.equalsIgnoreCase(Result)) {

				System.out.println(resultSet.getString(3));
				f++;
				break;
			}
		}
		if (f == 0) {
			System.out.println("sorry!!!.. I didn't UnderStand");
		}
	}
}
