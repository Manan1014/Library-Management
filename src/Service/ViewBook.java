package com.example.library;

import java.util.Map;

public class ViewBook {

    private AddBook addBook;

    public ViewBook(AddBook addBook) {
        this.addBook = addBook;
    }

    public void viewOneBook(String id) {
        Book book = addBook.getBook(id);
        if (book != null) {
            System.out.println("Book ID: " + id);
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Year: " + book.getYear());
            System.out.println("Borrowed: " + (addBook.getBorrowedStatus().get(id) ? "Yes" : "No"));
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    
}
