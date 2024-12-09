package com.education.ztu;

public class WrongLoginException extends Exception {
    public WrongLoginException() {
        super("Invalid login.");
    }

    public WrongLoginException(String message) {
        super(message);
    }
}
