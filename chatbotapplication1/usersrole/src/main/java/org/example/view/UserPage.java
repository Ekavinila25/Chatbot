package org.example.view;

import org.example.controlller.UserController;

import java.util.Scanner;

/**
 * Gets the question from user.
 */
public class UserPage {

    private final Scanner SCANNER = new Scanner(System.in);
    private final UserController USERCONTROLLER = new UserController();

    protected void userChat() {

        while (true) {
            final String userQuestion = SCANNER.next().trim();
            USERCONTROLLER.userChat(userQuestion);
        }
    }
}
