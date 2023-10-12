package org.example;
import java.util.ArrayList;
import java.util.List;

public class Library implements IManageable{
    private List<Item> items;
    private List<Patron> patrons;

    public Library() {
        items = new ArrayList<>();
        patrons = new ArrayList<>();
    }

    public void registerPatron(Patron patron) {
        patrons.add(patron);
    }

    public boolean lendItem(String patronID, String itemID) {
        Patron patron = findPatronByID(patronID);
        Item item = findItemByID(itemID);

        if (patron != null && item != null && !item.isBorrowed()) {
            item.borrowItem();
            patron.getBorrowedItems().add(item);
            return true;
        }
        return false;
    }

    public boolean returnItem(String patronID, String itemID) {
        Patron patron = findPatronByID(patronID);
        Item item = findItemByID(itemID);

        if (patron != null && item != null && item.isBorrowed()) {
            item.returnItem();
            patron.getBorrowedItems().remove(item);
            return true;
        }
        return false;
    }

    @Override
    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public boolean removeItem(String uniqueID) {
        Item item = findItemByID(uniqueID);

        if (item != null) {
            items.remove(item);
            return true;
        }
        return false;
    }

    @Override
    public void listAvailableItems() {
        System.out.println("Доступні предмети:");
        for (Item item : items) {
            if (!item.isBorrowed()) {
                System.out.println("Предмет: " + item.getTitle());
            }
        }
    }

    public void listBorrowedItems() {
        System.out.println("Читачі та їх предмети:");
        for (Patron patron : patrons) {
            for (Item item : patron.getBorrowedItems()) {
                System.out.println("Читач: " + patron.getName() + ", Предмет: " + item.getTitle());
            }
        }
    }

    private Patron findPatronByID(String patronID) {
        for (Patron patron : patrons) {
            if (patron.getID().equals(patronID)) {
                return patron;
            }
        }
        return null;
    }

    private Item findItemByID(String itemID) {
        for (Item item : items) {
            if (item.getUniqueID().equals(itemID)) {
                return item;
            }
        }
        return null;
    }

    public List<Item> getItems() {
        return items;
    }
}