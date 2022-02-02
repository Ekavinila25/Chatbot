package com.chatbot.view;

public class Validation {

	public static String emailIdValidation(String emailId) {

		if (!emailId.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
			System.out.println("Please Enter Valid Email Id:");
			emailId = ChatBot.SCANNER.next();

			emailIdValidation(emailId);
			
		}
		return emailId;
	}

	public static String userNameValidation(String userName) {

		if (!userName.matches("[A-Za-z\\s]*$")) {
			System.out.println("Please Enter Valid Username:");
			userName = ChatBot.SCANNER.next();

			userNameValidation(userName);
		}
		return userName;
	}

	public static String passwordValidation(String password) {

		if (!password.matches(".*[a-z]{1,}.*") && password.matches(".*[A-Z]{1,}.*")
				&& password.matches(".*[0-9]{1,}.*") && password.matches(".*[@#$()!~%^&|*?.,]{1,}.*")) {
			System.out.println("Please Give Strong Password");
			password = ChatBot.SCANNER.next();

			passwordValidation(password);
		}
		return password;
	}

	public static String mobileNumberValidation(String mobileNumber) {

		if (!mobileNumber.matches("[6-9]{1}[0-9]{9}")) {
			System.out.println("Please Enter Valid Phone Number");
			mobileNumber = ChatBot.SCANNER.next();

			passwordValidation(mobileNumber);
		}
		return mobileNumber;
	}
}