package com.example.library;

public class book {

    private String id;
    private String title;
    private String author;
    private int publicationYear;
    private boolean available;

    public book(String id, String title, String author, int publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.available = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String bookDetails() {
        return "Book{"
                + "id='" + id + '\''
                + ", title='" + title + '\''
                + ", author='" + author + '\''
                + ", publicationYear=" + publicationYear
                + ", available=" + available
                + '}';
    }

    @Override
    public String toString() {
        return "Book{id='" + id + '\''
                + ", title='" + title + '\''
                + ", author='" + author + '\''
                + ", publicationYear=" + publicationYear
                + ", available=" + available
                + '}';
    }
}
