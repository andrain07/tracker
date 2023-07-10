package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book();
        cleanCode.setName("Clean code");
        cleanCode.setPages(150);

        Book javaConcurrency = new Book();
        javaConcurrency.setName("Java Concurrency");
        javaConcurrency.setPages(500);

        Book effectiveJava = new Book();
        effectiveJava.setName("Effective Java");
        effectiveJava.setPages(600);

        Book headFirstJava = new Book();
        headFirstJava.setName("Head First Java");
        headFirstJava.setPages(800);

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
            if (book.getName().equals("Clean code")) {
                System.out.println(book.getName());
            }
        }
    }
}
