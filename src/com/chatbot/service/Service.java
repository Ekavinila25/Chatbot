package com.chatbot.service;

public interface Service {
    
    boolean adminSignUp(final String emailId,final String userName,final String password);

    boolean adminSignIn(final String userName,final String password);
    
    boolean userSignUp(final String mobilenum,final String username,final String password);

    boolean userSignIn(final String userName,final String password);

    void addChat(final String question,final String answer);

    void updateChat(final int id,final String question,final String answer);

    void deleteChat(final int id);

    void userQuestion(final String question);

}