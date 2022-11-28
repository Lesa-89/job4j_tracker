package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book first = new Book("Head First Java", 500);
        Book second = new Book("Clean code", 350);
        Book third = new Book("Дюна", 800);
        Book fourth = new Book("Java. Полное руководство", 2000);
        Book[] books = new Book[4];
        books[0] = first;
        books[1] = second;
        books[2] = third;
        books[3] = fourth;
        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName() + " - " + books[index].getPageCount());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getPageCount());
        }
        for (Book book : books) {
            if (book.getName().equals("Clean code")) {
                System.out.println(book.getName() + " - " + book.getPageCount());
            }
        }
    }
}
