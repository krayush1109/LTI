package com.wecp.dao;


import com.wecp.entity.Movie;

import java.sql.SQLException;
import java.util.List;

public interface MovieDAO {
    
    void insertMovie(Movie movie);
    List<Movie> getMoviesByName(String movieName);    

}
