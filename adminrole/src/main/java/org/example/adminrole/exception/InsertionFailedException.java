package org.example.adminrole.exception;

import org.example.exception.CustomException;

public class InsertionFailedException extends CustomException {

    public InsertionFailedException(String message) {
        super(message);
    }
}

