package oop.homework;

import java.util.Scanner;

public class Program {

    private static int option;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Library lib1 = new Library("The little Library");
        boolean condition = true;
        
        while (condition) {
            showMenu();
            askOption();


            switch (option) {
                case 1:
                    lib1.showLibraryInfo();
                    System.out.println("press any key to continue: ");
                    String key = scanner.nextLine();
                    break;
                case 2:
                    lib1.addNewBook();
                    System.out.println("press any key to continue: ");
                    key = scanner.nextLine();
                    break;
                case 3:
                    lib1.findBook(0);
                    System.out.println("press any key to continue: ");
                    key = scanner.nextLine();
                    break;
                case 4:
                    lib1.borrowBook(0);
                    System.out.println("press any key to continue: ");
                    key = scanner.nextLine();
                    break;
                case 5:
                    lib1.returnBook(0);
                    System.out.println("press any key to continue: ");
                    key = scanner.nextLine();
                    break;
                case 6:
                    condition = false;
                    break;
                case 7:
                    lib1.getALuckyBook();
                case 8:
                    lib1.findBook("0");
            }
        }
    }
    public static void showMenu() {
        System.out.println("========== Main menu ==========");
        System.out.println("1. Show library information");
        System.out.println("2. Add new book");
        System.out.println("3. Find book");
        System.out.println("4. Borrow a book");
        System.out.println("5. Return a book");
        System.out.println("6. Exit");
        System.out.println("===============================");
        System.out.println("Enter menu ID (1-6) :");
    }

    public static void askOption(){
        //Scanner In = new Scanner(System.in);
        option = scanner.nextInt();
    }

}
