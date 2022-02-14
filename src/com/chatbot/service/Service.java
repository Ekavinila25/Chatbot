package com.chatbot.service;

import com.chatbot.model.ChatBotUser;

public interface Service {
    
    boolean adminSignUp(ChatBotUser chatBotUser);

    boolean adminSignIn(String userName, String password);
    
    boolean userSignUp(String mobilenum, String username, String password);

    boolean userSignIn(String userName, String password);

    void addChat(String question, String answer);

    void updateChat(int id, String question, String answer);

    void deleteChat(int id);

    void userQuestion(String question);

}