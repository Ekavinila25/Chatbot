package com.chatbot.view;

/**
 * Check the user input is valid or not.
 * 
 * @author KavinilaE
 */
public class Validation {

     /**
     * Validate the EmailId.
     * 
     * @param emailId
     * @return
     */
    public static boolean emailIdValidation(final String emailId) {

        if (!emailId.matches("^[A-Za-z0-9+_.-]+@[a-z]+.[a-z]{2,3}$")) {
            return false;
        }
        return true;
    }

    /**
     * Validate the userName.
     * 
     * @param userName
     * @return
     */
    public static boolean userNameValidation(final String userName) {

        if (!(userName.matches("^[a-z\\sa-z]*$"))) {
            return false;
        }
        return true;
    }

    /**
     * Validate the password.
     * 
     * @param password
     * @return
     */
    public static boolean passwordValidation(final String password) {

        if (!(password.matches(".*[a-z]{1,}.*") && password.matches(".*[A-Z]{1,}.*")
                && password.matches(".*[0-9]{1,}.*") && password.matches(".*[@#$()!~%^&|*?.,]{1,}.*"))) {
            return false;
        }
        return true;
    }

    /**
     * Validate the mobileNumber.
     * 
     * @param mobileNumber
     * @return
     */
    public static boolean mobileNumberValidation(final String mobileNumber) {

        if (!mobileNumber.matches("[6-9]{1}[0-9]{9}")) {
            return false;
        }
        return true;

    }
}