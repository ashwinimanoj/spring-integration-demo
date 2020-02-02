package com.example.demo;

public class Book {

    private long bookId;
    private String title;

    public Genre getGenre() {
        return genre;
    }

    private Genre genre;

    public enum Genre {
        fantasy, horror, romance, thriller

    }

    public Book(long bookId, String title, Genre genre) {
        this.bookId = bookId;
        this.title = title;
        this.genre = genre;
    }

}
