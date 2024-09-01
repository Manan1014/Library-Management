package com.example.library;

import java.util.HashMap;
import java.util.Map;

public class BorrowBook {

    private AddBook addBook;
    private Map<String, Boolean> borrowedStatus;

    public BorrowBook(AddBook addBook) {
        this.addBook = addBook;
        this.borrowedStatus = new HashMap<>();
    }

    public boolean borrowBook(String id) {
        book book = addBook.getBook(id);
        if (book != null) {
            boolean isBorrowed = borrowedStatus.getOrDefault(id, false);
            if (!isBorrowed) {
                borrowedStatus.put(id, true); 
                System.out.println("Book borrowed: " + book);
                return true;
            } else {
                System.out.println("Book is already borrowed.");
                return false;
            }
        } else {
            System.out.println("Book not found in the library.");
            return false;
        }
    }
}
