package org.example.controlller;

import org.example.service.UserServiceImplementation;

/**
 * Gets the user question and pass into the controller
 */
public class UserController {

    private final UserServiceImplementation USER_SERVICE_IMPLEMETATION = new UserServiceImplementation();

    public void userChat(final String userQuestion) {
        USER_SERVICE_IMPLEMETATION.userQuestion(userQuestion);
    }
}
