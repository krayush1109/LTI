package com.wecp.dao;

import com.wecp.entity.Movie;
import java.util.List;

public interface MovieDao {    

    void insertMovie(Movie movie);
    Movie getMovieById(int id);
    List<Movie> getAllMovies(int pageSize, int pageNumber);
    List<Movie> getMoviesByCondition(String title, String genre, int releaseYear);
    void updateMovie(Movie movie);
    void deleteMovieById(int id);    

}
