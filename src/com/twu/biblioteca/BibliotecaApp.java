package com.twu.biblioteca;


import com.twu.dao.BookDaoImpl;

import java.util.Scanner;

public class BibliotecaApp {


    public static void main(String[] args) {


        BookDaoImpl bookDao = new BookDaoImpl();

        int opcion = 0;

        Scanner leer;


        do {
            System.out.println("Welcome to Biblioteca!");
            System.out.println("Your one-stop-shop for great book titles in Bangalore");
            System.out.println("   *** *** ***    ");
            System.out.println("Please, select a choice of the Menu");
            System.out.println("1. List of Books");

            try {

                leer = new Scanner(System.in);
                System.out.print("\nYour choice: ");
                opcion = leer.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("List of books \n" + bookDao.showBooksAvailable());

                        Scanner choice;
                        int choiceNumber;

                        do {
                            System.out.println("\nPlease, select the number of the action did you need");
                            System.out.println("1. Return a book");
                            System.out.println("2. Select a book");
                            System.out.println("3. Out of system");


                            choice = new Scanner(System.in);
                            System.out.print("\nYour choice: ");
                            choiceNumber = choice.nextInt();

                            Scanner nameOfBook;
                            String name;


                            switch (choiceNumber) {
                                case 1:
                                    choiceNumber = returnBook(bookDao, choiceNumber);

                                    break;

                                case 2:
                                    choiceNumber = selectBook(bookDao, choiceNumber);

                                    break;

                                case 3:
                                    break;
                            }

                        } while (choiceNumber != 3);

                        break;

                    default:
                        System.out.println("Please select a valid option!\n");
                        break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } while (opcion != 1);


    }

    private static int selectBook(BookDaoImpl bookDao, int choiceNumber) {
        Scanner nameOfBook;
        String name;
        System.out.println("Select a book");
        nameOfBook = new Scanner(System.in);
        int checkBookName = 1;

        do {

            System.out.print("Write the name of the book did you need: ");
            name = nameOfBook.nextLine();

            if (bookDao.checkBookName(name)) {
                bookDao.selectBookByName(name);
                checkBookName = 1;
            } else {
                System.out.println("Sorry, that is not a valid book to return\nPlease try again...\n");
                checkBookName = 2;
            }
        } while (checkBookName != 1);

        System.out.println("\nThanks you! Enjoy the book " + name);

        System.out.println("\nDo you wish see the list of books again? (yes/no)");
        Scanner answer;
        String clientAnswer;
        answer = new Scanner(System.in);
        clientAnswer = answer.nextLine();

        if (clientAnswer.equalsIgnoreCase("yes")) {
            System.out.println(bookDao.showBooksAvailable());
        } else {
            choiceNumber = 3;
        }
        return choiceNumber;
    }

    private static int returnBook(BookDaoImpl bookDao, int choiceNumber) {
        Scanner nameOfBook;
        String name;
        System.out.println("Return Book");
        nameOfBook = new Scanner(System.in);
        int checkBookName = 1;

        do {

            System.out.print("Write the name of the book: ");
            name = nameOfBook.nextLine();

            if (bookDao.checkBookName(name)) {
                bookDao.returnBookByName(name);
                checkBookName = 1;
            } else {
                System.out.println("Sorry, that is not a valid book to return\nPlease try again...\n");
                checkBookName = 2;
            }
        } while (checkBookName != 1);

        System.out.println("\nThanks you for returning the book " + name);

        System.out.println("\nDo you wish see the list of books again? (yes/no)");
        Scanner answer;
        String clientAnswer;
        answer = new Scanner(System.in);
        clientAnswer = answer.nextLine();

        if (clientAnswer.equalsIgnoreCase("yes")) {
            System.out.println(bookDao.showBooksAvailable());
        } else {
            choiceNumber = 3;
        }
        return choiceNumber;
    }


}
