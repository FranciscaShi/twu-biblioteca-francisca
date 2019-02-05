package com.twu.dao;


import java.util.List;

public interface IBookDao {

    List<String> showBooks();

    void returnBook(String bookName);

    void selectBook(String bookName);

    boolean checkBookName(String bookName);

}
