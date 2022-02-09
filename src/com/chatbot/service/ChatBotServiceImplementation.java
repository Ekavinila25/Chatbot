package com.chatbot.service;

import com.chatbot.dao.AdminDao;
import com.chatbot.dao.UserDao;
import com.chatbot.model.ChatBotUser;
import com.chatbot.view.Admin;

/**
 * Get the input and pass for validation
 * 
 * @author KavinilaE
 */
public class ChatBotServiceImplementation implements Service {
    private final static AdminDao ADMIN_DAO = new AdminDao();
    private final static UserDao USER_DAO = new UserDao();
    private final static Admin ADMIN = new Admin();

    /**
     * Get emailId,userName,password and pass into validation for adminSignup
     * 
     * @author KavinilaE
     */
    public boolean adminSignUp(final ChatBotUser chatBotUser) {
        return ChatService.adminSignUp(chatBotUser);
    }

    /**
     * Get the userName,password and pass into validation for adminSignIn
     * 
     * @author KavinilaE
     */
    public void adminSignIn(final String userName, final String password) {
        ChatService.adminSignIn(userName, password);
    }

    /**
     * Get the input and pass into validation for userSignup
     * 
     * @author KavinilaE
     */
    public boolean userSignUp(final String mobileNumber, final String userName, final String password) {
        return ChatService.userSignUp(mobileNumber, userName, password);
    }

    /**
     * Get the input and pass into validation for userSignin
     * 
     * @author KavinilaE
     */
    public void userSignIn(final String userName, final String password) {
        ChatService.userSignIn(userName, password);
    }

    /**
     * Get question, answer and pass into addChat.
     */
    public void addChat(final String question, final String answer) {
        boolean addChatReturnType = ADMIN_DAO.addChat(question, answer);

        if (addChatReturnType) {
            System.out.println("Added Successfully");
            ADMIN.adminChoice();
        }
    }

    /**
     * Get id, question, answer and pass into updateChat.
     */
    public void updateChat(final int id, final String question, final String answer) {
        boolean updateChatReturnType = ADMIN_DAO.updateChat(id, question, answer);

        if (updateChatReturnType) {
            System.out.println("Updated Successfully");
            ADMIN.adminChoice();
        }
    }

    /**
     * Get the id and pass for delete
     */
    public void deleteChat(final int id) {
        boolean deleteChatReturnType = ADMIN_DAO.deleteChat(id);

        if (deleteChatReturnType) {
            System.out.println("Deleted Successfully");
            ADMIN.adminChoice();
        }
    }

    /**
     * Get the question for Chating
     */
    public void userQuestion(final String userQuestion) {
        USER_DAO.doChat(userQuestion);
    }
}
