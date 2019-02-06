package com.twu.dao;

import com.twu.dto.BookDto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class BookDaoImplTest {

    @Test
    public void getBooks() {
        BookDaoImpl bookDao= new BookDaoImpl();
        List<String> books = new ArrayList<String>();
        String book1 = "nombre, autor, año, true";
        String book2 = "nombre, autor, año, true";
        String book3 = "nombre, autor, año, true";
        String book4 = "nombre, autor, año, true";
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        bookDao.getBooks();

        assertEquals(bookDao.getBooks().size(), books.size());
    }

    @Test
    public void showBooks() {
        List<BookDto> booksFake = new ArrayList<BookDto>();
        BookDto book1 = new BookDto("nn", 2,"nn",true);
        BookDto book2 = new BookDto("nn", 2,"nn",true);
        BookDto book3 = new BookDto("nn", 2,"nn",false);
        BookDto book4 = new BookDto("nn", 2,"nn",false);
        booksFake.add(book1);
        booksFake.add(book2);
        booksFake.add(book3);
        booksFake.add(book4);
        BookDaoImpl bookDao = new BookDaoImpl();
        bookDao.setBooks(booksFake);

        assertEquals(bookDao.showBooks().size(),2);
    }

    @Test
    public void returnBookByName() {
        BookDto bookTest = new BookDto("nn", 2,"nn",false);
        List<BookDto> booksFake = new ArrayList<BookDto>();
        booksFake.add(bookTest);
        BookDaoImpl bookDao = new BookDaoImpl();
        bookDao.setBooks(booksFake);
        bookDao.returnBookByName("nn");

        assertEquals(bookTest.isState(), true);
    }

    @Test
    public void selectBookByName() {
        BookDto bookTest = new BookDto("nn", 2,"nn",true);
        List<BookDto> booksFake = new ArrayList<BookDto>();
        booksFake.add(bookTest);
        BookDaoImpl bookDao = new BookDaoImpl();
        bookDao.setBooks(booksFake);
        bookDao.selectBookByName("nn");

        assertEquals(bookTest.isState(), false);
    }

    @Test
    public void checkBookName() {
        BookDto bookTest = new BookDto("alfa", 2,"nn",true);
        List<BookDto> booksFake = new ArrayList<BookDto>();
        booksFake.add(bookTest);
        BookDaoImpl bookDao = new BookDaoImpl();
        bookDao.setBooks(booksFake);

        assertEquals(bookDao.checkBookName("beta"),false);
    }
}