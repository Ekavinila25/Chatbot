package org.example.authentication.controller;

import org.example.authentication.service.ChatBotServiceImplementation;

/**
 * Get and Pass the emailid,username,password into corresponding implementation.
 */
public class ChatbotController {

    private final ChatBotServiceImplementation SERVICE_IMPLEMENTATION=new ChatBotServiceImplementation();

    public boolean adminSignUp(final String emailId, final String userName, final String password) {
        return SERVICE_IMPLEMENTATION.adminSignUp(emailId, userName, password);
    }

    public boolean adminSignIn(final String userName, final String password) {
        return SERVICE_IMPLEMENTATION.adminSignIn(userName, password);
    }

    public boolean userSignUp(final String mobileNumber, final String userName, final String password) {
        return SERVICE_IMPLEMENTATION.userSignUp(mobileNumber, userName, password);
    }

    public boolean userSignIn(final String userName, final String password) {
        return SERVICE_IMPLEMENTATION.userSignIn(userName, password);
    }
}


