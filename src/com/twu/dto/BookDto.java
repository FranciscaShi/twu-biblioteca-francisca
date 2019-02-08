package com.twu.dto;

public class BookDto {

    private String bookName;
    private int yearPublisher;
    private String autor;
    private boolean state;
    private String customer;

    public BookDto(String bookName, int yearPublisher, String autor, boolean state) {
        this.bookName = bookName;
        this.yearPublisher = yearPublisher;
        this.autor = autor;
        this.state = state;
        this.customer = null;
    }

    public String getBookName() {
        return bookName;
    }

    public int getYearPublisher() {
        return yearPublisher;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
