package com.wecp.entity;


import java.sql.Date;

// import java.util.Date;

public class Book {
    private int bookId;
    private String bookName;
    private Date bookReleaseDate;
    private Author author;

    public Book(int bookId, String bookName, Date bookReleaseDate, Author author) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookReleaseDate = bookReleaseDate;
        this.author = author;
    }

    public Book() {}

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getBookReleaseDate() {
        return bookReleaseDate;
    }

    public void setBookReleaseDate(Date bookReleaseDate) {
        this.bookReleaseDate = bookReleaseDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}