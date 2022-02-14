package com.chatbot.view;

import org.apache.log4j.Logger;
import com.chatbot.controller.ChatBotController;
import com.chatbot.main.ChatBot;

/**
 * Get the input from the admin
 * 
 * @author KavinilaE
 */
public class Admin {

    private final static ChatBotController CHATBOT_CONTROLLER = new ChatBotController();
    private static final Logger LOGGER = Logger.getLogger(Admin.class);
    private final ChatBot chatBot = new ChatBot();

    /**
     * Get the emailId,userName,password from admin and pass for validation
     */
    public void adminSignUp() {
        LOGGER.info("Enter your emailId");
        final String emailId = Admin.getMailId();
        
        LOGGER.info("Enter your name");
        final String userName = Admin.getUserName();
        
        LOGGER.info("Enter your password");
        final String password = Admin.getPassword();
       
        CHATBOT_CONTROLLER.adminSignUp(emailId, userName, password);
    }
    
    /**
     * Validate emailId and pass into controller.
     * 
     * @return
     */
    private static String getMailId() {
        
        final String emailId = ChatBot.SCANNER.nextLine();
        final boolean isEmailValid = Validation.emailIdValidation(emailId);
        
        if (!isEmailValid) {
            LOGGER.info("Please enter valid emailId");
            return getMailId();
        }
        return emailId;
    }

    /**
     * Validate username and pass into controller.
     * 
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
     * 
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
     * @return 
     */
    public boolean adminAddReturn(final boolean isSignin) {

        if (isSignin) {
            adminChoice();
        } else {
            LOGGER.info("Please give valid username or signup");
            chatBot.adminChoice();
        }
        return isSignin;
    }

    /**
     * Get the Admin choice for add,update and delete.
     */
    public void adminChoice() {
        LOGGER.info("Give 1 for add 2 for update 3 for delete ");

        try {
            final int adminOption = Integer.parseInt(ChatBot.SCANNER.nextLine());

            if (adminOption == 1) {
                addChat();
            } else if (adminOption == 2) {
                updateChat();
            } else if (adminOption == 3) {
                deleteChat();
            } else {
                LOGGER.info("Please give the number 1 or 2 ");
                adminChoice();
            }
        } catch (NumberFormatException e) {
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
        final int id = Integer.parseInt(ChatBot.SCANNER.nextLine());

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
        final int id = Integer.parseInt(ChatBot.SCANNER.nextLine());

        CHATBOT_CONTROLLER.delete(id);
    }
}
