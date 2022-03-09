package org.example.service;

import org.example.dao.UserChat;


/**
 * Gets the question for Chating.
 *
 * @ userQuestion
 */
public class UserServiceImplementation implements UserService {

    private final static UserChat USER_CHAT = new UserChat();

    public void userQuestion(final String userQuestion) {
        USER_CHAT.doChat(userQuestion);
    }
}

