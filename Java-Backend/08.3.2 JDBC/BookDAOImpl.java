package com.wecp.dao;


import com.wecp.entity.Author;
import com.wecp.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    private Connection connection;

    public BookDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertBook(Book book) {
        // String query = "INSERT INTO Authors (authorId, authorName) VALUES (?, ?)";
        // try {
        //     PreparedStatement ps = connection.prepareStatement(query);
        //     Author a = new Author(1, "Monkey");
        //     ps.setInt(1, a.getAuthorId());
        //     ps.setString(2, a.getAuthorName());

        //     ps.executeUpdate();
        //     book.setAuthor(a);
        // } catch (Exception e) {
        //     // TODO: handle exception
        //     e.printStackTrace();
        // }

        String sql = "INSERT INTO Books (bookName, bookReleaseDate, authorId) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, book.getBookName());
            pstmt.setDate(2, new java.sql.Date(book.getBookReleaseDate().getTime()));
            pstmt.setInt(3, book.getAuthor().getAuthorId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> getBooksByName(String bookName) {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT b.bookId, b.bookName, b.bookReleaseDate, a.authorId, a.authorName " +
                     "FROM Books b JOIN Authors a ON b.authorId = a.authorId " +
                     "WHERE b.bookName LIKE ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, "%" + bookName + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int bookId = rs.getInt("bookId");
                String name = rs.getString("bookName");
                Date releaseDate = rs.getDate("bookReleaseDate");
                int authorId = rs.getInt("authorId");
                String authorName = rs.getString("authorName");
                Author author = new Author(authorId, authorName);
                Book book = new Book(bookId, name, releaseDate, author);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}