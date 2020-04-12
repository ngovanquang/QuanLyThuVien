package oop.homework;

import java.util.Random;
import java.util.Scanner;

public class Library {
    public final int Max_Number_Of_Books = 100;
    private String libraryName;
    private Book[] bookList = new Book[Max_Number_Of_Books];
    private static int numberOfBooks = 0;

    Scanner scanner = new Scanner(System.in);

    public Library(String name) {
        libraryName = "The little Library";

    }

    public void addNewBook() {
        boolean test = true;
        System.out.println("2.Add new book");
        System.out.println("-------------------------------");

        System.out.println("Enter book's information:");
        System.out.println("(1) Book ID: ");
        int bookID = Integer.parseInt(scanner.nextLine());
        System.out.println("(2) Book Title: ");
        String bookTitle = scanner.nextLine();
        System.out.println("(3) Amount: ");
        int amount = Integer.parseInt(scanner.nextLine());

        if(numberOfBooks != 0) {
            for (int i = 0; i < numberOfBooks; i++) {
                if (bookID == bookList[i].getBookID()) {
                    System.out.println("Book ID is not Invalid");
                    test = false;
                    break;
                }
            }
            if (numberOfBooks >= 100) {
                System.out.println("Do not add a new Book!");
                test = false;
            }

        }
        if (test) {
            bookList[numberOfBooks] = new Book(bookID, bookTitle, amount);
            numberOfBooks++;
            System.out.println("Adding successful");
        }
    }

    public boolean findBook(int bookID) {
        System.out.println("3. Find book");
        System.out.println("-------------------------------");
        System.out.println("Enter book's ID: ");
        bookID = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfBooks; i ++) {
            if (bookID == bookList[i].getBookID()){
                System.out.println("Book title: " + bookList[i].getBookTitle());
                System.out.println("BookID: " + bookList[i].getBookID());
                System.out.println("Total amount: " + bookList[i].getAmount());
                System.out.println("Left amount: " + bookList[i].getAvailable());
                return true;
            }
        }
        System.out.println("Do not find that Book");
        return false;
    }

    public boolean findBook(String bookTitle) {
        System.out.println("8. Find book ");
        System.out.println("-------------------------------");
        System.out.println("Enter book's Title: ");
        bookTitle = scanner.nextLine();

        for (int i = 0; i < numberOfBooks; i++) {
            if (bookList[i].getBookTitle().indexOf(bookTitle) >= 0) {
                System.out.println("-----------");
                System.out.println("Book title: " + bookList[i].getBookTitle());
                System.out.println("BookID: " + bookList[i].getBookID());
                System.out.println("Total amount: " + bookList[i].getAmount());
                System.out.println("Left amount: " + bookList[i].getAvailable());
                if (i == (numberOfBooks - 1)) {
                    return true;
                }
            }
        }

            System.out.println("Do not find Book Title");
            return false;

    }

    public void borrowBook(int bookID) {
        boolean j = true;
        System.out.println("4. Borrow a book");
        System.out.println("-------------------------------");
        System.out.println("Enter book's ID: ");
        bookID = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfBooks; i++) {
            if (bookID == bookList[i].getBookID() && bookList[i].getAvailable() > 0) {
                System.out.println("Book title: " + bookList[i].getBookTitle());
                System.out.println("BookID: " + bookList[i].getBookID());
                System.out.println("Total amount: " + bookList[i].getAmount());
                System.out.println("Left amount: " + bookList[i].getAvailable());
                System.out.println("\n");
                System.out.println("The book is borrowed successfully!");
                bookList[i].setAvailable(bookList[i].getAvailable() - 1);
                System.out.println("Book title: " + bookList[i].getBookTitle());
                System.out.println("BookID: " + bookList[i].getBookID());
                System.out.println("Total amount: " + bookList[i].getAmount());
                System.out.println("Left amount: " + bookList[i].getAvailable());
                j = false;
            }
        }
        if (j) {
            System.out.println("Do not have that book");
        }
    }

    public void returnBook(int bookID) {
        boolean k = true;
        System.out.println("5. Return a book");
        System.out.println("-------------------------------");
        System.out.println("Enter book's ID: ");
        bookID = Integer.parseInt(scanner.nextLine());
        System.out.println("\n");
        for (int i = 0; i < numberOfBooks; i++) {
            if (bookID == bookList[i].getBookID() && bookList[i].getAvailable() < bookList[i].getAmount()) {
                System.out.println("The book is returned successfully!");
                bookList[i].setAvailable(bookList[i].getAvailable() + 1);
                System.out.println("Book title: " + bookList[i].getBookTitle());
                System.out.println("BookID: " + bookList[i].getBookID());
                System.out.println("Total amount: " + bookList[i].getAmount());
                System.out.println("Left amount: " + bookList[i].getAvailable());
                k = false;
            }
        }
        if (k) {
            System.out.println("Do not have that book");
        }

    }

    public void showLibraryInfo() {
        System.out.println( "Library name: " + libraryName);
        System.out.println("Number of Books: " + numberOfBooks);
        for (int i =0 ; i < numberOfBooks; i++) {
            System.out.println(i + "." + bookList[i].getBookTitle());
        }
    }

    public Book getALuckyBook() {
        boolean valu = true;
        int number = 0;
        Random rd = new Random();
        while (valu) {
            number = rd.nextInt(numberOfBooks);
            if (bookList[number].getAvailable() == 0) {
                valu = true;
            }
            valu = false;

        }

        bookList[number].setAvailable(bookList[number].getAvailable() - 1);
        System.out.println("The lucky book is: ");
        System.out.println("Book ID: " + bookList[number].getBookID());
        System.out.println("Book Title: " + bookList[number].getBookTitle());
        System.out.println("Total amount: " + bookList[number].getAmount());
        System.out.println("Left amount: " + bookList[number].getAvailable());
        return bookList[number];
    }

}