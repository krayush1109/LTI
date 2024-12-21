package com.wecp.dao;

import com.wecp.entity.Author;

import java.sql.SQLException;
import java.util.List;

public interface AuthorDAO {
    void addAuthor(Author author) throws SQLException;
    Author getAuthorById(int id) throws SQLException;
    List<Author> getAllAuthors() throws SQLException;
    void updateAuthor(Author author) throws SQLException;
    void deleteAuthor(int id) throws SQLException;
}
