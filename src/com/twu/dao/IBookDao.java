package com.twu.dao;


import java.util.List;

public interface IBookDao {

    List<String> showBooks();

    void returnBookByName(String bookName);

    void selectBookByName(String bookName);

    boolean checkBookName(String bookName);

}
