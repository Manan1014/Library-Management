package com.example.library;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class ViewBookTest {

    private AddBook addBook;
    private ViewBook viewBook;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        addBook = new AddBook();
        viewBook = new ViewBook(addBook);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
        outContent.reset();
    }

    @Test
    public void testViewBookExists() {
        addBook.addBook("1", "1984", "George Orwell", 1949);
        viewBook.viewBook("1");

        String expectedOutput = "Book ID: 1\n" +
                                "Title: 1984\n" +
                                "Author: George Orwell\n" +
                                "Year: 1949\n" +
                                "Borrowed: No\n";

        assertEquals(expectedOutput.trim(), outContent.toString().trim());
    }

    @Test
    public void testViewBookDoesNotExist() {
        viewBook.viewBook("999");

        String expectedOutput = "Book not found in the library.";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
    }

    package com.example.library;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class ViewBookTest {

    private AddBook addBook;
    private ViewBook viewBook;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        addBook = new AddBook();
        viewBook = new ViewBook(addBook);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
        outContent.reset();
    }

    @Test
    public void testViewBookExists() {
        addBook.addBook("1", "1984", "George Orwell", 1949);
        viewBook.viewBook("1");

        String expectedOutput = "Book ID: 1\n" +
                                "Title: 1984\n" +
                                "Author: George Orwell\n" +
                                "Year: 1949\n" +
                                "Borrowed: No\n";

        assertEquals(expectedOutput.trim(), outContent.toString().trim());
    }

    @Test
    public void testViewBookDoesNotExist() {
        viewBook.viewBook("999");

        String expectedOutput = "Book not found in the library.";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
    }

    @Test
    public void testViewAllBooks() {
        addBook.addBook("1", "1984", "George Orwell", 1949);
        addBook.addBook("2", "Brave New World", "Aldous Huxley", 1932);
        viewBook.viewAllBooks();

        String expectedOutput = "Book ID: 1\n" +
                                "Title: 1984\n" +
                                "Author: George Orwell\n" +
                                "Year: 1949\n" +
                                "Borrowed: No\n" +
                                "----\n" +
                                "Book ID: 2\n" +
                                "Title: Brave New World\n" +
                                "Author: Aldous Huxley\n" +
                                "Year: 1932\n" +
                                "Borrowed: No\n" +
                                "----";

        assertEquals(expectedOutput.trim(), outContent.toString().trim());
    }

    @Test
    public void testViewAllBooksEmptyLibrary() {
        viewBook.viewAllBooks();

        String expectedOutput = "No books are available in the library.";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
    }
}

}
