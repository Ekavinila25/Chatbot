package org.example.exception;

import org.example.CustomException;

public class InsertionFailedException extends CustomException {

    public InsertionFailedException(String message) {
        super(message);
    }
}

