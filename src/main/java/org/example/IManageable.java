package org.example;

public interface IManageable {
    void addItem(Item item);
    boolean removeItem(String uniqueID);
    void listAvailableItems();
    void listBorrowedItems();
}