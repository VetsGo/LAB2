package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        System.out.println("Виберіть опцію:");
        System.out.println("1. Додати книгу");
        System.out.println("2. Додати DVD");
        System.out.println("3. Видалити предмет");
        System.out.println("4. Зареєструвати читача");
        System.out.println("5. Видати предмет читачеві");
        System.out.println("6. Повернути предмет у бібліотеку");
        System.out.println("7. Показати доступні предмети");
        System.out.println("8. Показати читачів та їх предмети");
        System.out.println("9. Вийти з програми");

        while (true) {
            System.out.print("Введіть номер опції: ");
            int num = scanner.nextInt();
            scanner.nextLine();
            switch (num) {
                case 1:
                    System.out.print("Введіть назву книги: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Введіть автора книги: ");
                    String author = scanner.nextLine();
                    System.out.print("Введіть унікальний ID книги: ");
                    String bookID = scanner.nextLine();
                    System.out.print("Введіть рік видання: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    Book newBook = new Book(bookTitle, author, bookID, year);
                    library.addItem(newBook);
                    System.out.println("Книгу додано");
                    break;
                case 2:
                    System.out.print("Введіть назву DVD: ");
                    String dvdTitle = scanner.nextLine();
                    System.out.print("Введіть тривалість DVD(хвилини): ");
                    int duration = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введіть унікальний ID DVD: ");
                    String dvdID = scanner.nextLine();
                    DVD newDVD = new DVD(dvdTitle, duration, dvdID);
                    library.addItem(newDVD);
                    System.out.println("DVD додано");
                    break;
                case 3:
                    System.out.print("Введіть унікальний ID предмета для видалення: ");
                    String itemID = scanner.nextLine();
                    boolean removed = library.removeItem(itemID);
                    if (removed) {
                        System.out.println("Предмет видалено");
                    } else {
                        System.out.println("Предмет за унікальним ID не знайдено");
                    }
                    break;
                case 4:
                    System.out.print("Введіть ім'я читача: ");
                    String patronName = scanner.nextLine();
                    System.out.print("Введіть унікальний ID читача: ");
                    String patronID = scanner.nextLine();
                    Patron newPatron = new Patron(patronName, patronID);
                    library.registerPatron(newPatron);
                    System.out.println("Читача зареєстровано");
                    break;
                case 5:
                    System.out.print("Введіть унікальний ID читача: ");
                    String patronIDForLending = scanner.nextLine();
                    System.out.print("Введіть унікальний ID предмета для видачі: ");
                    String itemIDForLending = scanner.nextLine();
                    boolean lent = library.lendItem(patronIDForLending, itemIDForLending);
                    if (lent) {
                        System.out.println("Предмет видано читачеві");
                    } else {
                        System.out.println("Читача або предмет не знайдено, або предмет вже забрали");
                    }
                    break;
                case 6:
                    System.out.print("Введіть унікальний ID читача: ");
                    String patronIDForReturning = scanner.nextLine();
                    System.out.print("Введіть унікальний ID предмета для повернення: ");
                    String itemIDForReturning = scanner.nextLine();
                    boolean returned = library.returnItem(patronIDForReturning, itemIDForReturning);
                    if (returned) {
                        System.out.println("Предмет повернено у бібліотеку");
                    } else {
                        System.out.println("Читача або предмет не знайдено");
                    }
                    break;
                case 7:
                    library.listAvailableItems();
                    break;
                case 8:
                    library.listBorrowedItems();
                    break;
                case 9:
                    System.out.println("Завершено програму");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Ви можете ввести лише значення від 1 до 9.");
            }
        }
    }
}