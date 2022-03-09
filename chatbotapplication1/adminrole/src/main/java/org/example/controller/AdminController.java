package org.example.controller;

import org.example.service.AdminServiceImplementation;

/**
 * Gets and pass the parameters into related implementation
 */
public class AdminController {

    private final AdminServiceImplementation admin_Service_Implementation=new AdminServiceImplementation();

    public boolean addChat(final String question, final String answer) {
        return admin_Service_Implementation.addChat(question, answer);
    }

    public boolean updateChat(final int id, final String question, final String answer) {
        return admin_Service_Implementation.updateChat(id, question, answer);
    }

    public boolean deleteChat(final int id) {
        return admin_Service_Implementation.deleteChat(id);
    }
}
