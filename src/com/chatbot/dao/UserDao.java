package com.chatbot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao extends DatabaseConnection {

	public void userSignUp(String mobileNumber, String userName, String password)throws ClassNotFoundException, SQLException {
		
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			statement.executeUpdate("Insert into user values('" + mobileNumber + "','" + userName + "','" + password + "')");
			System.out.println("Welcome to user portal");
		}
	}

	public void userSignIn(String userName, String password) throws ClassNotFoundException, SQLException {
		
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			String existingUserName = "";
			String existingPassword = "";
			ResultSet existingUserResult = statement.executeQuery("Select * from user where username='" + userName + "' and password='" + password + "'");

			while (existingUserResult.next()) {
				existingUserName = existingUserResult.getString(2);
				existingPassword = existingUserResult.getString(3);
			}
			
			if (existingUserName.equals(userName)) {

				if (existingPassword.equals(password)) {
					System.out.println("Login Successful");
				} else {
					System.out.println("Invalid Password");
				}
			} else {
				System.out.println("Invalid Username");
			}
		}
	}
}
