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
    private final ChatBot chatbot=new ChatBot();

    public static void main(String[] args) throws FileNotFoundException, IOException {
        final String LOG_FILE = "chatbot.properties";
        final Properties PROPERTIES = new Properties();
        PROPERTIES.load(new FileInputStream(LOG_FILE));
        PropertyConfigurator.configure(PROPERTIES);
        final ChatBot chatBot = new ChatBot();
        chatBot.userInput();
    }

    /**
     * Get the input from user for access admin or user.
     */
    private void userInput() {
        LOGGER.info("1.Admin 2.User");

        try {
            final String userOption = SCANNER.nextLine();
            final int userchoice = Integer.parseInt(userOption);

            if (userchoice == 1) {
                ChatBot.adminChoice();
            } else if (userchoice == 2) {
                ChatBot.userChoice();
            } else {
                LOGGER.info("Please enter the number 1 or 2");
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
            final String adminOption = SCANNER.nextLine();
            final int adminChoice = Integer.parseInt(adminOption);

            if (adminChoice == 1) {
                admin.adminSignUp();
            } else if (adminChoice == 2) {
                admin.adminSignIn();
            } else {
                LOGGER.info("Please give the number 1 or 2");
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
            final String userOption = SCANNER.nextLine();
            final int userChoice = Integer.parseInt(userOption);

            if (userChoice == 1) {
                user.signUp();
            } else if (userChoice == 2) {
                user.signIn();
            } else {
                LOGGER.info("Please give the number 1 or 2 ");
                userChoice();

            }
        } catch (NumberFormatException e) {
            LOGGER.error("Please give the input in number (1 or 2) ");
            userChoice();
        }
    }
}