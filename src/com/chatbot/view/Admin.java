package com.chatbot.view;

import org.apache.log4j.Logger;

import com.chatbot.controller.ChatBotController;
import com.chatbot.main.ChatBot;
import com.chatbot.model.ChatBotUser;

/**
 * Get the input from the admin
 * 
 * @author KavinilaE
 */
public class Admin {

    private final static ChatBotController CHATBOT_CONTROLLER = new ChatBotController();
    private static final Logger LOGGER = Logger.getLogger(Admin.class);
    
    /**
     * Get the emailId,userName,password from admin and pass into controller for
     * signUp
     */
    public void adminSignUp() {
        LOGGER.info("Enter Your EmailId");
        final String emailId = Validation.emailIdValidation(ChatBot.SCANNER.nextLine());

        LOGGER.info("Enter Your Username");
        final String userName = Validation.userNameValidation(ChatBot.SCANNER.nextLine());

        LOGGER.info("Enter Your Password");
        final String password = Validation.passwordValidation(ChatBot.SCANNER.nextLine());
        ChatBotUser chatBotUser = new ChatBotUser(emailId, userName, password);

        CHATBOT_CONTROLLER.adminSignUp(chatBotUser);
    }

    /**
     * Get the userName,password and pass into controller for signIn
     */
    public void adminSignIn() {
        LOGGER.info("Enter Your Username");
        final String userName = ChatBot.SCANNER.nextLine();

        LOGGER.info("Enter Your Password");
        final String password = ChatBot.SCANNER.nextLine();

        CHATBOT_CONTROLLER.adminSignIn(userName, password);
    }

    /**
     * Check authorized Admin
     * 
     * @param isSignin
     */
    public void adminAddReturn(final boolean isSignin) {

        if (isSignin) {
            adminChoice();
        } else {
            ChatBot.adminChoice();
        }
    }

    /**
     * Get the Admin choice for add,update and delete.
     */
    public void adminChoice() {
        LOGGER.info("Give 1 for add 2 for update 3 for delete ");
      
        try {
            final String adminChoice = ChatBot.SCANNER.nextLine();
            final int adminOption = Integer.parseInt(adminChoice);
        
        if (adminOption == 1) {
            addChat();
        } else if (adminOption == 2) {
            updateChat();
        } else if (adminOption == 3) {
            deleteChat();
        } else {
            LOGGER.info("Please give the number 1 or 2 ");
            adminChoice();
        }}catch(NumberFormatException e) {
            LOGGER.error("Please give valid input");
            adminChoice();
        }
    }

    /**
     * Get the question, answer for add the chat
     */
    public void addChat() {
        LOGGER.info("Enter Your question");
        final String question = ChatBot.SCANNER.nextLine();

        LOGGER.info("Enter Your answer");
        final String answer = ChatBot.SCANNER.nextLine();

        CHATBOT_CONTROLLER.addition(question, answer);
    }

    /**
     * Get the id,question,answer for update the chat
     */
    public void updateChat() {
        LOGGER.info("Enter The Id do you want to update");
        final String chatId = ChatBot.SCANNER.nextLine();
        final int id = Integer.parseInt(chatId);

        LOGGER.info("Enter Your question");
        final String question = ChatBot.SCANNER.nextLine();

        LOGGER.info("Enter Your answer");
        final String answer = ChatBot.SCANNER.nextLine();

        CHATBOT_CONTROLLER.update(id, question, answer);
    }

    /**
     * Get the id for delete the chat
     */
    public void deleteChat() {
        LOGGER.info("Enter the Id do you want to delete");
        final String chatId = ChatBot.SCANNER.nextLine();
        final int id = Integer.parseInt(chatId);
        
        CHATBOT_CONTROLLER.delete(id);
    }
}
