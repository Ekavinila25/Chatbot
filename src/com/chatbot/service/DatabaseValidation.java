package com.chatbot.service;

import com.chatbot.dao.AdminDao;
import com.chatbot.dao.DatabaseResult;
import com.chatbot.dao.UserDao;

/**
 * Get the user input validate and add into database 
 * @author KavinilaE
 *
 */
public class DatabaseValidation {
	private static final DatabaseResult DATABASE_RESULT = new DatabaseResult();

	/**
	 * Check the emailId,userName,password check and add into database
	 * 
	 * @param emailId
	 * @param userName
	 * @param password
	 * @return
	 */
	public static boolean adminSignUp(final String emailId,final String userName, final String password) {

		if (DATABASE_RESULT.adminResult().contains(emailId)) {
			System.out.println("EMAIL ID INVALID");
		} else {
			AdminDao.adminSignUp(emailId, userName, password);
			System.out.println("inserted successfully");
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
				System.out.println("welcome you are signed in");
			} else {
				System.out.println("invalid you are not signed in");
			}
		}
	}

	/**
	 * Validate the mobileNumber,userName,password validate and insert into user table
	 * 
	 * @param mobileNumber
	 * @param userName
	 * @param password
	 * @return
	 */
	public static boolean userSignUp(final String mobileNumber,final String userName,final String password) {

		if (DATABASE_RESULT.userResult().contains(mobileNumber)) {
			System.out.println("give another mobile number");
		} else {
			UserDao.userSignUp(mobileNumber, userName, password);
			System.out.println("Login successfully");
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
				System.out.println("welcome u are signed in");
			} else {
				System.out.println("invalid u are not signed in");
			}
		}
	}
}
