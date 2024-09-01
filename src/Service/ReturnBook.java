package com.example.library;

import java.util.Map;

public class ReturnBook {

    private AddBook addBook;
    private Map<String, Boolean> borrowedStatus;

    public ReturnBook(AddBook addBook) {
        this.addBook = addBook;
        this.borrowedStatus = addBook.getBorrowedStatus();
    }

    public boolean returnBook(String id) {
        Book book = addBook.getBook(id);
        if (book != null) {
            boolean isBorrowed = borrowedStatus.getOrDefault(id, false);
            if (isBorrowed) {
                borrowedStatus.put(id, false);
                System.out.println("Book returned: " + book.getTitle());
                return true; 
            } else {
                System.out.println("Book was not borrowed.");
                return false;
            }
        } else {
            System.out.println("Book not found in the library.");
            return false; 
        }
    }
}
