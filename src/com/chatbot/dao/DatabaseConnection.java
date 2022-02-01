package com.chatbot.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	
	protected static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kavinila", "root", "Kavi@967761");
		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}
}
