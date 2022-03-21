package org.example.adminrole.controller;

import org.example.adminrole.model.Conversation;

import java.util.List;

public interface ApiInterface {

    boolean addChat(final String question, final String answer);

    boolean updateChat(final int id, final String question, final String answer);

    boolean deleteChat(final int id);

    List<Conversation> viewChat();
}
