package com.example.library;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AddBookTest {

    @Test
    public void testAddBook() {
        AddBook addBook = new AddBook();

        String input = "1\nThe Great Gatsby\nF. Scott Fitzgerald\n1925\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        addBook.addBook();

        System.setOut(originalOut);

        String expectedOutput = "Enter book ID:\n"
                + "Enter book title:\n"
                + "Enter book author:\n"
                + "Enter publication year:\n"
                + "Book added: Book{id='1', title='The Great Gatsby', author='F. Scott Fitzgerald', publicationYear=1925, available=true}\n";
        String actualOutput = outputStream.toString();

        expectedOutput = expectedOutput.replace("\r\n", "\n");
        actualOutput = actualOutput.replace("\r\n", "\n");

        assertEquals(expectedOutput, actualOutput);

        book addedBook = addBook.getBooks().get(0);
        assertEquals("1", addedBook.getId());
        assertEquals("The Great Gatsby", addedBook.getTitle());
        assertEquals("F. Scott Fitzgerald", addedBook.getAuthor());
        assertEquals(1925, addedBook.getPublicationYear());
    }

    @Test
    public void testAddDuplicateBook() {
        AddBook addBook = new AddBook();

        String input1 = "1\nThe Great Gatsby\nF. Scott Fitzgerald\n1925\n";
        System.setIn(new ByteArrayInputStream(input1.getBytes()));

        ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream1));

        addBook.addBook();

        String input2 = "1\nThe Great Gatsby\nF. Scott Fitzgerald\n1925\n";
        System.setIn(new ByteArrayInputStream(input2.getBytes()));

        ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream2));

        addBook.addBook();

        System.setOut(originalOut);

        String expectedOutput = "Enter book ID:\n"
                + "Enter book title:\n"
                + "Enter book author:\n"
                + "Enter publication year:\n"
                + "Book added: Book{id='1', title='The Great Gatsby', author='F. Scott Fitzgerald', publicationYear=1925, available=true}\n"
                + "Enter book ID:\n"
                + "Enter book title:\n"
                + "Enter book author:\n"
                + "Enter publication year:\n"
                + "This book already exists.\n";
        String actualOutput = outputStream1.toString() + outputStream2.toString();

        expectedOutput = expectedOutput.replace("\r\n", "\n");
        actualOutput = actualOutput.replace("\r\n", "\n");

        assertEquals(expectedOutput, actualOutput);

        assertEquals(1, addBook.getBooks().size());
    }

}
