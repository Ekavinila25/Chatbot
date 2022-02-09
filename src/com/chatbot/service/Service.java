package com.chatbot.service;

import com.chatbot.model.ChatBotUser;

public interface Service {
    
    boolean adminSignUp(ChatBotUser chatBotUser);

    void adminSignIn(String userName, String password);

    void addChat(String question, String answer);

    void updateChat(int id, String question, String answer);

    void deleteChat(int id);

    boolean userSignUp(String mobilenum, String username, String password);

    void userSignIn(String userName, String password);

    void userQuestion(String question);

}