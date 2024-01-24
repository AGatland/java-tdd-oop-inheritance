package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookTest {
    @Test
    public void shouldCheckOutIfAvailable() {
        Author author = new Author("Java Man", "java@man.coder", "javaman.coder");
        Book book = new Book("JUnit Rocks", author);
        Assertions.assertEquals("item has been checked out", book.checkOut());
    }

    @Test
    public void shouldDeclineIfNotAvailableToCheckout() {
        Author author = new Author("Java Man", "java@man.coder", "javaman.coder");
        Book book = new Book("JUnit Rocks", author);
        book.checkOut();

        Assertions.assertEquals("item is currently on loan", book.checkOut());
    }

    @Test
    public void shouldCheckInIfOnLoan() {
        Author author = new Author("Java Man", "java@man.coder", "javaman.coder");
        Book book = new Book("JUnit Rocks", author);
        book.checkOut();

        Assertions.assertEquals("item has been checked in", book.checkIn());
    }

    @Test
    public void shouldDeclineCheckInIfNotOnLoan() {
        Author author = new Author("Java Man", "java@man.coder", "javaman.coder");
        Book book = new Book("JUnit Rocks", author);

        Assertions.assertEquals("item is not currently on loan", book.checkIn());
    }

    @Test
    public void authorShouldbePartOfClass() {
        Author author = new Author("Java Man", "java@man.coder", "javaman.coder");
        Book book = new Book("JUnit Rocks", author);

        Assertions.assertEquals("Java Man",book.author.getName());
        Assertions.assertEquals("java@man.coder",book.author.getEmail());
        Assertions.assertEquals("javaman.coder",book.author.getWebsite());
    }

    @Test
    public void getAuthorShouldReturnAuthor() {
        Author author = new Author("Java Man", "java@man.coder", "javaman.coder");
        Book book = new Book("JUnit Rocks", author);

        Assertions.assertEquals(author, book.getAuthor());
    }
}
