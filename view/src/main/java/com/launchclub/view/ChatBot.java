package com.launchclub.view;

import java.util.Scanner;



/**
 * The Class contain main method initiate the application
 *
 * @author KavinilaE
 */
public class ChatBot {

    public static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Gets the input from user for access admin or user.
     */
    public static void userInput() {

        System.out.println("1.Admin 2.User");

        try {
            final int userchoice = Integer.parseInt(SCANNER.nextLine().trim());

            if (userchoice == 1) {
                AdminPage.adminAuthentication();
            } else if (userchoice == 2) {
                UserPage.userAuthentication();
            } else {
                System.out.print("Please give the valid input");
                ChatBot.userInput();
            }
        } catch (NumberFormatException e) {
            System.out.print("Please enter the input in number (1 or 2)");
            ChatBot.userInput();
        }
    }
}