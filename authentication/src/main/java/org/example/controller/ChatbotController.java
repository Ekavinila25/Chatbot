package org.example.controller;

import org.example.service.ChatBotServiceImplementation;
import org.osgi.service.component.annotations.Reference;

/**
 * Get and Pass the emailid,username,password into corresponding implementation.
 */
public class ChatbotController {

    @Reference
    ChatBotServiceImplementation serviceImplementation;

    public boolean adminSignUp(final String emailId, final String userName, final String password) {
        return serviceImplementation.adminSignUp(emailId, userName, password);
    }

    public boolean adminSignIn(final String userName, final String password) {
        return serviceImplementation.adminSignIn(userName, password);
    }

    public boolean userSignUp(final String mobileNumber, final String userName, final String password) {
        return serviceImplementation.userSignUp(mobileNumber, userName, password);
    }

    public boolean userSignIn(final String userName, final String password) {
        return serviceImplementation.userSignIn(userName, password);
    }
}


