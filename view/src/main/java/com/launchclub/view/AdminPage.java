package com.launchclub.view;


import com.launchclub.controller.ChatBotController;

/**
 * Gets the input from the admin and pass into controller.
 *
 * @author KavinilaE
 */
public class AdminPage {

    private final static ChatBotController CHATBOT_CONTROLLER = new ChatBotController();

    /**
     * Gets input from the admin for authentication.
     */
    public static void adminAuthentication() {
        final AdminPage admin = new AdminPage();
        System.out.println("1.SignUp 2.Signin");

        try {
            final int adminOption = Integer.parseInt(ChatBot.SCANNER.nextLine().trim());

            if (adminOption == 1) {
                admin.adminSignUp();
            } else if (adminOption == 2) {
                admin.adminSignIn();
            } else {
                System.out.println("Please give valid input");
                AdminPage.adminAuthentication();
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter input in number(1 or 2)");
            AdminPage.adminAuthentication();
        }
    }

    /**
     * Gets the emailId,userName,password and validate and pass into controller.
     */
    private void adminSignUp() {
        System.out.println("Enter your emailId");
        final String emailId = AdminPage.getMailId();

        System.out.println("Enter your name");
        final String userName = AdminPage.getUserName();

        System.out.println("Enter your password");
        final String password = AdminPage.getPassword();

        if (CHATBOT_CONTROLLER.adminSignUp(emailId, userName, password)) {
            System.out.println("Please give another emailId");
            AdminPage.adminAuthentication();
        } else {
            AdminPage.adminAuthentication();
        }
    }

    /**
     * Gets the userName,password and validate pass into controller for signin.
     */
    private void adminSignIn() {
        System.out.println("Enter Your Username");
        final String userName = ChatBot.SCANNER.nextLine().trim();

        System.out.println("Enter Your Password");
        final String password = ChatBot.SCANNER.nextLine().trim();

        if (CHATBOT_CONTROLLER.adminSignIn(userName, password)) {
            System.out.println("You are logged in");
            AdminPage.adminChoice();
        } else {
            System.out.println("Please give valid username and password or sign up");
            AdminPage.adminAuthentication();
        }
    }

    /**
     * Validates emailId.
     */
    private static String getMailId() {
        final String emailId = ChatBot.SCANNER.nextLine().trim();

        if (!Validator.emailIdValidate(emailId)) {
            System.out.println("Please enter valid emailId");
            return getMailId();
        }
        return emailId;
    }

    /**
     * Validates username.
     */
    private static String getUserName() {
        final String userName = ChatBot.SCANNER.nextLine().trim();

        if (!Validator.userNameValidate(userName)) {
            System.out.println("Please enter valid username");
            return getUserName();
        }
        return userName;
    }

    /**
     * Validates the password.
     */
    private static String getPassword() {
        final String password = ChatBot.SCANNER.nextLine().trim();

        if (!Validator.passwordValidate(password)) {
            System.out.println("Please enter valid password");
            return getPassword();
        }
        return password;
    }

    /**
     * Gets the Admin choice for add,update and delete.
     */
    private static void adminChoice() {
        System.out.println("Give 1 for add 2 for update 3 for delete 4 for exit ");

        try {
            final int adminOption = Integer.parseInt(ChatBot.SCANNER.nextLine().trim());

            if (adminOption == 1) {
                AdminPage.addChat();
            } else if (adminOption == 2) {
                AdminPage.updateChat();
            } else if (adminOption == 3) {
                AdminPage.deleteChat();
            } else if (adminOption == 4) {
                ChatBot.userInput();
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
        final String question = ChatBot.SCANNER.nextLine().trim();

        System.out.println("Enter Your answer");
        final String answer = ChatBot.SCANNER.nextLine().trim();

        if (CHATBOT_CONTROLLER.addChat(question, answer)) {
            System.out.println("Added Successfully");
            AdminPage.adminChoice();
        }
    }

    /**
     * Gets the id,question,answer and pass into controller for update the chat.
     */
    private static void updateChat() {
        System.out.println("Enter The Id do you want to update");
        final int id = Integer.parseInt(ChatBot.SCANNER.nextLine().trim());

        System.out.println("Enter Your question");
        final String question = ChatBot.SCANNER.nextLine().trim();

        System.out.println("Enter Your answer");
        final String answer = ChatBot.SCANNER.nextLine().trim();

        if (CHATBOT_CONTROLLER.updateChat(id, question, answer))
            System.out.println("Updated Successfully");
        AdminPage.adminChoice();
    }

    /**
     * Gets the id and pass into controller delete the chat.
     */
    private static void deleteChat() {
        System.out.println("Enter the Id do you want to delete");
        final int id = Integer.parseInt(ChatBot.SCANNER.nextLine().trim());

        if (CHATBOT_CONTROLLER.deleteChat(id))
            System.out.println("Deleted Successfully");
        AdminPage.adminChoice();
    }
}
