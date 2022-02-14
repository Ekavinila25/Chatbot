package com.chatbot.service;

import org.apache.log4j.Logger;

import com.chatbot.dao.AdminDao;
import com.chatbot.dao.DatabaseResult;
import com.chatbot.dao.UserDao;
import com.chatbot.main.ChatBot;

/**
 * Get the user input,validate and add into database
 * 
 * @author KavinilaE
 */
public class ChatService {

    private static final DatabaseResult DATABASE_RESULT = new DatabaseResult();
    private static final Logger LOGGER = Logger.getLogger(ChatBot.class);

    /**
     * Check the emailId,userName,password and add in database
     * 
     * @param chatBotUser
     * @return
     */
    public static boolean adminSignUp(final String emailId,final String userName,final String password) {

        if (DATABASE_RESULT.adminResult().contains(emailId)) {
            LOGGER.info("Please give another EmailId");
        } else {
            AdminDao.insertNewAdmin(emailId, userName, password);
            LOGGER.info("Welcome! to admin portal");
            return true;
        }
        return false;
    }

    /**
     * Check the userName and password and get singIn
     * 
     * @param userName
     * @param password
     */
    public static boolean adminSignIn(final String userName, final String password) {

        if (DATABASE_RESULT.adminResult().contains(userName)) {

            if (DATABASE_RESULT.adminResult().contains(password)) {
                LOGGER.info("Welcome! You are signed in");
                return true;
            } else {
                LOGGER.info("Invalid username and password are not signed in");
            }
        }
        return false;
    }

    /**
     * Check the mobileNumber,userName,password and insert into user table.
     * 
     * @param mobileNumber
     * @param userName
     * @param password
     * @return
     */
    public static boolean userSignUp(final String mobileNumber, final String userName, final String password) {

        if (DATABASE_RESULT.userResult().contains(mobileNumber)) {
            LOGGER.info("Give another mobile number");
        } else {
            UserDao.userSignUp(mobileNumber, userName, password);
            LOGGER.info("Welcome! You can chat now");
            return true;
        }
        return false;
    }

    /**
     * Check the userName and password and sign in
     * 
     * @param userName
     * @param password
     */
    public static boolean userSignIn(final String userName, final String password) {

        if (DATABASE_RESULT.userResult().contains(userName)) {

            if (DATABASE_RESULT.userResult().contains(password)) {
                LOGGER.info("welcome! You are signed in");
                return true;
            } else {
                LOGGER.info("Invalid you are not signed in");
            }
        }
        return false;
    }
}
