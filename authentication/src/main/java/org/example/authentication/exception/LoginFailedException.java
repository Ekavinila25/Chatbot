package org.example.authentication.exception;

import org.example.exception.CustomException;

public class LoginFailedException extends CustomException{

    public LoginFailedException(String message) {
            super(message);
        }
    }


