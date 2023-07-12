package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 150);
        Book javaConcurrency = new Book("Java Concurrency", 500);
        Book effectiveJava = new Book("Effective Java", 600);
        Book headFirstJava = new Book("Head First Java", 800);

        Book[] books = new Book[]{cleanCode, javaConcurrency, effectiveJava, headFirstJava};
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName());
        }

        Book swap = books[0];
        books[0] = books[3];
        books[3] = swap;

        for (Book book : books) {
            System.out.println(book.getName());
        }

        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName());
            }
        }
    }
}
