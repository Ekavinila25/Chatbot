package com.chatbot.view;

import com.chatbot.controller.ChatBotController;

public class User {
	private final ChatBotController CHATBOT_CONTROLLER = new ChatBotController();

	public void signUp() {
		System.out.println("Enter The Mobilenum");
		String mobileNum = Validation.mobileNumberValidation(ChatBot.SCANNER.next());

		System.out.println("Enter The Username");
		String userName = Validation.userNameValidation(ChatBot.SCANNER.next());

		System.out.println("Enter The Password");
		String password = Validation.passwordValidation(ChatBot.SCANNER.next());
		
		CHATBOT_CONTROLLER.userSignUp(mobileNum, userName, password);
	}

	public void signIn() {
		System.out.println("Please Enter The Username");
		String userName = ChatBot.SCANNER.next();

		System.out.println("Please Enter The Password");
		String password = ChatBot.SCANNER.next();

		CHATBOT_CONTROLLER.userSignIn(userName, password);
	}
}
