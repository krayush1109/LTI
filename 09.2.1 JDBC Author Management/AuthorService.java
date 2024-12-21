package com.wecp.service;

import com.wecp.entity.Author;

import java.sql.*;
import java.util.List;

public interface AuthorService {
    /**
     * Adds a new author to the database.
     * @param author the author to be added
     * @throws SQLException if a database access error occurs
     */
    void addAuthor(Author author) throws SQLException;

    /**
     * Retrieves an author by their ID.
     * @param id the ID of the author
     * @return the author with the specified ID
     * @throws SQLException if a database access error occurs
     */
    Author getAuthorById(int id) throws SQLException;

    /**
     * Retrieves all authors from the database.
     * @return a list of all authors
     * @throws SQLException if a database access error occurs
     */
    List<Author> getAllAuthors() throws SQLException;

    /**
     * Updates an existing author in the database.
     * @param author the author with updated information
     * @throws SQLException if a database access error occurs
     */
    void updateAuthor(Author author) throws SQLException;

    /**
     * Deletes an author from the database by their ID.
     * @param id the ID of the author to be deleted
     * @throws SQLException if a database access error occurs
     */
    void deleteAuthor(int id) throws SQLException;
}