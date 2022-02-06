package com.chatbot.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Get connection
 * 
 * @author KavinilaE
 */
public class DatabaseConnection {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/kavinila";
	private static final String DATABASE_NAME = "root";
	private static final String DATABASE_PASSWORD = "Kavi@967761";
	private static Connection connection;

	public final static Connection getConnection() {

		try {
			connection = DriverManager.getConnection(JDBC_URL, DATABASE_NAME, DATABASE_PASSWORD);
		} catch (SQLException exception) {
			System.out.println("Exception");
		}
		return connection;
	}
}