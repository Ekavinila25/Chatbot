package com.chatbot.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Get the connection.
 * 
 * @return
 */
public class DatabaseConnection {

	public final static Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kavinila", "root", "Kavi@967761");
		} catch (Exception e) {
			System.out.println("Connection Error");
		}
		return connection;
	}
}
