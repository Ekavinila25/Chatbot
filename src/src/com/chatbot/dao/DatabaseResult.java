package com.chatbot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Store the database result.
 * 
 * @author KavinilaE
 */
public class DatabaseResult {

	/**
	 * store the admin result and return to service implementation.
	 */
	public List<String> adminResult() {
		final List<String> adminResultList = new ArrayList<String>();
		String adminResultQuery = "Select * from admin";
		
		try (Connection connection = DatabaseConnection.getConnection();
				Statement statement = connection.createStatement();
				ResultSet existingAdminResult = statement.executeQuery(adminResultQuery)) {

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
	 * Store the user result and return to service implementation.
	 */
	public List<String> userResult() {
		final List<String> userResultSet = new ArrayList<String>();
		String userResultQuery = "Select * from user";
		
		try (Connection connection = DatabaseConnection.getConnection();
				Statement statement = connection.createStatement();
				ResultSet existingUserResult = statement.executeQuery(userResultQuery)) {
			
			while (existingUserResult.next()) {
				String mobileNumber = existingUserResult.getString(1);
				String userName = existingUserResult.getString(2);
				String password = existingUserResult.getString(3);

				userResultSet.add(mobileNumber);
				userResultSet.add(userName);
				userResultSet.add(password);
			}
		} catch (Exception e) {
			System.out.println("Sql Error");
		}
		return userResultSet;
	}
}