package com.chatbot.service;

public interface Service {
	void adminSignUp(String emailId, String userName, String password);

	void adminSignIn(String userName, String password);

	void userSignUp(String mobilenum, String username, String password);

	void userSignIn(String userName, String password);
}
