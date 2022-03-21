package org.example.authentication.view;

import java.util.Scanner;
import java.util.logging.Logger;

import org.example.authentication.controller.ChatbotController;
import org.example.adminrole.view.AdminPage;
import org.example.exception.CustomException;
import org.example.authentication.validation.Validation;

/**
 * Gets the input from the admin.
 */
public class Adminview {

    private static final ChatbotController CHATBOT_CONTROLLER = new ChatbotController();
    private static final Adminview ADMIN_PAGE = new Adminview();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Validation VALIDATION = new Validation();
    private static final Logger logger= Logger.getLogger(String.valueOf(AdminPage.class));

    /**
     * Gets input from the admin for authentication.
     */
    public static void adminAuthentication() {
        System.out.println("1.SignUp 2.Signin 3.Exit");

        try {
            final int adminOption = Integer.parseInt(SCANNER.next().trim());

            if (adminOption == 1) {
                ADMIN_PAGE.adminSignUp();
            } else if (adminOption == 2) {
                ADMIN_PAGE.adminSignIn();
            } else if (adminOption == 3) {
                System.exit(0);
            } else {
                logger.info("Please give valid input");
                Adminview.adminAuthentication();
            }
        } catch (NumberFormatException e) {
            logger.info("Please enter input in number(1 or 2)");
            Adminview.adminAuthentication();
        }
    }

    /**
     * Gets the emailId,userName,password and validate and pass into controller.
     */
    private static void adminSignUp() {
        System.out.println("Enter your emailId");
        final String emailId = Adminview.getMailId();

        System.out.println("Enter your name");
        final String userName = Adminview.getUserName();

        System.out.println("Enter your password");
        final String password = Adminview.getPassword();

        try {
            if (CHATBOT_CONTROLLER.adminSignUp(emailId, userName, password)) {
                logger.info("Please give another emailId");
                Adminview.adminAuthentication();
            } else {
                AdminPage.adminChoice();
            }
        } catch (CustomException exception) {
            System.out.println(exception);
        }
    }

    /**
     * Gets the userName,password and validate pass into controller for signin.
     */
    private static void adminSignIn() {
        System.out.println("Enter Your Username");
        final String userName = SCANNER.next().trim();

        System.out.println("Enter Your Password");
        final String password = SCANNER.next().trim();

        try {
            if (CHATBOT_CONTROLLER.adminSignIn(userName, password)) {
                System.out.println("You are logged in");
                AdminPage.adminChoice();
            } else {
                logger.info("Please give valid username and password or sign up");
                Adminview.adminAuthentication();
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    /**
     * Validates emailId.
     */
    private static String getMailId() {
        final String emailId = SCANNER.next().trim();

        if (!VALIDATION.emailIdValidate(emailId)) {
            System.out.println("Please enter valid emailId");
            return getMailId();
        }
        return emailId;
    }

    /**
     * Validates username.
     */
    private static String getUserName() {
        final String userName = SCANNER.next().trim();

        if (!VALIDATION.userNameValidate(userName)) {
            System.out.println("Please enter valid username");
            return getUserName();
        }
        return userName;
    }

    /**
     * Validates the password.
     */
    private static String getPassword() {
        final String password = SCANNER.next().trim();

        if (!VALIDATION.passwordValidate(password)) {
            System.out.println("Please enter valid password");
            return getPassword();
        }
        return password;
    }
}


