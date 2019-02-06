package com.twu.dto;

import java.util.List;

public class CustomerDto {

    private String name;
    private String email;
    private String phoneNumber;
    private String libraryNumber;
    private String password;
    private List<BookDto> booksCheckedOut;

    public CustomerDto(String name, String email, String phoneNumber, String libraryNumber, String password, List<BookDto> booksCheckedOut) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.booksCheckedOut = null;
    }

    public List<BookDto> getBooksCheckedOut() {
        return booksCheckedOut;
    }

    public void setBooksCheckedOut(List<BookDto> booksCheckedOut) {
        this.booksCheckedOut = booksCheckedOut;
    }
}
