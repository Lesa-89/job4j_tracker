package ru.job4j.ex;

public class UserInvalidException extends  UserNotFoundException {
    public UserInvalidException(String message) {
        super(message);
        System.out.println("This user is not valid");
    }
}
