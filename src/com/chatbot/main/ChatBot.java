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
        //String userOption = SCANNER.nextLine();
        //int userOption1 = Integer.parseInt(userOption);

        if (userOption == 1) {
            ChatBot.adminChoice();
        } else if (userOption == 2) {
            ChatBot.userChoice();
        } else {
            System.out.println("Please Enter valid one");
        }
    }

    /**
     * Get input from the admin for authentication.
     */
    public static void adminChoice() {
        System.out.println("1.SignUp 2.Signin");
        final Admin admin = new Admin();
        final int adminChoice = SCANNER.nextInt();
        //final String adminChoice = ChatBot.SCANNER.nextLine();
        // final int adminChoice1 = Integer.parseInt(adminChoice);
        if (adminChoice == 1) {
            admin.adminSignUp();
        } else if (adminChoice == 2) {
            admin.adminSignIn();
        } else {
            System.out.println("Please give valid one");
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
        //final String userChoice = ChatBot.SCANNER.nextLine();
        //final int userChoice1 = Integer.parseInt(userChoice);
        if (userChoice == 1) {
            user.signUp();
        } else if (userChoice == 2) {
            user.signIn();
        } else {
            System.out.println("Please give valid one");
        }
    }
}
