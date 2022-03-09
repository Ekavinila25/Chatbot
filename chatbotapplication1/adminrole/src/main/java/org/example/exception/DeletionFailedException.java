package org.example.exception;

import org.example.CustomException;

public class DeletionFailedException extends CustomException {

    public DeletionFailedException(String message) {
        super(message);
    }
}
