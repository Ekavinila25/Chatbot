package com.chatbot.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.chatbot.view.Admin;
import com.chatbot.view.User;

/**
 * Get the input from user
 * 
 * @author KavinilaE
 */
public class ChatBot {

    public static final Scanner SCANNER = new Scanner(System.in);
    private final Logger LOGGER = Logger.getLogger(ChatBot.class);
    private static final ChatBot chatBot = new ChatBot();

    public static void main(String[] args) throws FileNotFoundException, IOException {
        final String LOG_FILE = "chatbot.properties";
        final Properties PROPERTIES = new Properties();
        PROPERTIES.load(new FileInputStream(LOG_FILE));
        PropertyConfigurator.configure(PROPERTIES);
        chatBot.userInput();
    }

    /**
     * Get the input from user for access admin or user.
     */
    private void userInput() {
        LOGGER.info("1.Admin 2.User");

        try {
            final int userchoice = Integer.parseInt(SCANNER.nextLine());

            if (userchoice == 1) {
                chatBot.adminChoice();
            } else if (userchoice == 2) {
                chatBot.userChoice();
            } else {
                LOGGER.info("Please give the valid input");
                userInput();
            }
        } catch (NumberFormatException e) {
            LOGGER.error("Please enter the input in number (1 or 2)");
            userInput();
        }
    }

    /**
     * Get input from the admin for authentication.
     */
    public void adminChoice() {
        final Admin admin = new Admin();
        LOGGER.info("1.SignUp 2.Signin");

        try {
          final int adminChoice = Integer.parseInt(SCANNER.nextLine());

            if (adminChoice == 1) {
                admin.adminSignUp();
            } else if (adminChoice == 2) {
                admin.adminSignIn();
            } else {
                LOGGER.info("Please give valid input");
                adminChoice();
            }
        } catch (NumberFormatException e) {
            LOGGER.error("Please enter input in number(1 or 2) ");
            adminChoice();
        }
    }

    /**
     * Get input from user for authentication.
     */
    public void userChoice() {
        LOGGER.info("1.SignUp 2.Signin");
        final User user = new User();

        try {
          final int userChoice = Integer.parseInt( SCANNER.nextLine());

            if (userChoice == 1) {
                user.signUp();
            } else if (userChoice == 2) {
                user.signIn();
            } else {
                LOGGER.info("Please give the valid input ");
                userChoice();
            }
        } catch (NumberFormatException e) {
            LOGGER.error("Please give the input in number (1 or 2) ");
            userChoice();
        }
    }
}