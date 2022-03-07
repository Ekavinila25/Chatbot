package org.example;

import java.util.Scanner;

/**
 * The Class contain main method initiate the application
 *
 * @author KavinilaEx
 */
public class ChatBot {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void userInput() {
        System.out.println("1.Admin 2.User 3.Exit");

        try {
            final int userchoice = Integer.parseInt(SCANNER.next().trim());

            if (userchoice == 1) {
                AdminPage.adminAuthentication();
            } else if (userchoice == 2) {
                UserPage.userAuthentication();
            } else if (userchoice == 3) {

                try {
                    Activator.bundle.stop();
                } catch (Exception e) {
                    System.out.println(e);
                }
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
