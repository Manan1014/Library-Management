package com.example.library;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LibraryTest {

    @Test
    public void testChooseOperation() {
        Library library = new Library();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        library.chhoseoperation();
        
        System.setOut(originalOut);
        
        String expectedOutput = "enter 1 for adding book\n" +
                                "enter 2 for borrowbook book\n" +
                                "enter 3 for returnbook\n" +
                                "enter 4 for viewing book\n";

        String actualOutput = outputStream.toString();
        
        expectedOutput = expectedOutput.replace("\r\n", "\n");
        actualOutput = actualOutput.replace("\r\n", "\n");
        
        assertEquals(expectedOutput, actualOutput);
    }
}
