package com.chatbot.model;

public class UserChat {
    
    private String question;
    private String answer;

    public UserChat(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public UserChat() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
