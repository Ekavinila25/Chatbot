package org.example;

import java.util.Scanner;
import org.example.controller.ChatbotController;
/**
 * Gets the input from the user.
 *
 * @author KavinilaE
 */
public class UserPage {

    private final ChatbotController CHATBOT_CONTROLLER = new ChatbotController();
    private static final UserPage USER_PAGE = new UserPage();

    /**
     * Gets input from user for authentication.
     */
    public static void userAuthentication() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("1.SignUp 2.Signin 3.Exit");

        try {
            final int userOption = Integer.parseInt(scanner.nextLine().trim());

            if (userOption == 1) {
                USER_PAGE.signUp();
            } else if (userOption == 2) {
                USER_PAGE.signIn();
            }else if(userOption==3){
                System.exit(0);
            } else {
                System.out.println("Please give the valid input ");
                UserPage.userAuthentication();
            }
        } catch (NumberFormatException e) {
            System.out.println("Please give the input in number (1 or 2) ");
            UserPage.userAuthentication();
        }
    }

    /**
     * Gets the mobileNum,userName,password and validate and pass into controller.
     */
    private void signUp() {
        System.out.println("Enter your mobilenumber");
        final String mobileNumber = USER_PAGE.getMobileNumber();

        System.out.println("Enter your username");
        final String userName = USER_PAGE.getUserName();

        System.out.println("Enter Your password");
        final String password = USER_PAGE.getPassword();

        if (CHATBOT_CONTROLLER.userSignUp(mobileNumber, userName, password)) {
            System.out.println("Please give another mobilenumber");
            UserPage.userAuthentication();
        } else {
            System.out.println("Welcome You can chat now");
            USER_PAGE.userChat();
        }
    }

    /**
     * Validates the mobile number.
     */
    private String getMobileNumber() {
        final String mobileNumber = ChatBot.SCANNER.next().trim();

        if (!chatvalidation.mobileNumberValidate(mobileNumber)) {
            System.out.println("Please enter valid mobilenumber");
            return getMobileNumber();
        }
        return mobileNumber;
    }

    /**
     * Validates the username.
     *
     */
    private String getUserName() {
        final String userName = ChatBot.SCANNER.next().trim();

        if (!chatvalidation.userNameValidate(userName)) {
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
        final String password = ChatBot.SCANNER.next().trim();

        if (!chatvalidation.passwordValidate(password)) {
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
        final String userName = ChatBot.SCANNER.next().trim();

        System.out.println("Please Enter The Password");
        final String password = ChatBot.SCANNER.next().trim();

        if (CHATBOT_CONTROLLER.userSignIn(userName, password)) {
            System.out.println("welcome You can chat now");
            userChat();
        } else {
            System.out.println("Please give correct username and password");
            UserPage.userAuthentication();
        }
    }

    /**
     * Gets the question from user and pass into controller.
     */
    private void userChat() {

        while (true) {
            final String userQuestion = ChatBot.SCANNER.next().trim();
            CHATBOT_CONTROLLER.userChat(userQuestion);
        }
    }
}
