package org.example.adminrole.service;

import org.example.adminrole.dao.AdminRole;
import org.example.adminrole.exception.InsertionFailedException;
import org.example.adminrole.exception.UpdationFailedException;
import org.example.adminrole.exception.DeletionFailedException;
import org.example.adminrole.model.Conversation;

import java.util.ArrayList;
import java.util.List;

/**
 * Gets the input and pass for validation.
 *
 * @author KavinilaE
 */
public class AdminServiceImplementation implements AdminService {

    private final static AdminRole ADMIN_ROLE = new AdminRole();

    /**
     * Gets question, answer and pass into addChat.
     *
     * @param question
     * @param answer
     */
    public boolean addChat(final String question, final String answer) {

        try {
            return ADMIN_ROLE.addChat(question, answer);
        } catch (Exception exception) {
            throw new InsertionFailedException("insertion failed");

        }
    }

    /**
     * Gets id, question, answer and pass into updateChat.
     *
     * @param id
     * @param question
     * @param answer
     */
    public boolean updateChat(final int id, final String question, final String answer) {

        try {
            return ADMIN_ROLE.updateChat(id, question, answer);
        } catch (Exception exception) {
            throw new UpdationFailedException("updation failed");
        }
    }

    /**
     * Gets the id and pass for delete.
     * @param id
     */
    public boolean deleteChat(final int id) {

        try {
            return ADMIN_ROLE.deleteChat(id);
        } catch (Exception exception) {
            throw new DeletionFailedException("Deletion failed");
        }
    }

    /**
     * Used for viewChat.
     */
    public List<Conversation> viewChat() {
        return new ArrayList<Conversation>(ADMIN_ROLE.viewChat());
    }
}
