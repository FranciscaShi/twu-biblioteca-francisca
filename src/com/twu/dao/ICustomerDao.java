package com.twu.dao;

public interface ICustomerDao {

    boolean checkCustomerLibraryNumber(String libraryNumber);
    boolean checkCustomerPassword(String password);
    boolean loginUsuario(String libraryNumber,String password);
    String seeUserInformation(String libraryNumber);
}
