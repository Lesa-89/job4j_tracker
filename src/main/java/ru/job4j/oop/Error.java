package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public Error() {
    }

    public void printInfo() {
        System.out.println("Active: " + active);
        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        Error errorFirst = new Error();
        Error errorSecond = new Error(false, 0, "light error");
        Error errorThird = new Error(true, 101, "middle error");
        Error errorFourth = new Error(true, 999, "hard error");
        errorFirst.printInfo();
        errorSecond.printInfo();
        errorThird.printInfo();
        errorFourth.printInfo();
    }
}
