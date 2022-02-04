package com.chatbot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *Store the database result.
 * 
 * @author KavinilaE
 *
 */
public class DatabaseResult extends DatabaseConnection {

	/**
	 * store the admin result and return to service implementation
	 * 
	 */
	public List<String> adminResult() {
		final List<String> adminResultList = new ArrayList<String>();

		try (Connection connection = DatabaseConnection.getConnection(); Statement statement = connection.createStatement()) {
            final ResultSet existingAdminResult = statement.executeQuery("Select * from admin");

			while (existingAdminResult.next()) {
				String emails = existingAdminResult.getString(1);
				String userName = existingAdminResult.getString(2);
				String password = existingAdminResult.getString(3);
				
				adminResultList.add(emails);
				adminResultList.add(userName);
				adminResultList.add(password);
			}
		} catch (Exception e) {
			System.out.println("Sql Error");
		}
		return adminResultList;
	}

	/**
	 * Store the user result and return to service implementation
	 * 
	 */
	public List<String> userResult() {
		final List<String> USER_RESULT_SET = new ArrayList<String>();

		try (Connection connection = DatabaseConnection.getConnection(); Statement statement = connection.createStatement()) {
            final ResultSet existingAdminEmailId = statement.executeQuery("Select * from user");

			while (existingAdminEmailId.next()) {
				String mobileNumber = existingAdminEmailId.getString(1);
				String userName = existingAdminEmailId.getString(2);
				String password = existingAdminEmailId.getString(3);
				
				USER_RESULT_SET.add(mobileNumber);
				USER_RESULT_SET.add(userName);
				USER_RESULT_SET.add(password);
			}
		} catch (Exception e) {
			System.out.println("Sql Error");
		}
		return USER_RESULT_SET;
	}
}