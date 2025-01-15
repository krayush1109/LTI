package com.wecp.dao;

import com.wecp.entity.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAOImpl implements AuthorDAO {
    private Connection connection;

    public AuthorDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addAuthor(Author author) throws SQLException {
        String sql = "INSERT INTO author (name, email, biography) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, author.getName());
            stmt.setString(2, author.getEmail());
            stmt.setString(3, author.getBiography());
            stmt.executeUpdate();
        }
    }

    @Override
    public Author getAuthorById(int id) throws SQLException {
        String sql = "SELECT * FROM author WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Author author = new Author();
                    author.setId(rs.getInt("id"));
                    author.setName(rs.getString("name"));
                    author.setEmail(rs.getString("email"));
                    author.setBiography(rs.getString("biography"));
                    return author;
                }
            }
        }
        return null;
    }

    @Override
    public List<Author> getAllAuthors() throws SQLException {
        List<Author> authors = new ArrayList<>();
        String sql = "SELECT * FROM author";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Author author = new Author();
                author.setId(rs.getInt("id"));
                author.setName(rs.getString("name"));
                author.setEmail(rs.getString("email"));
                author.setBiography(rs.getString("biography"));
                authors.add(author);
            }
        }
        return authors;
    }

    @Override
    public void updateAuthor(Author author) throws SQLException {
        String sql = "UPDATE author SET name = ?, email = ?, biography = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, author.getName());
            stmt.setString(2, author.getEmail());
            stmt.setString(3, author.getBiography());
            stmt.setInt(4, author.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteAuthor(int id) throws SQLException {
        String sql = "DELETE FROM author WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}