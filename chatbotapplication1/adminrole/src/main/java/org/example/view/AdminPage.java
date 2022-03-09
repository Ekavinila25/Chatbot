package org.example.view;

import org.example.CustomException;
import org.example.controller.AdminController;

import java.util.Scanner;

public class AdminPage {
    private static final AdminController ADMIN_CONTROLLER = new AdminController();
    static Scanner scanner = new Scanner(System.in);

    public static void adminChoice() {

        System.out.println("Give 1 for add 2 for update 3 for delete 4 for exit ");

        try {
            final int adminOption = Integer.parseInt(scanner.next().trim());

            if (adminOption == 1) {
                AdminPage.addChat();
            } else if (adminOption == 2) {
                AdminPage.updateChat();
            } else if (adminOption == 3) {
                AdminPage.deleteChat();
            } else if (adminOption == 4) {
                System.exit(0);
            } else {
                System.out.println("Please give the number 1 or 2 or 3 or 4 ");
                AdminPage.adminChoice();
            }
        } catch (NumberFormatException e) {
            System.out.println("Please give valid input");
            AdminPage.adminChoice();
        }
    }

    /**
     * Gets the question,answer and pass into controller for add the chat.
     */
    private static void addChat() {
        System.out.println("Enter Your question");
        final String question = scanner.next().trim();

        System.out.println("Enter Your answer");
        final String answer = scanner.next().trim();

        try {

            if (ADMIN_CONTROLLER.addChat(question, answer)) {
                System.out.println("Added Successfully");
                AdminPage.adminChoice();
            }
        } catch (CustomException exception) {
            System.out.println(exception);
        }
    }

    /**
     * Gets the id,question,answer and pass into controller for update the chat.
     */
    private static void updateChat() {
        System.out.println("Enter The Id do you want to update");
        final int id = Integer.parseInt(scanner.next().trim());

        System.out.println("Enter Your question");
        final String question = scanner.next().trim();

        System.out.println("Enter Your answer");
        final String answer = scanner.next().trim();
        try {
            if (ADMIN_CONTROLLER.updateChat(id, question, answer)) {
                System.out.println("Updated Successfully");
                AdminPage.adminChoice();
            }
        } catch (CustomException exception) {
            System.out.println(exception);
        }
    }

    /**
     * Gets the id and pass into controller delete the chat.
     */
    private static void deleteChat() {
        System.out.println("Enter the Id do you want to delete");
        final int id = Integer.parseInt(scanner.next().trim());
        try {
            if (ADMIN_CONTROLLER.deleteChat(id)) {
                System.out.println("Deleted Successfully");
                AdminPage.adminChoice();
            }
        } catch (CustomException exception) {
            System.out.println(exception);
        }
    }
}