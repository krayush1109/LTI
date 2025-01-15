package com.wecp.entity;

public class Movie {
    private int id;
    private String title;
    private int releaseYear;
    private String genre;
    private double rating;    

    public Movie(){}
    
    public Movie(int id, String title, int releaseYear, String genre, double rating) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.rating = rating;                
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public int getReleaseYear() {
        return releaseYear;
    }
    
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public double getRating() {
        return rating;
    }
    
    public void setRating(double rating) {
        this.rating = rating;
    }

}
