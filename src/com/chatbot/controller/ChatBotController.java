package com.chatbot.controller;

import com.chatbot.service.Service;
import com.chatbot.service.ServiceImplementation;

public class ChatBotController {

	private final Service SERVICE_IMPLEMENTATION = new ServiceImplementation();

	public void adminSignUp(String emailId, String userName, String password) {
		SERVICE_IMPLEMENTATION.adminSignUp(emailId, userName, password);
	}

	public void adminSignIn(String userName, String password)  {
		SERVICE_IMPLEMENTATION.adminSignIn(userName, password);
	}

	public void userSignUp(String mobileNumber, String userName, String password) {
		SERVICE_IMPLEMENTATION.userSignUp(mobileNumber, userName, password);
	}

	public void userSignIn(String userName, String password)  {
		SERVICE_IMPLEMENTATION.userSignIn(userName, password);
	}
}