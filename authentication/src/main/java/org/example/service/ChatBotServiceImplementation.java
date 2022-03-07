package org.example.service;

import org.osgi.service.component.annotations.Component;

/**
 * Gets the input and pass for validation.
 *
 * @author KavinilaE
 */
@Component
public class ChatBotServiceImplementation implements Service {

    /**
     * Gets emailId,userName,password and pass into validation for adminSignup.
     *
     * @param emailId
     * @param userName
     * @param password
     */
    public boolean adminSignUp(final String emailId, final String userName, final String password) {
        return ChatBotValidator.adminSignUp(emailId, userName, password);
    }

    /**
     * Gets the userName,password and pass into validation for adminSignIn.
     *
     * @param userName
     * @param password
     */
    public boolean adminSignIn(final String userName, final String password) {
        return ChatBotValidator.adminSignIn(userName, password);
    }

    /**
     * Gets the input and pass into validation for userSignup.
     *
     * @param mobileNumber
     * @param userName
     * @param password
     */
    public boolean userSignUp(final String mobileNumber, final String userName, final String password) {
        return ChatBotValidator.userSignUp(mobileNumber, userName, password);
    }

    /**
     * Gets the input and pass into validation for userSignin.
     *
     * @param userName
     * @param password
     */
    public boolean userSignIn(final String userName, final String password) {
        return ChatBotValidator.userSignIn(userName, password);
    }
}

