package ru.job4j.early;

import static java.lang.Character.*;

public class PasswordValidator {

    private static final String[] EASY_PASSWORD = new String[]{"qwerty", "12345", "password", "admin", "user"};

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (!containsDigit(password)) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!containsLowerCaseLetter(password)) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!containsUpperCaseLetter(password)) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!containsSymbol(password)) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (containsEasySubstring(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
    }

    private static boolean containsDigit(String string) {
        for (var i = 0; i < string.length(); i++) {
            var symbol = string.charAt(i);
            if (isDigit(symbol)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsLowerCaseLetter(String string) {
        for (var i = 0; i < string.length(); i++) {
            var symbol = string.charAt(i);
            if (isLowerCase(symbol)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsUpperCaseLetter(String string) {
        for (var i = 0; i < string.length(); i++) {
            var symbol = string.charAt(i);
            if (isUpperCase(symbol)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsSymbol(String string) {
        for (var i = 0; i < string.length(); i++) {
            var symbol = string.charAt(i);
            if (!isDigit(symbol) && !isLetter(symbol)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsEasySubstring(String string) {
        for (String pass : EASY_PASSWORD) {
            if (string.toLowerCase().contains(pass)) {
                return true;
            }
        }
        return false;
    }
}
