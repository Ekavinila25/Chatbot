package org.example.usersrole.service;

import org.example.usersrole.dao.UserChat;

/**
 * Gets the question for Chating.
 *
 * @ userQuestion
 */
public class UserServiceImplementation implements UserService {

    private final static UserChat USER_CHAT = new UserChat();

    public void userQuestion(final String userQuestion) {
        USER_CHAT.chatResult(userQuestion);
    }
}

