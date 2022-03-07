package org.example;

public class CustomException extends RuntimeException {

    public CustomException(String message) {
        super(message);
    }

    public static class AccessFailedException extends CustomException {

        public AccessFailedException(String message) {
            super(message);
        }
    }

    public static class ConnectionException extends CustomException {

        public ConnectionException(String message) {
            super(message);
        }
    }
}

