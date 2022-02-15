package com.chatbot.view;

import org.apache.log4j.Logger;

import com.chatbot.controller.ChatBotController;
import com.chatbot.main.ChatBot;

/**
 * Gets the input from the user.
 * 
 * @author KavinilaE
 */
public class UserPage {

    private final ChatBotController CHATBOT_CONTROLLER = new ChatBotController();
    private static final Logger LOGGER = Logger.getLogger(UserPage.class);
    private static final UserPage USER_PAGE = new UserPage();
    
    /**
     * Gets input from user for authentication.
     */
    public static void userAuthentication() {
        LOGGER.info("1.SignUp 2.Signin");
        

        try {
            final int userOption = Integer.parseInt(ChatBot.SCANNER.nextLine().trim());

            if (userOption == 1) {
                USER_PAGE.signUp();
            } else if (userOption == 2) {
                USER_PAGE.signIn();
            } else {
                LOGGER.info("Please give the valid input ");
                UserPage.userAuthentication();
            }
        } catch (NumberFormatException e) {
            LOGGER.error("Please give the input in number (1 or 2) ");
            UserPage.userAuthentication();
        }
    }
    
    /**
     * Gets the mobileNum,userName,password and validate and pass into controller.
     */
    public void signUp() {
        LOGGER.info("Enter your mobilenumber");
        final String mobileNumber =USER_PAGE.getMobileNumber();

        LOGGER.info("Enter your username");
        final String userName = USER_PAGE.getUserName();

        LOGGER.info("Enter Your password");
        final String password =USER_PAGE.getPassword();

        if (CHATBOT_CONTROLLER.userSignUp(mobileNumber, userName, password)) {
            LOGGER.info("Please give another mobilenumber");
            UserPage.userAuthentication();
        } else {
            LOGGER.info("Welcome You can chat now");
            USER_PAGE.userChat();
        }
    }

    /**
     * Validates the mobile number.
     * 
     * @return
     */
    private String getMobileNumber() {
        final String mobileNumber = ChatBot.SCANNER.nextLine().trim();

        if (!Validator.mobileNumberValidate(mobileNumber)) {
            LOGGER.info("Please enter valid mobilenumber");
            return getMobileNumber();
        }
        return mobileNumber;
    }

    /**
     * Validates the username.
     * 
     * @return
     */
    private String getUserName() {
        final String userName = ChatBot.SCANNER.nextLine().trim();

        if (!Validator.userNameValidate(userName)) {
            LOGGER.info("Please enter username");
            return getUserName();
        }
        return userName;
    }

    /**
     * Validates the password.
     * 
     * @return
     */
    private String getPassword() {
        final String password = ChatBot.SCANNER.nextLine().trim();

        if (!Validator.passwordValidate(password)) {
            LOGGER.info("Please enter valid password");
            return getPassword();
        }
        return password;
    }

    /**
     * Gets userName and password from user pass into controller for signin.
     */
    public void signIn() {
        LOGGER.info("Please Enter The Username");
        final String userName = ChatBot.SCANNER.nextLine().trim();

        LOGGER.info("Please Enter The Password");
        final String password = ChatBot.SCANNER.nextLine().trim();

        if (CHATBOT_CONTROLLER.userSignIn(userName, password)) {
            LOGGER.info("welcome You can chat now");
            userChat();
        } else {
            LOGGER.info("Please give correct username and password");
            UserPage.userAuthentication();
        }
    }

    /**
     * Gets the question from user and pass into controller.
     */
    public void userChat() {

        while (true) {
            final String userQuestion = ChatBot.SCANNER.nextLine().trim();
            CHATBOT_CONTROLLER.userChat(userQuestion);
        }
    }
}
