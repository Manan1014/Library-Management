package com.example.library;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReturnBookTest {

    private AddBook addBook;
    private BorrowBook borrowBook;
    private ReturnBook returnBook;

    @Before
    public void setUp() {
        addBook = new AddBook();
        borrowBook = new BorrowBook(addBook);
        returnBook = new ReturnBook(addBook);

        addBook.addBook("1", "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        addBook.addBook("2", "To Kill a Mockingbird", "Harper Lee", 1960);
    }

    @Test
    public void testReturnBorrowedBook() {
        borrowBook.borrowBook("1");
        
        boolean result = returnBook.returnBook("1");
        
        assertTrue("The book should be returned successfully.", result);
        
        assertFalse("The book should be marked as not borrowed.", addBook.getBorrowedStatus().get("1"));
    }

    @Test
    public void testReturnNotBorrowedBook() {
        boolean result = returnBook.returnBook("2");
        
        assertFalse("Returning a book that wasn't borrowed should fail.", result);
        
        assertFalse("The book should still be marked as not borrowed.", addBook.getBorrowedStatus().get("2"));
    }

    @Test
    public void testReturnNonExistentBook() {
        boolean result = returnBook.returnBook("999");
        
        assertFalse("Returning a non-existent book should fail.", result);
    }

    @Test
    public void testMultipleReturnOperations() {
        borrowBook.borrowBook("1");
        assertTrue("First return should succeed.", returnBook.returnBook("1"));
        assertFalse("Returning the same book again should fail.", returnBook.returnBook("1"));
        
        borrowBook.borrowBook("1");
        assertTrue("Re-borrowing and returning the book should succeed.", returnBook.returnBook("1"));
    }

    @Test
    public void testReturnWithoutBorrowingFirst() {
        boolean result = returnBook.returnBook("1");
        
        assertFalse("Returning without borrowing should fail.", result);
    }
}
