package org.example.controlller;

import org.example.service.UserServiceImplementation;
import org.osgi.service.component.annotations.Reference;

public class UserController {

    @Reference
    UserServiceImplementation userServiceImplementation;

    public void userChat(final String userQuestion) {
        userServiceImplementation.userQuestion(userQuestion);
    }
}
