package com.twu.dao;

import com.twu.dto.MovieDto;

import java.util.List;

public interface IMovieDao {

    List<MovieDto> showMoviesAvailable();

    boolean checkMovieByName(String movieName);

    void checkOutByName(String movieName);
}
