package org.example.exception;

import org.example.CustomException;

public class LoginFailedException extends CustomException{

    public LoginFailedException(String message) {
            super(message);
        }
    }


