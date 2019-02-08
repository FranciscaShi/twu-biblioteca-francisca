package com.twu.dao;

import com.twu.dto.MovieDto;

import java.util.ArrayList;
import java.util.List;

public class MovieDaoImpl {

    public static final int INITIAL_VALUE = 0;
    List<MovieDto> movies;

    public MovieDaoImpl(){

        movies = new ArrayList<MovieDto>();
        MovieDto movie1 = new MovieDto("Kimi no na wa", 2016, "Makoto Shinkai", 9, true);
        MovieDto movie2 = new MovieDto("Midnight in Paris", 2011, "Woody Allen", 8, true);
        MovieDto movie3 = new MovieDto("Wo hu cang long", 2000, "Ang Lee", 7, true);
        MovieDto movie4 = new MovieDto("Inside Out", 2015, "Peter Docter", 8, false);
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
    }

    public List<MovieDto> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDto> movies) {
        this.movies = movies;
    }

    public List<String> showMoviesAvailable(){
        List<String> moviesAvailable = new ArrayList<String>();

        for (int index = INITIAL_VALUE; index < movies.size(); index++) {
            if (movies.get(index).isState()){
                String movie = "\n"+movies.get(index).getName()+" - "+movies.get(index).getDirector()+" - "+
                        movies.get(index).getYear()+" - Rating:"+movies.get(index).getRating()+"\n";
                moviesAvailable.add(movie);
            }
        }
        return moviesAvailable;
    }

    public boolean checkMovieByName(String movieName) {
        for (int index = INITIAL_VALUE; index < movies.size(); index++) {
            if (movies.get(index).getName().equalsIgnoreCase(movieName) && movies.get(index).isState()){
                return true;
            }
        }
        return false;
    }

    public void checkOutByName(String movieName) {
        for (int index = INITIAL_VALUE; index < movies.size(); index++) {
            if (movies.get(index).getName().equalsIgnoreCase(movieName)){
                movies.get(index).setState(false);
            }
        }
    }
}
