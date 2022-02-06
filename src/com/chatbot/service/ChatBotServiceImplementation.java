package com.chatbot.service;

import java.sql.SQLException;

import com.chatbot.dao.AdminDao;
import com.chatbot.dao.UserDao;
import com.chatbot.view.Admin;

/**
 * Get the input and pass for validation
 * 
 * @author KavinilaE
 *
 */
public class ChatBotServiceImplementation implements Service {
	private final static AdminDao ADMIN_DAO = new AdminDao();
	private final static UserDao USER_DAO = new UserDao();
	private final static Admin ADMIN = new Admin();

	public boolean adminSignUp(final String emailId, final String userName, final String password) {
		return DatabaseValidation.adminSignUp(emailId, userName, password);
	}

	public void adminSignIn(final String userName, final String password) {
		DatabaseValidation.adminSignIn(userName, password);
	}

	public boolean userSignUp(final String mobileNumber, final String userName, final String password) {
		return DatabaseValidation.userSignUp(mobileNumber, userName, password);
	}

	public void userSignIn(final String userName, final String password) {
		DatabaseValidation.userSignIn(userName, password);
	}

	/**
	 * Get question, answer and pass into addChat.
	 */
	public void addChat(final String question, final String answer) {
		boolean addChatReturnType = ADMIN_DAO.addChat(question, answer);

		if (addChatReturnType) {
			System.out.println("Added Successfully");
			ADMIN.adminChoice();
		}
	}

	/**
	 * Get id, question, answer and pass into updateChat.
	 */
	public void updateChat(final int id, final String question, final String answer) {
		boolean updateChatReturnType = ADMIN_DAO.updateChat(id, question, answer);

		if (updateChatReturnType) {
			System.out.println("Updated Successfully");
			ADMIN.adminChoice();
		}
	}

	/**
	 * Get the id for delete the chat
	 */
	public void deleteChat(final int id) {
		boolean deleteChatReturnType = ADMIN_DAO.deleteChat(id);

		if (deleteChatReturnType) {
			System.out.println("Deleted Successfully");
			ADMIN.adminChoice();
		}
	}

	/**
	 * Get the question for Chat
	 */
	public void userQuestion(final String userQuestion) {
		try {
			USER_DAO.doChat(userQuestion);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
