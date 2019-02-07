package com.twu.dao;


import com.twu.dto.CustomerDto;

import java.util.List;

public interface IBookDao {

    List<String> showBooksAvailable();
    void returnBookByName(String bookName);
    boolean selectBookByName(String bookName);
    boolean checkBookName(String bookName);
    void addCustomerChekedOutBook(CustomerDto customer, String bookName);

}

