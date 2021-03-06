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

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        return rating;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
