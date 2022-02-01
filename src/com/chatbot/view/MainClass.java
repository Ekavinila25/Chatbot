package com.chatbot.view;

import java.sql.SQLException;

import java.util.Scanner;

public class MainClass {
	public final static Scanner SCANNER = new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		while (true) {
			System.out.println("1.Admin 2.User");
			int userOption = SCANNER.nextInt();

			if (userOption == 1) {
				MainClass.adminChoice();
			} else {
				MainClass.userChoice();
			}
		}
	}

	public static void adminChoice() throws ClassNotFoundException, SQLException {
		System.out.println("1.SignUp 2.Signin");
		final Admin admin = new Admin();
		int adminChoice = SCANNER.nextInt();

		if (adminChoice == 1) {
			admin.signUp();
		} else {
			admin.signIn();
		}
	}

	public static void userChoice() throws ClassNotFoundException, SQLException {
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
