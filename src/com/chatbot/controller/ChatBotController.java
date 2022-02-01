package com.chatbot.controller;

import java.sql.SQLException;

import com.chatbot.service.ServiceImplementation;

public class ChatBotController {

	final ServiceImplementation SERVICEIMPLEMENTATION = new ServiceImplementation();

	public void adminSignUp(String emailId, String userName, String password) throws ClassNotFoundException, SQLException {
		SERVICEIMPLEMENTATION.adminSignUp(emailId, userName, password);
	}

	public void adminSignIn(String userName, String password) throws ClassNotFoundException, SQLException {
		SERVICEIMPLEMENTATION.adminSignIn(userName, password);
	}

	public void userSignUp(String mobileNumber, String userName, String password)throws ClassNotFoundException, SQLException {
		SERVICEIMPLEMENTATION.userSignUp(mobileNumber, userName, password);
	}

	public void userSignIn(String userName, String password) throws ClassNotFoundException, SQLException {
		SERVICEIMPLEMENTATION.userSignIn(userName, password);
	}
}