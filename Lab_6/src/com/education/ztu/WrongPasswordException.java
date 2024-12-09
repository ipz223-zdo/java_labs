package com.education.ztu;

public class WrongPasswordException extends Exception{
    public WrongPasswordException() {
        super("Invalid password.");
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
