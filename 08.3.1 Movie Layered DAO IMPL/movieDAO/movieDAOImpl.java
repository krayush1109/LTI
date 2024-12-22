package com.wecp.dao;


import com.wecp.connection.DatabaseConnection;
import com.wecp.entity.Director;
import com.wecp.entity.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDAOImpl implements MovieDAO {  
    private Connection connection;
    public MovieDAOImpl(){}
    public MovieDAOImpl(Connection connection){
        try {
            this.connection =  connection;            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void insertMovie(Movie movie) {
        String sql = "INSERT INTO Movies (movieName, movieReleaseDate, directorId) VALUES (?, ?, ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, movie.getMovieName());
            pstmt.setDate(2, new java.sql.Date(movie.getMovieReleaseDate().getTime()));
            pstmt.setInt(3, movie.getDirector().getDirectorId());
            pstmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Movie> getMoviesByName(String movieName) {
        String sql = "SELECT m.movieId, m.movieName, m.movieReleaseDate, d.directorId, d.directorName " +
                     "FROM Movies m JOIN Directors d ON m.directorId = d.directorId " +
                     "WHERE m.movieName LIKE ?";
        List<Movie> movies = new ArrayList<>();
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, "%" + movieName + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int movieId = rs.getInt("movieId");
                    String name = rs.getString("movieName");
                    Date releaseDate = rs.getDate("movieReleaseDate");
                    int directorId = rs.getInt("directorId");
                    String directorName = rs.getString("directorName");
                    Director director = new Director(directorId, directorName);
                    Movie movie = new Movie(movieId, name, releaseDate, director);
                    movies.add(movie);
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return movies;
    }

}
