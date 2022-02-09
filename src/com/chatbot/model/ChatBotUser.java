package com.chatbot.model;

public class ChatBotUser {
    private String emailId;
    private String userName;
    private String password;

    public ChatBotUser(String emailId, String userName, String password) {
        this.emailId = emailId;
        this.userName = userName;
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
