package com.example.thebookclub;

/**
 * Represents a Book object in the application.
 */
public class book {
    private String title;
    private String author;
    private String ownerId;
    private boolean isAvailable;
    private String timeStamp;
    private String bookId;
    private int rent;
    private String details;

    /**
     * Constructor for creating a Book object.
     *
     * @param title     The title of the book.
     * @param author    The author of the book.
     * @param ownerId   The ID of the book's owner.
     * @param details   Details of the book.
     * @param rent      Rental information of the book.
     * @param isAvailable   Flag indicating if the book is available.
     */
    public book(String title, String author, String ownerId, String details, int rent, boolean isAvailable) {
        this.title = title;
        this.rent = rent;
        this.author = author;
        this.ownerId = ownerId;
        this.details = details;
        this.isAvailable = isAvailable;
    }

    // Getters and setters for the Book class

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}

