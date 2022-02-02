package com.chatbot.view;

import java.util.Scanner;

public class ChatBot {
	public final static Scanner SCANNER = new Scanner(System.in);

	public static void main(String[] args) {
        System.out.println("1.Admin 2.User");
		int userOption = SCANNER.nextInt();

		if (userOption == 1) {
			ChatBot.adminChoice();
		} else {
			ChatBot.userChoice();
		}
	}

	public static void adminChoice() {
		System.out.println("1.SignUp 2.Signin");
		final Admin admin = new Admin();
		int adminChoice = SCANNER.nextInt();
		if (adminChoice == 1) {
			admin.signUp();
		} else {
			admin.signIn();
		}
	}

	public static void userChoice() {
		System.out.println("1.SignUp 2.Signin");
		final User user = new User();
		int userChoice = SCANNER.nextInt();

		if (userChoice == 1) {
			user.signUp();
		} else {
			user.signIn();
		}
	}
}
