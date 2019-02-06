package com.twu.dao;

import com.twu.dto.BookDto;

import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements IBookDao {

    public static final int INITIAL_VALUE = 0;
    List<BookDto> books;

    public BookDaoImpl(){
        books = new ArrayList<BookDto>();
        BookDto book1 = new BookDto("Apologia Socrates", -500, "Platón", true);
        BookDto book2 = new BookDto("El Capital", 1932, "Karl Marx", true);
        BookDto book3 = new BookDto("El ser y el tiempo", 1954, "Martin Heidegger", true);
        BookDto book4 = new BookDto("1984", 1949, "George Orwell", false);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
    }

    public List<BookDto> getBooks() {
        return books;
    }

    public void setBooks(List<BookDto> books) {
        this.books = books;
    }

    public List<String> showBooks(){
        List<String> bookList = new ArrayList<String>();
        for (int i=INITIAL_VALUE; i<books.size(); i++){
            int num = i+1;

            if (books.get(i).isState()){
                String book = "\n"+num+".- "+books.get(i).getBookName()+" - " +books.get(i).getAutor()+" - "+books.get(i).getYearPublisher() + " \n";
                bookList.add(book);
            }
        }
        return bookList;
    }

    public void returnBookByName(String bookName){
        for (int index = INITIAL_VALUE; index<books.size(); index++){
            if (books.get(index).getBookName().equalsIgnoreCase(bookName)){
                books.get(index).setState(true);
            }
        }
    }

    public void selectBookByName(String bookName){
        for (int index=INITIAL_VALUE; index<books.size(); index++){
            if (books.get(index).getBookName().equalsIgnoreCase(bookName)){
                books.get(index).setState(false);
            }
        }
    }

    public boolean checkBookName(String bookName){
        for (int index=INITIAL_VALUE; index<books.size(); index++){
            if (books.get(index).getBookName().equalsIgnoreCase(bookName)){
               return true;
            }
        }
        return false;
    }


}
