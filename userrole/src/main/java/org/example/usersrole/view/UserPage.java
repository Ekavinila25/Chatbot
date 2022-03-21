package org.example.usersrole.view;

import org.example.usersrole.controlller.UserController;

import java.util.Scanner;

/**
 * Gets the question from user.
 */
public class UserPage {

    private final Scanner SCANNER = new Scanner(System.in);
    private final UserController USERCONTROLLER = new UserController();

    public void userChat() {

        while (true) {
            final String userQuestion = SCANNER.nextLine().trim();
            USERCONTROLLER.userChat(userQuestion);
        }
    }
}
