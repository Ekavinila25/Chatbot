package org.example.adminrole.view;

import org.example.adminrole.controller.AdminController;
import org.example.exception.CustomException;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Get input from admin
 */
public class AdminPage {

    private static final AdminController ADMIN_CONTROLLER = new AdminController();
    private static Scanner SCANNER = new Scanner(System.in);
    public static final Logger LOGGER= Logger.getLogger(String.valueOf(AdminPage.class));

    /**
     * Get the admin option.
     */
    public static void adminChoice() {

        System.out.println("Give 1 for add 2 for update 3 for delete 4 for show chat 5 for delete ");

        try {
            final int adminOption = Integer.parseInt(SCANNER.next().trim());

            if (adminOption == 1) {
                AdminPage.addChat();
            } else if (adminOption == 2) {
                AdminPage.updateChat();
            } else if (adminOption == 3) {
                AdminPage.deleteChat();
            } else if (adminOption == 4) {
             AdminPage.viewChat();
            }else if (adminOption == 5) {
                System.exit(0);
            } else {
                LOGGER.info("Please give the number 1 or 2 or 3 or 4 ");
                AdminPage.adminChoice();
            }
        } catch (NumberFormatException e) {
            LOGGER.info("Please give valid input");
            AdminPage.adminChoice();
        }
    }

    /**
     * Gets the question,answer and pass into controller for add the chat.
     */
    private static void addChat() {
        System.out.println("Enter Your question");
        final String question =SCANNER.next().trim();

        System.out.println("Enter Your answer");
        final String answer = SCANNER.next().trim();

        try {

            if (ADMIN_CONTROLLER.addChat(question, answer)) {
                LOGGER.info("Added Successfully");
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
        final int id = Integer.parseInt(SCANNER.next().trim());

        System.out.println("Enter Your question");
        final String question =SCANNER.next().trim();

        System.out.println("Enter Your answer");
        final String answer = SCANNER.next().trim();

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
        final int id = Integer.parseInt(SCANNER.next().trim());

        try {
            if (ADMIN_CONTROLLER.deleteChat(id)) {
                System.out.println("Deleted Successfully");
                AdminPage.adminChoice();
            }
        } catch (CustomException exception) {
            System.out.println(exception);
        }
    }

    /**
     * view the chat.
     */
   private static void viewChat(){

        ADMIN_CONTROLLER.viewChat();
        AdminPage.adminChoice();
   }
}