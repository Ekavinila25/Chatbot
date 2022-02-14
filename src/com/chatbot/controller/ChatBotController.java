package com.chatbot.controller;

import com.chatbot.service.ChatBotServiceImplementation;
import com.chatbot.service.Service;
import com.chatbot.view.Admin;
import com.chatbot.view.User;

public class ChatBotController {
    
	private static final Admin ADMIN = new Admin();
	private static final User USER = new User();
	private static final Service SERVICE_IMPLEMENTATION = new ChatBotServiceImplementation();

	public void adminSignUp(final String emailId,final String userName,final String password) {
		ADMIN.adminAddReturn(SERVICE_IMPLEMENTATION.adminSignUp(emailId, userName, password));
	}
	
    public void adminSignIn(final String userName, final String password) {
		ADMIN.adminAddReturn(SERVICE_IMPLEMENTATION.adminSignIn(userName, password));
	}

	public void addition(final String question, final String answer) {
		SERVICE_IMPLEMENTATION.addChat(question, answer);
	}

	public void update(final int id, final String question, final String answer) {
		SERVICE_IMPLEMENTATION.updateChat(id, question, answer);
	}

	public void delete(final int id) {
		SERVICE_IMPLEMENTATION.deleteChat(id);
	}

	public void userSignUp(final String mobileNumber, final String userName, final String password) {
		USER.validUser(SERVICE_IMPLEMENTATION.userSignUp(mobileNumber, userName, password));
	}

	public void userSignIn(final String userName, final String password) {
		USER.validUser(SERVICE_IMPLEMENTATION.userSignIn(userName, password));
	}

	public void userChat(final String userQuestion) {
		SERVICE_IMPLEMENTATION.userQuestion(userQuestion);
	}
}