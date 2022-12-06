package ru.job4j.early;

import static java.lang.Character.*;

public class PasswordValidator {

    private static final String[] EASY_PASSWORD = new String[]{"qwerty", "12345", "password", "admin", "user"};

    public static String validate(String password) {
        String signsCheckResult;
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        signsCheckResult = containsDifferentSigns(password);
        if (signsCheckResult != null) {
            throw new IllegalArgumentException(signsCheckResult);
        }
        if (containsEasySubstring(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
    }

    private static String containsDifferentSigns(String string) {
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasDigit = false;
        boolean hasSymbol = false;
        String result = null;
        for (var i = 0; i < string.length(); i++) {
            var symbol = string.charAt(i);
            if (isDigit(symbol)) {
                hasDigit = true;
            }
            if (isLowerCase(symbol)) {
                hasLowerCase = true;
            }
            if (isUpperCase(symbol)) {
                hasUpperCase = true;
            }
            if (!isDigit(symbol) && !isLetter(symbol)) {
                hasSymbol = true;
            }
        }
        if (!hasLowerCase) {
            result = "Password should contain at least one lowercase letter";
        }
        if (!hasUpperCase) {
            result = "Password should contain at least one uppercase letter";
        }
        if (!hasDigit) {
            result = "Password should contain at least one figure";
        }
        if (!hasSymbol) {
            result = "Password should contain at least one special symbol";
        }
        return result;
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
