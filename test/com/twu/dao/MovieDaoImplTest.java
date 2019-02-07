package com.twu.dao;

import com.twu.dto.BookDto;
import com.twu.dto.MovieDto;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MovieDaoImplTest {

    @Test
    public void showMoviesAvailable() {
        MovieDto movieDto = mock(MovieDto.class);
        when(movieDto.isState()).thenReturn(false);
        MovieDaoImpl movieDao = new MovieDaoImpl();
        movieDao.showMoviesAvailable();
        assertThat(movieDao.showMoviesAvailable().contains(movieDto), is(false));
    }

    @Test
    public void checkMovieByName() {
        MovieDto movieDto = mock(MovieDto.class);
        when(movieDto.getName()).thenReturn("nn");
        MovieDaoImpl movieDao = new MovieDaoImpl();
        movieDao.checkMovieByName("aa");
        assertThat(movieDto.isState(),is(false));
    }

    @Test
    public void checkOutByName() {
        MovieDto movieDto = mock(MovieDto.class);
        movieDto.setState(true);
        when(movieDto.getName()).thenReturn("nn");
        MovieDaoImpl movieDao = new MovieDaoImpl();
        movieDao.checkOutByName("nn");
        assertThat(movieDao.showMoviesAvailable().contains(movieDto), is(false));
    }

}