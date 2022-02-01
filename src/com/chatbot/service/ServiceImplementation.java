package com.chatbot.service;

import java.sql.SQLException;

import com.chatbot.dao.AdminDao;
import com.chatbot.dao.DatabaseValidation;
import com.chatbot.dao.UserDao;

public class ServiceImplementation implements Service {
	final AdminDao ADMIN_DAO = new AdminDao();
    final UserDao USER_DAO = new UserDao();

	public void adminSignUp(String emailId, String userName, String password)throws ClassNotFoundException, SQLException {
		boolean emailValidation = DatabaseValidation.isEmailValidate(emailId);
		boolean userNameValidation = DatabaseValidation.isUserNameValidate(userName);
		boolean passwordValidation = DatabaseValidation.isPasswordValidate(password);

		if (emailValidation == false && userNameValidation == false && passwordValidation == false) {
			ADMIN_DAO.adminSignUp(emailId, userName, password);
		}
	}

	public void adminSignIn(String userName, String password) throws ClassNotFoundException, SQLException {
		ADMIN_DAO.adminSignIn(userName, password);
	}

	public void userSignUp(String mobileNumber, String userName, String password)throws ClassNotFoundException, SQLException {
		boolean mobileNumberValidation = DatabaseValidation.isEmailValidate(mobileNumber);
		boolean userNameValidation = DatabaseValidation.isUserNameValidate(userName);
		boolean passwordValidation = DatabaseValidation.isPasswordValidate(password);

		if (mobileNumberValidation == false && userNameValidation == false && passwordValidation == false) {
			USER_DAO.userSignUp(mobileNumber, userName, password);
		}
	}

	public void userSignIn(String userName, String password) throws ClassNotFoundException, SQLException {
		USER_DAO.userSignIn(userName, password);
	}
}
