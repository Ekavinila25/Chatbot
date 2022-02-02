package com.chatbot.view;

import com.chatbot.controller.ChatBotController;

public class Admin {
	private final ChatBotController CHATBOT_CONTROLLER = new ChatBotController();

	public void signUp() {
		System.out.println("Enter The EmailId");
		String emailId = Validation.emailIdValidation(ChatBot.SCANNER.next());

		System.out.println("Enter The Username");
		String userName = Validation.userNameValidation(ChatBot.SCANNER.next());

		System.out.println("Enter The Password");
		String password = Validation.passwordValidation(ChatBot.SCANNER.next());

		CHATBOT_CONTROLLER.adminSignUp(emailId, userName, password);
	}

	public void signIn() {
		System.out.println("Enter The Username");
		String userName = ChatBot.SCANNER.next();

		System.out.println("Enter The Password");
		String password = ChatBot.SCANNER.next();

		CHATBOT_CONTROLLER.adminSignIn(userName, password);
	}
}
