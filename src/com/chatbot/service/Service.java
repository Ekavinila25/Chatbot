package com.chatbot.service;

public interface Service {
	boolean adminSignUp(String emailId, String userName, String password);

	void adminSignIn(String userName, String password);

	void addChat(String question, String answer);

	void updateChat(int id, String question, String answer);

	void deleteChat(int id);

	boolean userSignUp(String mobilenum, String username, String password);

	void userSignIn(String userName, String password);

	void userQuestion(String question);

}
