package com.wecp.dao;

import com.wecp.entity.Movie;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDaoImpl implements MovieDao  {
    Connection connection;
    
    public MovieDaoImpl(){}

    public MovieDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertMovie(Movie movie) {
        String sql = "INSERT INTO movie (title, release_year, genre, rating) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, movie.getTitle());
            pstmt.setInt(2, movie.getReleaseYear());
            pstmt.setString(3, movie.getGenre());
            pstmt.setDouble(4, movie.getRating());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Movie getMovieById(int id) {
        String sql = "SELECT * FROM movie WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Movie(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getInt("release_year"),
                    rs.getString("genre"),
                    rs.getDouble("rating")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Movie> getAllMovies(int pageSize, int pageNumber) {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM movie LIMIT ? OFFSET ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, pageSize);
            pstmt.setInt(2, (pageNumber - 1) * pageSize);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                movies.add(new Movie(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getInt("release_year"),
                    rs.getString("genre"),
                    rs.getDouble("rating")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }

    @Override
    public List<Movie> getMoviesByCondition(String title, String genre, int releaseYear) {
        List<Movie> movies = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM movie WHERE 1=1");
        if (title != null && !title.isEmpty()) {
            sql.append(" AND title LIKE ?");
        }
        if (genre != null && !genre.isEmpty()) {
            sql.append(" AND genre LIKE ?");
        }
        if (releaseYear > 0) {
            sql.append(" AND release_year = ?");
        }
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql.toString());
            int index = 1;
            if (title != null && !title.isEmpty()) {
                pstmt.setString(index++, "%" + title + "%");
            }
            if (genre != null && !genre.isEmpty()) {
                pstmt.setString(index++, "%" + genre + "%");
            }
            if (releaseYear > 0) {
                pstmt.setInt(index++, releaseYear);
            }
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                movies.add(new Movie(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getInt("release_year"),
                    rs.getString("genre"),
                    rs.getDouble("rating")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }
    
        
    @Override
    public void updateMovie(Movie movie) {
        String sql = "UPDATE movie SET title = ?, release_year = ?, genre = ?, rating = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, movie.getTitle());
            pstmt.setInt(2, movie.getReleaseYear());
            pstmt.setString(3, movie.getGenre());
            pstmt.setDouble(4, movie.getRating());
            pstmt.setInt(5, movie.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        @Override
        public void deleteMovieById(int id) {
            String sql = "DELETE FROM movie WHERE id = ?";
            try {
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

}
