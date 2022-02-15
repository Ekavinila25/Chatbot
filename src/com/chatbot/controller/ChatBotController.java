package com.chatbot.controller;

import com.chatbot.service.ChatBotServiceImplementation;
import com.chatbot.service.Service;

/**
 * Get and Pass the emailid,username,password into corresponding implementation.
 * 
 * @author KavinilaE
 *
 */
public class ChatBotController {

    private static final Service SERVICE_IMPLEMENTATION = new ChatBotServiceImplementation();

    public boolean adminSignUp(final String emailId, final String userName, final String password) {
        return SERVICE_IMPLEMENTATION.adminSignUp(emailId, userName, password);
    }

    public boolean adminSignIn(final String userName, final String password) {
        return SERVICE_IMPLEMENTATION.adminSignIn(userName, password);
    }

    public boolean addChat(final String question, final String answer) {
        return SERVICE_IMPLEMENTATION.addChat(question, answer);
    }

    public boolean updateChat(final int id, final String question, final String answer) {
        return SERVICE_IMPLEMENTATION.updateChat(id, question, answer);
    }

    public boolean deleteChat(final int id) {
        return SERVICE_IMPLEMENTATION.deleteChat(id);
    }

    public boolean userSignUp(final String mobileNumber, final String userName, final String password) {
        return SERVICE_IMPLEMENTATION.userSignUp(mobileNumber, userName, password);
    }

    public boolean userSignIn(final String userName, final String password) {
        return SERVICE_IMPLEMENTATION.userSignIn(userName, password);
    }

    public void userChat(final String userQuestion) {
        SERVICE_IMPLEMENTATION.userQuestion(userQuestion);
    }
}