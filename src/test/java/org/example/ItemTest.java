package org.example;
import org.junit.Test;
import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void testBorrowAndReturnItem() {
        Item item = new Book("Fourth Wing", "Rebecca Yarros", "310", 2023);
        assertFalse(item.isBorrowed());
        item.borrowItem();
        assertTrue(item.isBorrowed());
        item.returnItem();
        assertFalse(item.isBorrowed());
    }
}