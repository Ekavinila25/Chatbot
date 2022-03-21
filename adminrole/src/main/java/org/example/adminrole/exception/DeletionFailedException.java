package org.example.adminrole.exception;

import org.example.exception.CustomException;

public class DeletionFailedException extends CustomException {

    public DeletionFailedException(String message) {
        super(message);
    }
}
