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

    package com.example.library;

import java.util.Map;

public class ViewBook {

    private AddBook addBook;

    public ViewBook(AddBook addBook) {
        this.addBook = addBook;
    }

    // Method to view a specific book by its ID
    public void viewBook(String id) {
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

    // Method to view all books in the library
    public void viewAllBooks() {
        Map<String, Book> books = addBook.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books are available in the library.");
        } else {
            for (Map.Entry<String, Book> entry : books.entrySet()) {
                String id = entry.getKey();
                Book book = entry.getValue();
                System.out.println("Book ID: " + id);
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Year: " + book.getYear());
                System.out.println("Borrowed: " + (addBook.getBorrowedStatus().get(id) ? "Yes" : "No"));
                System.out.println("----");
            }
        }
    }
}
}
