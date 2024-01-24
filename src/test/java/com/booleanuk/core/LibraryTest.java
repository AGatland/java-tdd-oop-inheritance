package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void addToStockGetsAdded() {
        Library library = new Library();
        Author author = new Author("Java Man", "java@man.coder", "javaman.coder");
        LibraryItem item = new Article("Java", author);
        LibraryItem item2 = new Book("Is", author);
        LibraryItem item3 = new Newspaper("Fun");

        library.addToStock(item);
        library.addToStock(item2);
        library.addToStock(item3);

        Assertions.assertFalse(library.libraryItems.isEmpty());
        Assertions.assertTrue(library.libraryItems.contains(item));
        Assertions.assertTrue(library.libraryItems.contains(item2));
        Assertions.assertTrue(library.libraryItems.contains(item3));
    }

    @Test
    void checkInItemArticleNotOnLoan() {
        Library library = new Library();
        Author author = new Author("Java Man", "java@man.coder", "javaman.coder");
        LibraryItem item = new Article("Why inheritance is dope", author);
        library.addToStock(item);
        Assertions.assertEquals("item is not currently on loan", library.checkInItem("Why inheritance is dope"));
    }

    @Test
    void checkInItemArticleOnLoan() {
        Library library = new Library();
        Author author = new Author("Java Man", "java@man.coder", "javaman.coder");
        LibraryItem item = new Article("Why inheritance is dope", author);
        item.onLoan = true;
        library.addToStock(item);
        Assertions.assertEquals("item has been checked in", library.checkInItem("Why inheritance is dope"));
    }

    @Test
    void checkInItemNewspaper() {
        Library library = new Library();
        LibraryItem item = new Newspaper("Breaking: Inheritance is being implemented");
        library.addToStock(item);
        Assertions.assertEquals("newspapers are not available for loan", library.checkInItem("Breaking: Inheritance is being implemented"));
    }

    @Test
    void checkInItemBookNotOnLoan() {
        Library library = new Library();
        Author author = new Author("Java Man", "java@man.coder", "javaman.coder");
        LibraryItem item = new Book("Inheritance for beginners", author);
        library.addToStock(item);
        Assertions.assertEquals("item is not currently on loan", library.checkInItem("Inheritance for beginners"));
    }

    @Test
    void checkInItemBookOnLoan() {
        Library library = new Library();
        Author author = new Author("Java Man", "java@man.coder", "javaman.coder");
        LibraryItem item = new Book("Inheritance for beginners", author);
        item.onLoan = true;
        library.addToStock(item);
        Assertions.assertEquals("item has been checked in", library.checkInItem("Inheritance for beginners"));
    }

    @Test
    void checkOutItemArticle() {
        Library library = new Library();
        Author author = new Author("Java Man", "java@man.coder", "javaman.coder");
        LibraryItem item = new Article("Why inheritance is dope", author);
        library.addToStock(item);
        library.checkOutItem("Why inheritance is dope");
        Assertions.assertTrue(item.onLoan);
    }

    @Test
    void checkOutItemArticleNotAvailable() {
        Library library = new Library();
        Author author = new Author("Java Man", "java@man.coder", "javaman.coder");
        LibraryItem item = new Article("Why inheritance is dope", author);
        item.onLoan = true;
        library.addToStock(item);
        Assertions.assertEquals("item is currently on loan", library.checkOutItem("Why inheritance is dope"));
    }

    @Test
    void checkOutItemNewspaper() {
        Library library = new Library();
        LibraryItem item = new Newspaper("Breaking: Inheritance is being implemented");
        library.addToStock(item);
        Assertions.assertEquals("newspapers are not available for loan", library.checkOutItem("Breaking: Inheritance is being implemented"));
    }

    @Test
    void checkOutItemBook() {
        Library library = new Library();
        Author author = new Author("Java Man", "java@man.coder", "javaman.coder");
        LibraryItem item = new Book("Inheritance for beginners", author);
        library.addToStock(item);
        library.checkOutItem("Inheritance for beginners");
        Assertions.assertTrue(item.onLoan);
    }

    @Test
    void checkOutItemBookNotAvailable() {
        Library library = new Library();
        Author author = new Author("Java Man", "java@man.coder", "javaman.coder");
        LibraryItem item = new Book("Inheritance for beginners", author);
        item.onLoan = true;
        library.addToStock(item);
        Assertions.assertEquals("item is currently on loan", library.checkOutItem("Inheritance for beginners"));
    }
}