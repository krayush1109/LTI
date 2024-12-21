package com.wecp.service;

import com.wecp.dao.AuthorDAO;
import com.wecp.entity.Author;

import java.sql.SQLException;
import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    private AuthorDAO authorDAO;

    public AuthorServiceImpl(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    @Override
    public void addAuthor(Author author) throws SQLException {
        // Validate email format and uniqueness
        if (!author.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        List<Author> authors = authorDAO.getAllAuthors();
        for (Author existingAuthor : authors) {
            if (existingAuthor.getEmail().equals(author.getEmail())) {
                throw new IllegalArgumentException("Email already exists");
            }
        }
        authorDAO.addAuthor(author);
    }

    @Override
    public Author getAuthorById(int id) throws SQLException {
        return authorDAO.getAuthorById(id);
    }

    @Override
    public List<Author> getAllAuthors() throws SQLException {
        return authorDAO.getAllAuthors();
    }

    @Override
    public void updateAuthor(Author author) throws SQLException {
        authorDAO.updateAuthor(author);
    }

    @Override
    public void deleteAuthor(int id) throws SQLException {
        authorDAO.deleteAuthor(id);
    }
}
