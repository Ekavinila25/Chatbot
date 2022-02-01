package com.chatbot.view;
import java.sql.SQLException;

import com.chatbot.controller.ChatBotController;

public class User {
		ChatBotController chatBotController = new ChatBotController();
	   
		public void signUp() throws ClassNotFoundException, SQLException {
			
			System.out.println("Enter The Mobilenum");
			String mobileNum = Validation.mobileNumberValidation(MainClass.SCANNER.next());
			
			System.out.println("Enter The Username");
			String userName= Validation.userNameValidation(MainClass.SCANNER.next());
			
			System.out.println("Enter The Password");
			String password= Validation.passwordValidation(MainClass.SCANNER.next());
			
			chatBotController.userSignUp(mobileNum, userName, password);
		}

		public void signIn() throws ClassNotFoundException, SQLException {

			System.out.println("Plz Enter The Username");
			String userName = MainClass.SCANNER.next();

			System.out.println("Plz Enter The Password");
			String password = MainClass.SCANNER.next();

			chatBotController.userSignIn(userName, password);
		}
	}



