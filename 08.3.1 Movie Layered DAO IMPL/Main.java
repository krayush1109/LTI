package com.wecp;

import com.wecp.connection.DatabaseConnection;
import com.wecp.dao.MovieDAO;
import com.wecp.dao.MovieDAOImpl;
import com.wecp.entity.Director;
import com.wecp.entity.Movie;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

// bina main method ke kaam karega aache se

public class Main {
    static String dbUrl = "jdbc:mysql://localhost:3306/directorAndMovieDB_wecp";
    static String user = "root";
    static String password = "hellowecp";

    public static void main(String[] args) {       
        try {
            Connection connection = DatabaseConnection.createConnection(dbUrl, user, password);
            MovieDAO movieDAO = new MovieDAOImpl(connection);

            // Insert movies
            Director director = new Director(1, "Manirathnam");
            Movie movie1 = new Movie(0, "Movie One", new Date(0), director);
            Movie movie2 = new Movie(0, "Movie Two", new Date(0), director);
            movieDAO.insertMovie(movie1);
            movieDAO.insertMovie(movie2);

            // Fetch movies by name
            List<Movie> movies = movieDAO.getMoviesByName("Movie");
            for (Movie movie : movies) {
                System.out.println("Movie ID: " + movie.getMovieId());
                System.out.println("Movie Name: " + movie.getMovieName());
                System.out.println("Release Date: " + movie.getMovieReleaseDate());
                System.out.println("Director: " + movie.getDirector().getDirectorName());
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    


    }
}
