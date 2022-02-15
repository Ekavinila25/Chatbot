package com.chatbot.view;

/**
 * Checks the user input is valid or not.
 * 
 * @author KavinilaE
 */
public class Validator {

    /**
     * Validates the EmailId.
     * 
     * @param emailId
     * @return
     */
    public static boolean emailIdValidate(final String emailId) {

        return emailId.matches("^[A-Za-z0-9+_.-]+@[a-z]{1,}+.[a-z]{2,3}$") ? true : false;
    }

    /**
     * Validates the userName.
     * 
     * @param userName
     * @return
     */
    public static boolean userNameValidate(final String userName) {
        return userName.matches("^[a-z\\sa-z]*$") ? true : false;
    }

    /**
     * Validates the password.
     * 
     * @param password
     * @return
     */
    public static boolean passwordValidate(final String password) {
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$") ? true : false;
    }

    /**
     * Validates the mobileNumber.
     * 
     * @param mobileNumber
     * @return
     */
    public static boolean mobileNumberValidate(final String mobileNumber) {
        return mobileNumber.matches("[6-9]{1}[0-9]{9}") ? true : false;
    }
}