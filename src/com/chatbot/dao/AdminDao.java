package com.chatbot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDao extends DatabaseConnection {

	public void adminSignUp(String emailId, String userName, String password)throws ClassNotFoundException, SQLException {
	   
		try (Connection connection = getConnection(); final Statement statement = connection.createStatement()) {
			statement.executeUpdate("Insert into admin values('" + emailId + "','" + userName + "','" + password + "')");
			System.out.println("Welcome to admin portal");
		}
	}

	public void adminSignIn(String userName, String password) throws ClassNotFoundException, SQLException {
		
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			String existingUserName = "";
			String existingPassword = "";
			ResultSet existingAdminResult = statement.executeQuery("Select * from admin where username='" + userName + "' and password='" + password + "'");

			while (existingAdminResult.next()) {
				existingUserName = existingAdminResult.getString(2);
				existingPassword = existingAdminResult.getString(3);
			}

			if (existingUserName.equals(userName)) {

				if (existingPassword.equals(password)) {
					System.out.println("Login Successful");
				} else {
					System.out.println("Invalid password");
				}
			} else {
				System.out.println("Invalid Username");
			}
		}
	}
}