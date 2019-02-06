package com.twu.dto;

public class MovieDto {

    private String name;
    private int year;
    private String director;
    private int rating;
    private boolean state;

    public MovieDto(String name, int year, String director, int rating, boolean state) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.state = state;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
