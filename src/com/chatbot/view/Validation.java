package com.chatbot.view;

import org.apache.log4j.Logger;

import com.chatbot.main.ChatBot;

/**
 * Check the user input is valid or not.
 * 
 * @author KavinilaE
 */
public class Validation {
    
    private static final Logger LOGGER = Logger.getLogger(Validation.class);
	
    /**
	 * Validate the EmailId.
	 * 
	 * @param emailId
	 * @return
	 */
	public static String emailIdValidation(String emailId) {

		if (!emailId.matches("^[A-Za-z0-9+_.-]+@[a-z]+.[a-z]{2,3}$")) {
		    LOGGER.info("Please Enter Valid Email Id:");
			emailId = ChatBot.SCANNER.nextLine();

			emailIdValidation(emailId);
		}
		return emailId;
	}

	/**
	 * Validate the userName.
	 * 
	 * @param userName
	 * @return
	 */
	public static String userNameValidation(String userName) {

		if (!(userName.matches("^[a-z\\sa-z]*$"))) {
		    LOGGER.info("Please Enter Valid Username:");
			userName = ChatBot.SCANNER.nextLine();

			userNameValidation(userName);
		}
		return userName;
	}

	/**
	 * Validate the password.
	 * 
	 * @param password
	 * @return
	 */
	public static String passwordValidation(String password) {

		if (!(password.matches(".*[a-z]{1,}.*") && password.matches(".*[A-Z]{1,}.*") && password.matches(".*[0-9]{1,}.*")
				&& password.matches(".*[@#$()!~%^&|*?.,]{1,}.*"))) {
		    LOGGER.info("Please Give Strong Password");
			password = ChatBot.SCANNER.nextLine();

			passwordValidation(password);
		}
		return password;
	}

	/**
	 * Validate the mobileNumber.
	 * 
	 * @param mobileNumber
	 * @return
	 */
	public static String mobileNumberValidation(String mobileNumber) {

		if (!mobileNumber.matches("[6-9]{1}[0-9]{9}")) {
		    LOGGER.info("Please Enter Valid Phone Number");
			mobileNumber = ChatBot.SCANNER.nextLine();

			passwordValidation(mobileNumber);
		}
		return mobileNumber;
	}
}