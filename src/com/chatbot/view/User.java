package com.chatbot.view;

import com.chatbot.controller.ChatBotController;
import com.chatbot.main.ChatBot;

/**
 * Get the input from the user
 * 
 * @author KavinilaE
 */
public class User {
	private static final ChatBotController CHATBOT_CONTROLLER = new ChatBotController();
	
	/**
	 * Get the mobileNum,userName,password from user pass into controller
	 */
	public void signUp() {
		System.out.println("Enter The Mobilenum");
		final String mobileNum = Validation.mobileNumberValidation(ChatBot.SCANNER.next());

		System.out.println("Enter The Username");
		final String userName = Validation.userNameValidation(ChatBot.SCANNER.next());

		System.out.println("Enter The Password");
		final String password = Validation.passwordValidation(ChatBot.SCANNER.next());

		CHATBOT_CONTROLLER.userSignUp(mobileNum, userName, password);
	}

	/**
	 * Get userName and password from user pass into controller
	 */
	public void signIn() {
		System.out.println("Please Enter The Username");
		final String userName = ChatBot.SCANNER.next();

		System.out.println("Please Enter The Password");
		final String password = ChatBot.SCANNER.next();

		CHATBOT_CONTROLLER.userSignIn(userName, password);
	}

	/**
	 * Check valid user
	 * 
	 */
	public void validUser(boolean isSignin) {

		if (isSignin) {
			userChat();
		}else {
			ChatBot.userChoice();
		}
	}

	/**
	 * Pass the parameter for question Chat
	 */
	public void userChat() {
	

		while (true) {
			String userQuestion = ChatBot.SCANNER.nextLine();

			CHATBOT_CONTROLLER.userChat(userQuestion);
		}
	}
}
