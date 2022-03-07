package org.example.service;

public interface Service {

    boolean addChat(final String question, final String answer);

    boolean updateChat(final int id, final String question, final String answer);

    boolean deleteChat(final int id);
}
