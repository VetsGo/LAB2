package org.example;

public class Book extends Item{
    private String author;
    private int year;

    public Book(String title, String author, String uniqueID, int year) {
        super(title, uniqueID);
        this.author = author;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}