package com.twu.biblioteca;


import com.twu.dao.BookDaoImpl;
import com.twu.dao.CustomerDaoImpl;
import com.twu.dao.MovieDaoImpl;

import java.util.Scanner;

public class BibliotecaApp {


    public static void main(String[] args) {


        BookDaoImpl bookDao = new BookDaoImpl();
        MovieDaoImpl movieDao = new MovieDaoImpl();
        CustomerDaoImpl customerDao = new CustomerDaoImpl();
        int opcion = 0;
        Scanner leer;

        do {
            System.out.println("\nWelcome to Biblioteca!");
            System.out.println("Your one-stop-shop for great book titles in Bangalore");
            System.out.println("   *** *** ***    ");
            System.out.println("Please, select a choice of the Menu");
            System.out.println("1. List of Books");
            System.out.println("2. List of Movies");
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

                            String libraryNumber = customerLogin(customerDao);

                            System.out.println("\nPlease, select the number of the action did you need");
                            System.out.println("1. Return a book");
                            System.out.println("2. Select a book");
                            System.out.println("3. See my user information");
                            System.out.println("4. Out of system");
                            choice = new Scanner(System.in);
                            System.out.println("\nYour choice: ");
                            choiceNumber = choice.nextInt();

                            switch (choiceNumber) {
                                case 1:
                                    choiceNumber = returnBook(bookDao, choiceNumber);
                                    break;
                                case 2:
                                    choiceNumber = selectBook(bookDao, choiceNumber);
                                    break;
                                case 3:
                                    System.out.println(customerDao.seeUserInformation(libraryNumber));
                                    System.out.println("\n Do you need back to the menu?(yes/no)");
                                    Scanner answer;
                                    String clientAnswer;
                                    answer = new Scanner(System.in);
                                    clientAnswer = answer.nextLine();
                                    if (clientAnswer.equalsIgnoreCase("yes")) {
                                        choiceNumber=0;
                                    }
                                    choiceNumber = 4;
                                    break;
                                case 4:
                                    break;
                            }
                        } while (choiceNumber != 4);
                        break;

                    case 2:
                        System.out.println("List of movies \n" + movieDao.showMoviesAvailable());
                        Scanner movieChoice;
                        int selectedNumber;
                        do {
                            System.out.println("\nPlease, select the number of the action did you need");
                            System.out.println("1. Check-out a movie");
                            System.out.println("2. Out of system");
                            movieChoice = new Scanner(System.in);
                            System.out.println("\nYour choice: ");
                            selectedNumber = movieChoice.nextInt();
                            switch (selectedNumber){
                                case 1:
                                    checkOutAMovie(movieDao);
                                    break;
                                default:
                                    System.out.println("Please select a valid option!\n");
                                    break;
                            }
                        }while (selectedNumber !=2);
                        break;
                    default:
                        System.out.println("Please select a valid option!\n");
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (opcion < 2);
    }

    private static String customerLogin(CustomerDaoImpl customerDao) {
        Scanner choice;
        int choiceNumber;
        choice = new Scanner(System.in);
        System.out.println("\nYour choice: ");
        choiceNumber = choice.nextInt();
        Scanner readLibraryNumber;
        String libraryNumber = "";
        Scanner readPassword;
        String password;
        int loginChecker=0;
        do {
            if (choiceNumber == 1 || choiceNumber == 2) {
                int loginNumber = 1;
                do {
                    System.out.println(" **** LOGIN ****\n");
                    readLibraryNumber = new Scanner(System.in);
                    System.out.println("\nLibrary Number: ");
                    libraryNumber = readLibraryNumber.nextLine();
                    if (customerDao.checkCustomerLibraryNumber(libraryNumber)) {
                        int passwordNumber = 1;
                        do {
                            readPassword = new Scanner(System.in);
                            System.out.println("\nPassword: ");
                            password = readPassword.nextLine();
                            if (customerDao.checkCustomerPassword(password)) {
                                loginChecker=1;
                                passwordNumber=1;
                            } else {
                                passwordNumber = 2;
                            }
                        } while (passwordNumber != 1);
                    } else {
                        System.out.println("Library Number not valid \nPlease try again...");
                        loginNumber = 2;
                    }
                } while (loginNumber != 1);
            }
        }while(loginChecker!=1);
        return libraryNumber;
    }

    private static void checkOutAMovie(MovieDaoImpl movieDao) {
        System.out.println("Check out a Movie");
        Scanner nameOfMovie;
        String movieName;
        nameOfMovie = new Scanner(System.in);
        int checkMovieName = 1;
        do {
            System.out.println("Write the name of the movie did you need: ");
            movieName = nameOfMovie.nextLine();

            if (movieDao.checkMovieByName(movieName)) {
                movieDao.checkOutByName(movieName);
                checkMovieName = 1;
            } else {
                System.out.println("Sorry, that is not a valid movie to return\nPlease try again...\n");
                checkMovieName = 2;
            }
        }while (checkMovieName !=1);
        System.out.println("\nThanks you! Enjoy the movie " + movieName);
    }

    private static int selectBook(BookDaoImpl bookDao, int choiceNumber) {
        Scanner nameOfBook;
        String name;
        System.out.println("Select a book");
        nameOfBook = new Scanner(System.in);
        int checkBookName;
        do {
            System.out.println("Write the name of the book did you need: ");
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
            choiceNumber = 4;
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
            System.out.println("Write the name of the book: ");
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
            choiceNumber = 4;
        }
        return choiceNumber;
    }


}
