package org.example.service;

import org.example.UserChat;

/**
 * Gets the input and pass for validation.
 *
 * @author KavinilaE
 */
public class ChatBotServiceImplementation implements Service {

    private final static UserChat USER_CHAT = new UserChat();

    @Override
    /**
     * Gets emailId,userName,password and pass into validation for adminSignup.
     *
     * @param emaiId
     * @param userName
     * @param password
     */
    public boolean adminSignUp(final String emailId, final String userName, final String password) {
        return ChatBotValidator.adminSignUp(emailId, userName, password);
    }

    @Override
    /**
     * Gets the userName,password and pass into validation for adminSignIn.
     *
     * @param userName
     * @param password
     */
    public boolean adminSignIn(final String userName, final String password) {
        return ChatBotValidator.adminSignIn(userName, password);
    }

    @Override
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

    @Override
    /**
     * Gets the input and pass into validation for userSignin.
     *
     * @param userName
     * @param password
     */
    public boolean userSignIn(final String userName, final String password) {
        return ChatBotValidator.userSignIn(userName, password);
    }

    @Override
    /**
     * Gets the question for Chating.
     *
     * @ userQuestion
     */
    public void userQuestion(final String userQuestion) {
        USER_CHAT.doChat(userQuestion);
    }
}
