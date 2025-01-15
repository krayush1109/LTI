package com.wecp;

import com.wecp.connection.DatabaseConnection;
import com.wecp.dao.BookDAO;
import com.wecp.dao.BookDAOImpl;
import com.wecp.entity.Author;
import com.wecp.entity.Book;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/bookDB_wecp";
        String user = "root";
        String password = "hellowecp";

        Connection connection = DatabaseConnection.createConnection(dbUrl, user, password);
        BookDAO bookDAO = new BookDAOImpl(connection);

        // Add books
        Author author = new Author(1, "Vinothkumar");
        bookDAO.insertBook(new Book(1, "Java Programming", new Date(0), author));
        bookDAO.insertBook(new Book(2, "Advanced Java", new Date(0), author));
        bookDAO.insertBook(new Book(3, "Java for Beginners", new Date(0), author));
        bookDAO.insertBook(new Book(4, "Effective Java", new Date(0), author));
        bookDAO.insertBook(new Book(5, "Java Concurrency", new Date(0), author));

        // Fetch books by name
        List<Book> books = bookDAO.getBooksByName("Java");
        for (Book book : books) {
            System.out.println("Book ID: " + book.getBookId());
            System.out.println("Book Name: " + book.getBookName());
            System.out.println("Release Date: " + book.getBookReleaseDate());
            System.out.println("Author: " + book.getAuthor().getAuthorName());
            System.out.println();
        }
    }
}
