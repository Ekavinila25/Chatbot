package com.chatbot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * insert the mobileNumber, userName, password into user table
 * 
 * @author KavinilaE
 *
 */
public class UserDao {
	public static void userSignUp(final String mobileNumber,final String userName,final String password) {

		try (Connection connection = DatabaseConnection.getConnection(); Statement statement = connection.createStatement()) {
			statement.executeUpdate("Insert into user values('" + mobileNumber + "','" + userName + "','" + password + "')");
		} catch (Exception e) {
			System.out.println("Sql Error");
		}
	}
	
	/**
	 * Get the result from chatTable.
	 * 
	 * @author KavinilaE
	 *
	 */
	public void doChat(final String question) {
			
			try (Connection connection = DatabaseConnection.getConnection();final Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("select * from chatbot")) {
	         while (resultSet.next()) {
					String Result = resultSet.getString(2);

					if (question.equalsIgnoreCase(Result)) {
						System.out.println(resultSet.getString(3));
						break;
					}
				}
			} catch (Exception e) {
				System.out.println("sql error");
			}
		}
	}

