package com.chatbot.controller;

import com.chatbot.service.ChatBotServiceImplementation;
import com.chatbot.service.Service;
import com.chatbot.view.Admin;
import com.chatbot.view.User;

/**
 * Get the value and pass into corresponding implementation.
 * 
 * @author KavinilaE
 *
 */
public class ChatBotController {
	private static final Admin ADMIN = new Admin();
	private static final User USER = new User();
	private static final Service SERVICE_IMPLEMENTATION = new ChatBotServiceImplementation();

	/**
	 * Pass the emailId,userName,password into corresponding implementation for
	 * admin signUp.
	 * 
	 * @param emailId
	 * @param userName
	 * @param password
	 */
	public void adminSignUp(final String emailId, final String userName, final String password) {
		ADMIN.adminaddreturn(SERVICE_IMPLEMENTATION.adminSignUp(emailId, userName, password));
	}

	/**
	 * Pass the userName and password into corresponding implementation for admin
	 * signIn. adminSignin
	 * 
	 * @param userName
	 * @param password
	 */
	public void adminSignIn(final String userName, final String password) {
		SERVICE_IMPLEMENTATION.adminSignIn(userName, password);
	}

	/**
	 * Pass the question and answer into corresponding implementation for add chat.
	 * 
	 * @param userName
	 * @param password
	 */
	public void addition(final String question, final String answer) {
		SERVICE_IMPLEMENTATION.addChat(question, answer);
	}

	/**
	 * Pass the id,question,answer into corresponding implementation for update
	 * chat.
	 * 
	 * @param userName
	 * @param password
	 */
	public void update(final int id, final String question, final String answer) {
		SERVICE_IMPLEMENTATION.updateChat(id, question, answer);
	}

	/**
	 * Pass the id into corresponding implementation for delete chat.
	 * 
	 * @param userName
	 * @param password
	 */
	public void delete(final int id) {
		SERVICE_IMPLEMENTATION.deleteChat(id);
	}

	/**
	 * Pass the mobileNum,userName,password into corresponding implementation for
	 * user signUp.
	 * 
	 * @param userName
	 * @param password
	 */
	public void userSignUp(final String mobileNumber, final String userName, final String password) {
		USER.validUser(SERVICE_IMPLEMENTATION.userSignUp(mobileNumber, userName, password));
	}

	/**
	 * Pass the userName,password into corresponding implementation for userSigin.
	 * 
	 * @param userName
	 * @param password
	 */
	public void userSignIn(final String userName, final String password) {
		SERVICE_IMPLEMENTATION.userSignIn(userName, password);
	}

	/**
	 * Pass the question corresponding implementation for Chat.
	 * 
	 * @param userName
	 * @param password
	 */
	public void userChat(final String userQuestion) {
		SERVICE_IMPLEMENTATION.userQuestion(userQuestion);
	}
}