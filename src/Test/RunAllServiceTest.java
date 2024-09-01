package com.example.library;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryServiceTest {

    private LibraryService libraryService;

    @Before
    public void setUp() {
        libraryService = new LibraryService();
    }

    @Test
    public void testLibraryServiceIntegration() {
        String bookId = "001";
        String bookTitle = "The Great Gatsby";
        String author = "F. Scott Fitzgerald";

        libraryService.addBook(bookId, bookTitle, author);
        assertNotNull("Book should be added successfully", libraryService.viewBook(bookId));

        boolean borrowSuccess = libraryService.borrowBook(bookId);
        assertTrue("Book should be borrowed successfully", borrowSuccess);
        assertFalse("Book should not be available after borrowing", libraryService.borrowBook(bookId));

        Book book = libraryService.viewBook(bookId);
        assertNotNull("Book should still be viewable after borrowing", book);

        boolean returnSuccess = libraryService.returnBook(bookId);
        assertTrue("Book should be returned successfully", returnSuccess);

        boolean borrowAgainSuccess = libraryService.borrowBook(bookId);
        assertTrue("Book should be available for borrowing again", borrowAgainSuccess);
    }
}
