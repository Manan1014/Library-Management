package com.example.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddBook {

    private List<book> books = new ArrayList<>();

    public void addBook() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter book ID:");
        String id = sc.nextLine();

        System.out.println("Enter book title:");
        String title = sc.nextLine();

        System.out.println("Enter book author:");
        String author = sc.nextLine();

        System.out.println("Enter publication year:");
        int publicationYear = sc.nextInt();
        sc.nextLine();

        try {
            if (isDuplicate(id, title, author, publicationYear)) {
                throw new DuplicateBookException("This book already exists.");
            }

            book book = new book(id, title, author, publicationYear);
            books.add(book);

            System.out.println("Book added: " + book);
        } catch (DuplicateBookException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean isDuplicate(String id, String title, String author, int publicationYear) {
        for (book book : books) {
            if (book.getId().equals(id)
                    && book.getTitle().equals(title)
                    && book.getAuthor().equals(author)
                    && book.getPublicationYear() == publicationYear) {
                return true;
            }
        }
        return false;
    }

    public List<book> getBooks() {
        return books;
    }
}

class DuplicateBookException extends Exception {

    public DuplicateBookException(String message) {
        super(message);
    }
}
