package org.example.controller;

import org.example.service.AdminServiceImplementation;

/**
 * Gets and pass the parameters into related implementation
 */
public class AdminController {

    private static final AdminServiceImplementation ADMIN_SERVICE_IMPLEMENTATION = new AdminServiceImplementation();

    public boolean addChat(final String question, final String answer) {
        return ADMIN_SERVICE_IMPLEMENTATION.addChat(question, answer);
    }

    public boolean updateChat(final int id, final String question, final String answer) {
        return ADMIN_SERVICE_IMPLEMENTATION.updateChat(id, question, answer);
    }

    public boolean deleteChat(final int id) {
        return ADMIN_SERVICE_IMPLEMENTATION.deleteChat(id);
    }
}
