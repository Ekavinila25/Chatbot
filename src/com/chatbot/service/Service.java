package com.chatbot.service;

import java.sql.SQLException;

public interface Service {
	void adminSignUp(String emailId, String userName, String password) throws ClassNotFoundException, SQLException;

	void adminSignIn(String userName, String password) throws ClassNotFoundException, SQLException;

	void userSignUp(String mobilenum, String username, String password) throws ClassNotFoundException, SQLException;

	void userSignIn(String userName, String password) throws ClassNotFoundException, SQLException;
}
