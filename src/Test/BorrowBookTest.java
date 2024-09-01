package com.example.library;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BorrowBookTest {

    private AddBook addBook;
    private BorrowBook borrowBook;

    @Before
    public void setUp() {
        addBook = new AddBook();
        borrowBook = new BorrowBook(addBook);
    
        addBook.addBook("1", "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        addBook.addBook("2", "To Kill a Mockingbird", "Harper Lee", 1960);
    }

    @Test
    public void testBorrowAvailableBook() {
        boolean result = borrowBook.borrowBook("1");
        assertTrue(result); 
    }

    @Test
    public void testBorrowAlreadyBorrowedBook() {
        borrowBook.borrowBook("1"); 
        boolean result = borrowBook.borrowBook("1"); 
        assertFalse(result); 
    }

    @Test
    public void testBorrowNonExistentBook() {
        boolean result = borrowBook.borrowBook("999");
        assertFalse(result); 
    }
}
