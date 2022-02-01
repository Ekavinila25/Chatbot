package com.chatbot.view;

import java.sql.SQLException;

import com.chatbot.controller.ChatBotController;

public class Admin {
	final ChatBotController CHATBOTCONTROLLER = new ChatBotController();

	public void signUp() throws ClassNotFoundException, SQLException {
		System.out.println("Enter The EmailId");
		String emailId = Validation.emailIdValidation(MainClass.SCANNER.next());

		System.out.println("Enter The Username");
		String userName = Validation.userNameValidation(MainClass.SCANNER.next());

		System.out.println("Enter The Password");
		String password = Validation.passwordValidation(MainClass.SCANNER.next());

		CHATBOTCONTROLLER.adminSignUp(emailId, userName, password);
	}

	public void signIn() throws ClassNotFoundException, SQLException {
		System.out.println("Enter The Username");
		String userName = MainClass.SCANNER.next();

		System.out.println("Enter The Password");
		String password = MainClass.SCANNER.next();

		CHATBOTCONTROLLER.adminSignIn(userName, password);
	}
}
