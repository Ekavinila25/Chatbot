package com.chatbot.view;

import org.apache.log4j.Logger;

import com.chatbot.controller.ChatBotController;
import com.chatbot.main.ChatBot;


/**
 * Gets the input from the admin and pass into controller.
 * 
 * @author KavinilaE
 */
public class AdminPage {

    private final static ChatBotController CHATBOT_CONTROLLER = new ChatBotController();
    private static final Logger LOGGER = Logger.getLogger(AdminPage.class);

    /**
     * Gets input from the admin for authentication.
     */
    public static void adminAuthentication() {
        final AdminPage admin = new AdminPage();
        LOGGER.info("1.SignUp 2.Signin");

        try {
            final int adminOption = Integer.parseInt(ChatBot.SCANNER.nextLine().trim());

            if (adminOption == 1) {
                admin.adminSignUp();
            } else if (adminOption == 2) {
                admin.adminSignIn();
            } else {
                LOGGER.info("Please give valid input");
                AdminPage.adminAuthentication();
            }
        } catch (NumberFormatException e) {
            LOGGER.error("Please enter input in number(1 or 2) ");
            AdminPage.adminAuthentication();
        }
    }

    /**
     * Gets the emailId,userName,password and validate and pass into controller.
     */
    public void adminSignUp() {
        LOGGER.info("Enter your emailId");
        final String emailId = AdminPage.getMailId();

        LOGGER.info("Enter your name");
        final String userName = AdminPage.getUserName();

        LOGGER.info("Enter your password");
        final String password = AdminPage.getPassword();

        if (CHATBOT_CONTROLLER.adminSignUp(emailId, userName, password)) {
            LOGGER.info("Please give another emailId");
            AdminPage.adminAuthentication();
        } else {
            AdminPage.adminAuthentication();
        }
    }

    /**
     * Gets the userName,password and validate pass into controller for signin.
     */
    public void adminSignIn() {
        LOGGER.info("Enter Your Username");
        final String userName = ChatBot.SCANNER.nextLine().trim();

        LOGGER.info("Enter Your Password");
        final String password = ChatBot.SCANNER.nextLine().trim();

        if (CHATBOT_CONTROLLER.adminSignIn(userName, password)) {
            LOGGER.info("You are logged in");
            AdminPage.adminChoice();
        } else {
            LOGGER.info("Please give valid username and password or sign up");
            AdminPage.adminAuthentication();
        }
    }

    /**
     * Validates emailId.
     * 
     * @return
     */
    private static String getMailId() {
        final String emailId = ChatBot.SCANNER.nextLine().trim();

        if (!Validator.emailIdValidate(emailId)) {
            LOGGER.info("Please enter valid emailId");
            return getMailId();
        }
        return emailId;
    }

    /**
     * Validates username.
     * 
     * @return userName
     */
    private static String getUserName() {
        final String userName = ChatBot.SCANNER.nextLine().trim();

        if (!Validator.userNameValidate(userName)) {
            LOGGER.info("Please enter valid username");
            return getUserName();
        }
        return userName;
    }

    /**
     * Validates the password.
     * 
     * @return
     */
    private static String getPassword() {
        final String password = ChatBot.SCANNER.nextLine().trim();

        if (!Validator.passwordValidate(password)) {
            LOGGER.info("Please enter valid password");
            return getPassword();
        }
        return password;
    }

    /**
     * Gets the Admin choice for add,update and delete.
     */
    public static void adminChoice() {
        LOGGER.info("Give 1 for add 2 for update 3 for delete ");

        try {
            final int adminOption = Integer.parseInt(ChatBot.SCANNER.nextLine().trim());

            if (adminOption == 1) {
                AdminPage.addChat();
            } else if (adminOption == 2) {
                AdminPage.updateChat();
            } else if (adminOption == 3) {
                AdminPage.deleteChat();
            } else {
                LOGGER.info("Please give the number 1 or 2 ");
                AdminPage.adminChoice();
            }
        } catch (NumberFormatException e) {
            LOGGER.error("Please give valid input");
            AdminPage.adminChoice();
        }
    }

    /**
     * Gets the question,answer and pass into controller for add the chat.
     */
    public static void addChat() {
        LOGGER.info("Enter Your question");
        final String question = ChatBot.SCANNER.nextLine().trim();

        LOGGER.info("Enter Your answer");
        final String answer = ChatBot.SCANNER.nextLine().trim();

        if (CHATBOT_CONTROLLER.addChat(question, answer))
            LOGGER.info("Added Successfully");
        AdminPage.adminChoice();
    }

    /**
     * Gets the id,question,answer and pass into controller for update the chat.
     */
    public static void updateChat() {
        LOGGER.info("Enter The Id do you want to update");
        final int id = Integer.parseInt(ChatBot.SCANNER.nextLine().trim());

        LOGGER.info("Enter Your question");
        final String question = ChatBot.SCANNER.nextLine().trim();

        LOGGER.info("Enter Your answer");
        final String answer = ChatBot.SCANNER.nextLine().trim();

        if (CHATBOT_CONTROLLER.updateChat(id, question, answer))
            LOGGER.info("Updated Successfully");
        AdminPage.adminChoice();
    }

    /**
     * Gets the id and pass into controller delete the chat.
     */
    public static void deleteChat() {
        LOGGER.info("Enter the Id do you want to delete");
        final int id = Integer.parseInt(ChatBot.SCANNER.nextLine().trim());

        if (CHATBOT_CONTROLLER.deleteChat(id))
            LOGGER.info("Deleted Successfully");
        AdminPage.adminChoice();
    }
}
