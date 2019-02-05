package com.twu.dto;

public class BookDto {

    private String bookName;
    private int yearPublisher;
    private String autor;
    private boolean state;

    public BookDto(String bookName, int yearPublisher, String autor, boolean state) {
        this.bookName = bookName;
        this.yearPublisher = yearPublisher;
        this.autor = autor;
        this.state = state;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getYearPublisher() {
        return yearPublisher;
    }

    public void setYearPublisher(int yearPublisher) {
        this.yearPublisher = yearPublisher;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
