package org.example.service;

import org.example.exception.InsertionFailedException;
import org.example.exception.LoginFailedException;

/**
 * Gets the input and pass for validation.
 *
 * @author KavinilaE
 */

public class ChatBotServiceImplementation implements Service {

    /**
     * Gets emailId,userName,password and pass into validation for adminSignup.
     *
     * @param emailId
     * @param userName
     * @param password
     */
    public boolean adminSignUp(final String emailId, final String userName, final String password) {

        try {
            return ChatBotValidator.adminSignUp(emailId, userName, password);
        } catch (Exception exception) {
            throw new InsertionFailedException("Insertion failed");
        }
    }

    /**
     * Gets the userName,password and pass into validation for adminSignIn.
     *
     * @param userName
     * @param password
     */
    public boolean adminSignIn(final String userName, final String password) {

        try {
            return ChatBotValidator.adminSignIn(userName, password);
        } catch (Exception exception) {
            throw new LoginFailedException("Insertion failed");
        }
    }

    /**
     * Gets the input and pass into validation for userSignup.
     *
     * @param mobileNumber
     * @param userName
     * @param password
     */
    public boolean userSignUp(final String mobileNumber, final String userName, final String password) {

        try {
            return ChatBotValidator.userSignUp(mobileNumber, userName, password);
        } catch (Exception exception) {
            throw new InsertionFailedException("Insertion failed");
        }
    }

    /**
     * Gets the input and pass into validation for userSignin.
     *
     * @param userName
     * @param password
     */
    public boolean userSignIn(final String userName, final String password) {

        try {

            return ChatBotValidator.userSignIn(userName, password);
        } catch (Exception exception) {
            throw new LoginFailedException("Login failed");
        }
    }
}

