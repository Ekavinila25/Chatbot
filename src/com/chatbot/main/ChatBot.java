package com.chatbot.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.chatbot.view.AdminPage;
import com.chatbot.view.UserPage;

/**
 * The Class contain main method initiate the application
 * 
 * @author KavinilaE
 */
public class ChatBot {

    public static final Scanner SCANNER = new Scanner(System.in);
    private static final Logger LOGGER = Logger.getLogger(ChatBot.class);

    public static void main(String[] args) throws FileNotFoundException, IOException {
        final String logFile = "chatbot.properties";
        final Properties Properties = new Properties();

        Properties.load(new FileInputStream(logFile));
        PropertyConfigurator.configure(Properties);
        ChatBot.userInput();
    }

    /**
     * Gets the input from user for access admin or user.
     */
    private static void userInput() {
        LOGGER.info("1.Admin 2.User");

        try {
            final int userchoice = Integer.parseInt(SCANNER.nextLine().trim());

            if (userchoice == 1) {
                AdminPage.adminAuthentication();
            } else if (userchoice == 2) {
                UserPage.userAuthentication();
            } else {
                LOGGER.info("Please give the valid input");
                ChatBot.userInput();
            }
        } catch (NumberFormatException e) {
            LOGGER.error("Please enter the input in number (1 or 2)");
            ChatBot.userInput();
        }
    }
}