package org.example.chatbot.chatbot;

import java.util.Scanner;


import org.apache.log4j.Logger;
import org.example.authentication.view.Adminview;
import org.example.authentication.view.UserView;

/**
 * The Class contain main method initiate the application
 *
 * @author KavinilaE
 */
public class ChatBot {

    public static final Logger logger= Logger.getLogger(ChatBot.class);
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void userInput() {

        System.out.println("1.Admin 2.User 3.Exit");

        try {
            final int userchoice = Integer.parseInt(SCANNER.next().trim());

            if (userchoice == 1) {
                Adminview.adminAuthentication();
            } else if (userchoice == 2) {
                UserView.userAuthentication();
            } else if (userchoice == 3) {
                System.exit(0);
            } else {
                logger.info("Please give the valid input");
                ChatBot.userInput();
            }
        } catch (NumberFormatException e) {
            logger.warn("Please enter the input in number (1 or 2)");
            ChatBot.userInput();
        }
    }
}
