package com.twu.dto;

import java.util.List;

public class CustomerDto {

    private String name;
    private String email;
    private String phoneNumber;
    private String libraryNumber;
    private String password;

    public CustomerDto(String name, String email, String phoneNumber, String libraryNumber, String password) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

}
