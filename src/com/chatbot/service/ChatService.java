package com.chatbot.service;

import com.chatbot.dao.AdminDao;
import com.chatbot.dao.DatabaseResult;
import com.chatbot.dao.UserDao;
import com.chatbot.model.ChatBotUser;

/**
 * Get the user input,validate and add into database 
 * 
 * @author KavinilaE
 */
public class ChatService {
	 
   private static final DatabaseResult DATABASE_RESULT = new DatabaseResult();

	/**
	 * Check the emailId,userName,password and add in database
	 * 
	 * @param emailId
	 * @param userName
	 * @param password
	 * @return
	 */
	public static boolean adminSignUp(final ChatBotUser chatBotUser) {

		if (DATABASE_RESULT.adminResult().contains(chatBotUser.getEmailId())) {
			System.out.println("Please give another EmailId");
		} else {
			AdminDao.insertNewAdmin(chatBotUser);
			System.out.println("Welcome! to admin portal");
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
	public static void adminSignIn(final String userName, final String password) {

		if (DATABASE_RESULT.adminResult().contains(userName)) {

			if (DATABASE_RESULT.adminResult().contains(password)) {
				System.out.println("Welcome! You are signed in");
			} else {
				System.out.println("Invalid username and password are not signed in");
			}
		}
	}

	/**
	 * Check the mobileNumber,userName,password and insert into user table.
	 * 
	 * @param mobileNumber
	 * @param userName
	 * @param password
	 * @return
	 */
	public static boolean userSignUp(final String mobileNumber,final String userName,final String password) {

		if (DATABASE_RESULT.userResult().contains(mobileNumber)) {
			System.out.println("Give another mobile number");
		} else {
			UserDao.userSignUp(mobileNumber, userName, password);
			System.out.println("Welcome! You can chat now");
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
	public static void userSignIn(final String userName,final String password) {

		if (DATABASE_RESULT.userResult().contains(userName)) {

			if (DATABASE_RESULT.userResult().contains(password)) {
				System.out.println("welcome! You are signed in");
			} else {
				System.out.println("Invalid you are not signed in");
			}
		}
	}
}
