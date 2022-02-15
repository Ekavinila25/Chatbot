package com.chatbot.service;

import com.chatbot.dao.AdminDao;
import com.chatbot.dao.UserDao;

/**
 * Gets the input and pass for validation.
 * 
 * @author KavinilaE
 */
public class ChatBotServiceImplementation implements Service {

    private final static AdminDao ADMIN_DAO = new AdminDao();
    private final static UserDao USER_DAO = new UserDao();
    
    @Override
    /**
     * Gets emailId,userName,password and pass into validation for adminSignup.
     * 
     * @param emaiId
     * @param userName
     * @param password
     */
    public boolean adminSignUp(final String emailId, final String userName, final String password) {
        return ChatBotValidator.adminSignUp(emailId, userName, password);
    }
    
    @Override
    /**
     * Gets the userName,password and pass into validation for adminSignIn.
     * 
     * @param userName
     * @param password
     */
    public boolean adminSignIn(final String userName, final String password) {
        return ChatBotValidator.adminSignIn(userName, password);
    }
    
    @Override
    /**
     * Gets the input and pass into validation for userSignup.
     * 
     * @param mobileNumber
     * @param userName
     * @param password
     */
    public boolean userSignUp(final String mobileNumber, final String userName, final String password) {
        return ChatBotValidator.userSignUp(mobileNumber, userName, password);
    }
    
    @Override
    /**
     * Gets the input and pass into validation for userSignin.
     * 
     * @param userName
     * @param password
     */
    public boolean userSignIn(final String userName, final String password) {
        return ChatBotValidator.userSignIn(userName, password);
    }
    
    @Override
    /**
     * Gets question, answer and pass into addChat.
     * 
     * @param question
     * @param answer
     */
    public boolean addChat(final String question, final String answer) {
        return ADMIN_DAO.addChat(question, answer);
    }
    
    @Override
    /**
     * Gets id, question, answer and pass into updateChat.
     * 
     * @param id
     * @param question
     * @param answer
     */
    public boolean updateChat(final int id, final String question, final String answer) {
        return ADMIN_DAO.updateChat(id, question, answer);
    }
    
    @Override
    /**
     * Gets the id and pass for delete
     * 
     * @param id
     */
    public boolean deleteChat(final int id) {
        return ADMIN_DAO.deleteChat(id);
    }
    
    @Override
    /**
     * Gets the question for Chating.
     * @return 
     * 
     * @ userQuestion
     */
    public void userQuestion(final String userQuestion) {
         USER_DAO.doChat(userQuestion);
    }
}
