package com.launchclub.service;

/**
 * Gives service for database.
 *
 * @author KavinilaE
 */
public interface Service {

    boolean adminSignUp(final String emailId, final String userName, final String password);

    boolean adminSignIn(final String userName, final String password);

    boolean userSignUp(final String mobilenum, final String username, final String password);

    boolean userSignIn(final String userName, final String password);

    boolean addChat(final String question, final String answer);

    boolean updateChat(final int id, final String question, final String answer);

    boolean deleteChat(final int id);

    void userQuestion(final String userQuestion);

}