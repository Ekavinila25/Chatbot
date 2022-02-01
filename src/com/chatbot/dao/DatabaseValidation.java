package com.chatbot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseValidation extends DatabaseConnection {
	public static boolean isEmailValidate(String emailId) throws SQLException {

		try (Connection connection = getConnection(); final Statement statement = connection.createStatement()) {
			final ResultSet existingAdminEmailId = statement.executeQuery("Select emailid from admin");

			while (existingAdminEmailId.next()) {
				String existingEmailId = existingAdminEmailId.getString(1);

				if (existingEmailId.equals(emailId)) {
					System.out.println("Error!!!Plz Give Another Email");
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isUserNameValidate(String userName) throws SQLException {
		
		try (Connection connection = getConnection(); final Statement statement = connection.createStatement()) {
			final ResultSet existingAdminUserName = statement.executeQuery("Select username from admin");

			while (existingAdminUserName.next()) {
				String existingPassword = existingAdminUserName.getString(1);

				if (existingPassword.contains(userName)) {
					System.out.println("Error!!!Plz Give Another Username");
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isPasswordValidate(String password) throws SQLException {
		
		try (Connection connection = getConnection(); final Statement statement = connection.createStatement()) {
			final ResultSet existingAdminPassword = statement.executeQuery("Select password from admin");

			while (existingAdminPassword.next()) {
				String existingPassword = existingAdminPassword.getString(1);

				if (existingPassword.contains(password)) {

					System.out.println("Error!!!plz give another password");
					return true;
				}
			}
		}
		return false;
	}
}
