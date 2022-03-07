package org.example.service;

import org.example.dao.*;

/**
 * Gets the user input,validate and add into database.
 *
 * @author KavinilaE
 */
public class ChatBotValidator {

    private static final DatabaseResult DATABASE_RESULT = new DatabaseResult();

    /**
     * Checks the emailId already present or not for adminsignup.
     *
     * @param emailId
     * @param userName
     * @param password
     */
    public static boolean adminSignUp(final String emailId, final String userName, final String password) {

        if (DATABASE_RESULT.adminResult().contains(emailId)) {
            return true;
        } else {
            AdminDao.insertNewAdmin(emailId, userName, password);
        }
        return false;
    }

    /**
     * Checks the username and password is already present or not for adminsignin.
     *
     * @param userName
     * @param password
     */
    public static boolean adminSignIn(final String userName, final String password) {

        if (DATABASE_RESULT.adminResult().contains(userName)) {

            if (DATABASE_RESULT.adminResult().contains(password)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks the mobile number already present or not for usersignup.
     *
     * @param mobileNumber
     * @param userName
     * @param password
     */
    public static boolean userSignUp(final String mobileNumber, final String userName, final String password) {

        if (DATABASE_RESULT.userResult().contains(mobileNumber)) {
            return true;
        } else {
            UserDao.userSignUp(mobileNumber, userName, password);
        }
        return false;
    }

    /**
     * Checks the username and password is already present or not for usersignin.
     *
     * @param userName
     * @param password
     */
    public static boolean userSignIn(final String userName, final String password) {

        if (DATABASE_RESULT.userResult().contains(userName)) {

            if (DATABASE_RESULT.userResult().contains(password)) {
                return true;
            }
        }
        return false;
    }
}
