# Library Management System

## Overview

The Library Management System is a Java-based application developed using Test-Driven Development (TDD) principles. This system manages the lifecycle of books within a library, ensuring that all functionalities are driven by tests and validated against expected outcomes.

## Features

- **Add Books**: Add new books to the library collection.
- **Duplicate Book Handling**: Prevent the addition of duplicate books based on ISBN.
- **Borrow Books**: Borrow available books and ensure they are not borrowed more than once.
- **Return Books**: Return borrowed books and make them available for others.
- **View Available Books**: List all books currently available for borrowing.


## Project Structure and Functionalities

Below is a detailed description of the key files in the project and their respective functionalities:

### 1. **Main Functionalities**

- **`Book.java`**:
  - **Purpose**: Represents a `Book` entity with properties like `id`, `title`, `author`, and `isAvailable`.
  - **Functionality**: Acts as a model class to hold the data for each book in the library.

- **`AddBook.java`**:
  - **Purpose**: Handles the addition of new books to the library's collection.
  - **Functionality**: 
    - Takes details like book title, author, and generates an `id`.
    - Adds the new book to the library's collection.

- **`BorrowBook.java`**:
  - **Purpose**: Manages the process of borrowing books from the library.
  - **Functionality**:
    - Checks the availability of the book.
    - Marks the book as borrowed (unavailable) if it is available.
  
- **`ReturnBook.java`**:
  - **Purpose**: Manages the return of borrowed books.
  - **Functionality**:
    - Marks the borrowed book as available again in the library.
  
- **`ViewBook.java`**:
  - **Purpose**: Provides functionality to view details of all available books in the library.
  - **Functionality**:
    - Displays the list of books that are currently available in the library.

- **`LibraryService.java`**:
  - **Purpose**: Acts as the main service class that integrates all the functionalities (`AddBook`, `BorrowBook`, `ReturnBook`, `ViewBook`).
  - **Functionality**:
    - Provides a single point of interaction for adding, borrowing, returning, and viewing books.

### 2. **Testing Functionalities**

- **`AddBookTest.java`**:
  - **Purpose**: Contains unit tests for the `AddBook` functionality.
  - **Functionality**: 
    - Tests the successful addition of a new book.
    - Verifies that the book details are correctly stored.

- **`BorrowBookTest.java`**:
  - **Purpose**: Contains unit tests for the `BorrowBook` functionality.
  - **Functionality**:
    - Tests the successful borrowing of a book.
    - Ensures that a book cannot be borrowed if it is already borrowed.

- **`ReturnBookTest.java`**:
  - **Purpose**: Contains unit tests for the `ReturnBook` functionality.
  - **Functionality**:
    - Tests the successful return of a borrowed book.
    - Verifies that the book is marked as available after being returned.

- **`ViewBookTest.java`**:
  - **Purpose**: Contains unit tests for the `ViewBook` functionality.
  - **Functionality**:
    - Tests that all available books are correctly displayed.
    - Ensures the correct list of available books is retrieved.

- **`LibraryServiceTest.java`**:
  - **Purpose**: Tests the integration of all library functionalities in `LibraryService`.
  - **Functionality**:
    - Verifies that all functionalities work together as expected.
    - Tests the overall flow of adding, borrowing, returning, and viewing books.

## Setup and Installation

**Clone the Repository**:

   ```bash
   git clone https://github.com/Manan1014/library-management-system.git
   cd library-management-system
   mvn clean install
   mvn test

