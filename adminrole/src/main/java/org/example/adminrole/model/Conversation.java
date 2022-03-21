package org.example.adminrole.model;

public class Conversation {

    private int id;
    private String question;
    private String answer;
    public Conversation() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String toString() {
        return "prject [id=" + id + ", question=" + question + ", answer=" + answer + "]";
    }
}

