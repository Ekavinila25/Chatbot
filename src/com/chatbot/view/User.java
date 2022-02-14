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
     * Get the mobileNum,userName,password from user pass into controller
     */
    public void signUp() {
        LOGGER.info("Enter The Mobilenum");
        final String mobileNum = Validation.mobileNumberValidation(ChatBot.SCANNER.nextLine());

        LOGGER.info("Enter The Username");
        final String userName = Validation.userNameValidation(ChatBot.SCANNER.nextLine());

        LOGGER.info("Enter The Password");
        final String password = Validation.passwordValidation(ChatBot.SCANNER.nextLine());

        CHATBOT_CONTROLLER.userSignUp(mobileNum, userName, password);
    }

    /**
     * Get userName and password from user pass into controller
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
