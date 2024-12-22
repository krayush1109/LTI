package com.wecp.entity;


import java.sql.Date;

public class Movie {
   
    private int movieId;
    private String movieName;
    private Date movieReleaseDate;
    private Director director;

    public Movie() {}

    public Movie(int movieId, String movieName, Date movieReleaseDate, Director director) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieReleaseDate = movieReleaseDate;
        this.director = director;
    }
    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    public String getMovieName() {
        return movieName;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public Date getMovieReleaseDate() {
        return movieReleaseDate;
    }
    public void setMovieReleaseDate(Date movieReleaseDate) {
        this.movieReleaseDate = movieReleaseDate;
    }
    public Director getDirector() {
        return director;
    }
    public void setDirector(Director director) {
        this.director = director;
    }

    

}
