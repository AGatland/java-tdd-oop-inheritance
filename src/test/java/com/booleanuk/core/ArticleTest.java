package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArticleTest {
    @Test
    public void shouldCheckOutIfAvailable() {
        Author author = new Author("Java Man", "java@man.coder", "javaman.coder");
        Article article = new Article("JUnit Rocks", author);
        Assertions.assertEquals("item has been checked out", article.checkOut());
    }

    @Test
    public void shouldDeclineIfNotAvailableToCheckout() {
        Author author = new Author("Java Man", "java@man.coder", "javaman.coder");
        Article article = new Article("JUnit Rocks", author);
        article.checkOut();

        Assertions.assertEquals("item is currently on loan", article.checkOut());
    }

    @Test
    public void shouldCheckInIfOnLoan() {
        Author author = new Author("Java Man", "java@man.coder", "javaman.coder");
        Article article = new Article("JUnit Rocks", author);
        article.checkOut();

        Assertions.assertEquals("item has been checked in", article.checkIn());
    }

    @Test
    public void shouldDeclineCheckInIfNotOnLoan() {
        Author author = new Author("Java Man", "java@man.coder", "javaman.coder");
        Article article = new Article("JUnit Rocks", author);

        Assertions.assertEquals("item is not currently on loan", article.checkIn());
    }

    @Test
    public void authorShouldbePartOfClass() {
        Author author = new Author("Java Man", "java@man.coder", "javaman.coder");
        Article article = new Article("JUnit Rocks", author);

        Assertions.assertEquals("Java Man",article.author.getName());
        Assertions.assertEquals("java@man.coder",article.author.getEmail());
        Assertions.assertEquals("javaman.coder",article.author.getWebsite());
    }

    @Test
    public void getAuthorShouldReturnAuthor() {
        Author author = new Author("Java Man", "java@man.coder", "javaman.coder");
        Article article = new Article("JUnit Rocks", author);

        Assertions.assertEquals(author, article.getAuthor());
    }
}
