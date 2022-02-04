package com.chatbot.service;

import com.chatbot.dao.AdminDao;
import com.chatbot.dao.UserDao;
import com.chatbot.view.Admin;

public class ChatBotServiceImplementation implements Service {
	private final static AdminDao ADMIN_DAO = new AdminDao();
	private final static UserDao USER_DAO = new UserDao();
	private final static Admin ADMIN = new Admin();

	/**
	 * Get the emailId,userName,password and pass adminSignUp for Validation
	 */
	public boolean adminSignUp(final String emailId, final String userName, final String password) {
		return DatabaseValidation.adminSignUp(emailId, userName, password);
	}

	/**
	 * Get the userName and password and pass into adminSignIn for Validation
	 */
	public void adminSignIn(final String userName, final String password) {
		DatabaseValidation.adminSignIn(userName, password);
	}

	/**
	 * Get mobileNumber,userName,password and pass into userSignUp
	 * databaseValidation
	 */
	public boolean userSignUp(final String mobileNumber, final String userName, final String password) {
		return DatabaseValidation.userSignUp(mobileNumber, userName, password);
	}

	/**
	 * Get userName and password and pass into userSignIn for databaseValidation
	 */
	public void userSignIn(final String userName, final String password) {
		DatabaseValidation.userSignIn(userName, password);
	}

	/**
	 * Get question and answer and pass into addChat
	 */
	public void addChat(final String question, final String answer) {
		boolean addChatReturnType = ADMIN_DAO.addChat(question, answer);

		if (addChatReturnType == true) {
			System.out.println("Added Successfully");
			ADMIN.adminChoice();
		}
	}

	/**
	 * Get id, question, answer and pass into updateChat
	 */
	public void updateChat(final int id, final String question, final String answer) {
		boolean updateChatReturnType = ADMIN_DAO.updateChat(id, question, answer);

		if (updateChatReturnType) {
			System.out.println("updated Successfully");
			ADMIN.adminChoice();
		}
	}

	/**
	 * Get the id for delete the chat
	 */
	public void deleteChat(final int id) {
		boolean deleteChatReturnType = ADMIN_DAO.deleteChat(id);

		if (deleteChatReturnType == true) {
			System.out.println("Deleted Successfully");
			ADMIN.adminChoice();
		}
	}

	/**
	 * Get the question for Chat
	 */
	public void userQuestion(final String question) {
		USER_DAO.doChat(question);
	}
}
