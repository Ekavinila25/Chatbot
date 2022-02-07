package com.chatbot.view;

import com.chatbot.controller.ChatBotController;
import com.chatbot.main.ChatBot;

/**
 * Get the input from the admin
 * 
 * @author KavinilaE
 */
public class Admin {
	private final static ChatBotController CHATBOT_CONTROLLER = new ChatBotController();

	/**
	 * Get the emailId,userName,password from admin and pass into controller for
	 * signUp
	 */
	public void adminSignUp() {
		System.out.println("Enter Your EmailId");
		final String emailId = Validation.emailIdValidation(ChatBot.SCANNER.next());

		System.out.println("Enter Your Username");
		final String userName = Validation.userNameValidation(ChatBot.SCANNER.next());

		System.out.println("Enter Your Password");
		final String password = Validation.passwordValidation(ChatBot.SCANNER.next());

		CHATBOT_CONTROLLER.adminSignUp(emailId, userName, password);
	}

	/**
	 * Get the userName,password and pass into controller for signIn
	 */
	public void adminSignIn() {
		System.out.println("Enter Your Username");
		final String userName = ChatBot.SCANNER.next();

		System.out.println("Enter Your Password");
		final String password = ChatBot.SCANNER.next();

		CHATBOT_CONTROLLER.adminSignIn(userName, password);
	}

	/**
	 * Check authorized Admin
	 * 
	 * @param isSignin
	 */
	public void adminaddreturn(boolean isSignin) {

		if (isSignin) {
			adminChoice();
		} else {
			ChatBot.adminChoice();
		}
	}

	/**
	 * Get the Admin choice for add,update and delete.
	 */
	public void adminChoice() {
		System.out.println("Give 1 for add 2 for update 3 for delete ");
		final int adminOption = ChatBot.SCANNER.nextInt();

		if (adminOption == 1) {
			addChat();
		} else if (adminOption == 2) {
			updateChat();
		} else {
			deleteChat();
		}
	}

	/**
	 * Get the question ,answer for add the chat
	 */
	public void addChat() {
		System.out.println("Enter Your question");
		final String question = ChatBot.SCANNER.next();

		System.out.println("Enter Your answer");
		final String answer = ChatBot.SCANNER.next();

		CHATBOT_CONTROLLER.addition(question, answer);

	}

	/**
	 * Get the id,question,answer for update the chat
	 */
	public void updateChat() {
		System.out.println("Enter The Id do you want to update");
		final int id = ChatBot.SCANNER.nextInt();

		System.out.println("Enter Your question");
		final String question = ChatBot.SCANNER.next();

		System.out.println("Enter Your answer");
		final String answer = ChatBot.SCANNER.next();

		CHATBOT_CONTROLLER.update(id, question, answer);
	}

	/**
	 * Get the id for delete the chat
	 */
	public void deleteChat() {
		System.out.println("Enter the Id do you wnat to delete");
		final int id = ChatBot.SCANNER.nextInt();

		CHATBOT_CONTROLLER.delete(id);
	}
}
