package org.example;
import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest {
    @Test
    public void testAddItem() {
        Library library = new Library();
        Item book = new Book("Fourth Wing", "Rebecca Yarros", "310", 2023);
        library.addItem(book);
        boolean itemFound = false;
        for (Item item : library.getItems()) {
            if (item.getUniqueID().equals("310")) {
                itemFound = true;
                break;
            }
        }
        assertTrue(itemFound);
    }

    @Test
    public void testRemoveItem() {
        Library library = new Library();
        Item book = new Book("Fourth Wing", "Rebecca Yarros", "310", 2023);
        library.addItem(book);
        assertTrue(library.removeItem("310"));
        boolean itemFound = false;
        for (Item item : library.getItems()) {
            if (item.getUniqueID().equals("310")) {
                itemFound = true;
                break;
            }
        }
        assertFalse(itemFound);
    }

    @Test
    public void testLendAndReturnItem() {
        Library library = new Library();
        Item book = new Book("Fourth Wing", "Rebecca Yarros", "310", 2023);
        Patron patron = new Patron("Sergo", "428");
        library.addItem(book);
        library.registerPatron(patron);
        assertFalse(book.isBorrowed());
        library.lendItem("428", "310");
        assertTrue(book.isBorrowed());
        library.returnItem("428", "310");
        assertFalse(book.isBorrowed());
    }
}