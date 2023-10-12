package org.example;
import org.junit.Test;
import static org.junit.Assert.*;

public class PatronTest {
    @Test
    public void testBorrowedItems() {
        Patron patron = new Patron("Sergo", "428");
        Item book = new Book("Fourth Wing", "Rebecca Yarros", "310", 2023);
        patron.getBorrowedItems().add(book);
        assertTrue(patron.getBorrowedItems().contains(book));
    }
}