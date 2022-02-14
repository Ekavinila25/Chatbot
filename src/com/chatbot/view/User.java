package com.chatbot.view;

import org.apache.log4j.Logger;

import com.chatbot.controller.ChatBotController;
import com.chatbot.main.ChatBot;

/**
 * Get the input from the user
 * 
 * @author KavinilaE
 */
public class User {

    private final ChatBotController CHATBOT_CONTROLLER = new ChatBotController();
    private static final Logger LOGGER = Logger.getLogger(User.class);
    private final ChatBot chatBot = new ChatBot();

    /**
     * Get the mobileNum,userName,password from user pass for validation
     */
    public void signUp() {
        LOGGER.info("Enter your mobilenumber");
        final String mobileNumber = User.getMobileNumber();

        LOGGER.info("Enter your username");
        final String userName = User.getUserName();

        LOGGER.info("Enter Your password");
        final String password = User.getPassword();

        CHATBOT_CONTROLLER.userSignUp(mobileNumber, userName, password);
    }

    /**
     * Validate the mobile number and pass into controller
     * 
     * @return
     */
    private static String getMobileNumber() {
        final String mobileNumber = ChatBot.SCANNER.nextLine();
        final boolean isEmailValid = Validation.mobileNumberValidation(mobileNumber);

        if (!isEmailValid) {
            LOGGER.info("Please enter valid emailId");
            return getMobileNumber();
        }
        return mobileNumber;
    }

    /**
     * Validate the username and pass into controller
     * @return
     */
    private static String getUserName() {
        final String userName = ChatBot.SCANNER.nextLine();
        final boolean isNameValid = Validation.userNameValidation(userName);

        if (!isNameValid) {
            LOGGER.info("Please enter username");
            return getUserName();
        }
        return userName;
    }

    /**
     * Validate the password and pass into controller
     * @return
     */
    private static String getPassword() {
        final String password = ChatBot.SCANNER.nextLine();
        final boolean isPasswordValid = Validation.passwordValidation(password);

        if (!isPasswordValid) {
            LOGGER.info("Please enter valid password");
            return getPassword();
        }
        return password;
    }

    /**
     * Get userName and password from user pass into controller for signin
     */
    public void signIn() {
        LOGGER.info("Please Enter The Username");
        final String userName = ChatBot.SCANNER.nextLine();

        LOGGER.info("Please Enter The Password");
        final String password = ChatBot.SCANNER.nextLine();

        CHATBOT_CONTROLLER.userSignIn(userName, password);
    }

    /**
     * Check valid user
     * 
     */
    public void validUser(boolean isSignin) {

        if (isSignin) {
            userChat();
        } else {
            chatBot.userChoice();
        }
    }

    /**
     * Pass the parameter for question Chat
     */
    public void userChat() {

        while (true) {
            final String userQuestion = ChatBot.SCANNER.nextLine();
            CHATBOT_CONTROLLER.userChat(userQuestion);
        }
    }
}
