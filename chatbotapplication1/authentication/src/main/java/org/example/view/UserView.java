package org.example.view;

import org.example.CustomException;
import org.example.validation.Validation;
import org.example.controller.ChatbotController;

import java.util.Scanner;

/**
 * Gets the input from user
 */
public class UserView {

    private final ChatbotController CHATBOT_CONTROLLER = new ChatbotController();
    private static final UserView USER_View = new UserView();
    private static final UserPage USER_PAGE = new UserPage();
    private static final Validation VALIDATION = new Validation();
    private static Scanner SCANNER = new Scanner(System.in);

    /**
     * Gets input from user for authentication.
     */
    public static void userAuthentication() {
        System.out.println("1.SignUp 2.Signin 3.Exit");

        try {
            final int userOption = Integer.parseInt(SCANNER.nextLine().trim());

            if (userOption == 1) {
                USER_View.signUp();
            } else if (userOption == 2) {
                USER_View.signIn();
            } else if (userOption == 3) {
                System.exit(0);
            } else {
                System.out.println("Please give the valid input ");
                USER_View.userAuthentication();
            }
        } catch (NumberFormatException e) {
            System.out.println("Please give the input in number (1 or 2) ");
            USER_View.userAuthentication();
        }
    }

    /**
     * Gets the mobileNum,userName,password and validate and pass into controller.
     */
    private void signUp() {
        System.out.println("Enter your mobilenumber");
        final String mobileNumber = USER_View.getMobileNumber();

        System.out.println("Enter your username");
        final String userName = USER_View.getUserName();

        System.out.println("Enter Your password");
        final String password = USER_View.getPassword();

        try {
            if (CHATBOT_CONTROLLER.userSignUp(mobileNumber, userName, password)) {
                System.out.println("Please give another mobilenumber");
                USER_View.userAuthentication();
            } else {
                System.out.println("Welcome You can chat now");
                USER_PAGE.userChat();
            }
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    /**
     * Validates the mobile number.
     */
    private String getMobileNumber() {
        final String mobileNumber = SCANNER.next().trim();

        if (!VALIDATION.mobileNumberValidate(mobileNumber)) {
            System.out.println("Please enter valid mobilenumber");
            return getMobileNumber();
        }
        return mobileNumber;
    }

    /**
     * Validates the username.
     */
    private String getUserName() {
        final String userName = SCANNER.next().trim();

        if (!VALIDATION.userNameValidate(userName)) {
            System.out.println("Please enter username");
            return getUserName();
        }
        return userName;
    }

    /**
     * Validates the password.
     *
     * @return
     */
    private String getPassword() {
        final String password = SCANNER.next().trim();

        if (!VALIDATION.passwordValidate(password)) {
            System.out.println("Please enter valid password");
            return getPassword();
        }
        return password;
    }

    /**
     * Gets userName and password from user pass into controller for signin.
     */
    private void signIn() {
        System.out.println("Please Enter The Username");
        final String userName = SCANNER.next().trim();

        System.out.println("Please Enter The Password");
        final String password = SCANNER.next().trim();

        try {
            if (CHATBOT_CONTROLLER.userSignIn(userName, password)) {
                System.out.println("welcome You can chat now");
                USER_PAGE.userChat();
            } else {
                System.out.println("Please give correct username and password");
                UserView.userAuthentication();
            }
        } catch (CustomException e) {
            System.out.println(e);
        }
    }
}
