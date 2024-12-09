package com.education.ztu;

public class CredentialChecker {
    public static boolean checkCredentials(String login, String password, String confirmPassword) {
        try {
            if (!login.matches("[a-zA-Z0-9_]+") || login.length() >= 20) {
                throw new WrongLoginException("Login must contain only latin letters, digits, and underscores, and be less than 20 characters.");
            }

            if (!password.matches("[a-zA-Z0-9_]+") || password.length() >= 20 || !password.equals(confirmPassword)) {
                throw new WrongPasswordException("Password must contain only latin letters, digits, and underscores, be less than 20 characters, and match confirmPassword.");
            }

            return true; // All checks passed
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false; // Invalid credentials
        }
    }
}
