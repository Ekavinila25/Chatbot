package org.example.service;

import org.example.dao.AdminCrud;
import org.osgi.service.component.annotations.Component;

/**
 * Gets the input and pass for validation.
 *
 * @author KavinilaE
 */
@Component
public class AdminServiceImplementation implements Service {

    private final static AdminCrud ADMIN_CRUD = new AdminCrud();

    /**
     * Gets question, answer and pass into addChat.
     *
     * @param question
     * @param answer
     */
    public boolean addChat(final String question, final String answer) {
        return ADMIN_CRUD.addChat(question, answer);
    }

    /**
     * Gets id, question, answer and pass into updateChat.
     *
     * @param id
     * @param question
     * @param answer
     */
    public boolean updateChat(final int id, final String question, final String answer) {
        return ADMIN_CRUD.updateChat(id, question, answer);
    }

    /**
     * Gets the id and pass for delete
     *
     * @param id
     */
    public boolean deleteChat(final int id) {
        return ADMIN_CRUD.deleteChat(id);
    }
}
