package com.chatbot.main;

import java.util.Scanner;

import com.chatbot.view.Admin;
import com.chatbot.view.User;

/**
 * Get the input from user
 * 
 * @author KavinilaE
 */
public class ChatBot {
	public final static Scanner SCANNER = new Scanner(System.in);

	/**
	 * Get the input from user for access as admin or user
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("1.Admin 2.User");
		final int userOption = SCANNER.nextInt();

		if (userOption == 1) {
			ChatBot.adminChoice();
		} else {
			ChatBot.userChoice();
		}
	}

	/**
	 * Get input from the admin for authentication.
	 */
	public static void adminChoice() {
		System.out.println("1.SignUp 2.Signin");
		final Admin admin = new Admin();
		final int adminChoice = SCANNER.nextInt();

		if (adminChoice == 1) {
			admin.adminSignUp();
		} else {
			admin.adminSignIn();
		}
	}

	/**
	 * Get input from user for authentication.
	 * 
	 */
	public static void userChoice() {
		System.out.println("1.SignUp 2.Signin");

		final User user = new User();
		final int userChoice = SCANNER.nextInt();

		if (userChoice == 1) {
			user.signUp();
		} else {
			user.signIn();
		}
	}
}
