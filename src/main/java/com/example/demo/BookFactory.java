package com.example.demo;


import com.example.demo.Book.Genre;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookFactory {

    private Book createBook(long bookId, String title, Genre genre) {
        return new Book(bookId, title, genre);
    }

    public List getBooks() {
        List<Book> books = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            books.add(createBook(i, String.format("%s book %s", Genre.fantasy, i), Genre.fantasy));
        }
        for (int i = 6; i <= 10; i++) {
            books.add(createBook(i, String.format("%s book %s", Genre.thriller, i), Genre.thriller));
        }
        for (int i = 11; i <= 15; i++) {
            books.add(createBook(i, String.format("%s book %s", Genre.horror, i), Genre.horror));
        }
        for (int i = 16; i <= 20; i++) {
            books.add(createBook(i, String.format("%s book %s", Genre.romance, i), Genre.romance));
        }
        return books;
    }

}
