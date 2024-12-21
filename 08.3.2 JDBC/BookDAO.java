package com.wecp.dao;


import com.wecp.entity.Book;

import java.sql.SQLException;
import java.util.List;


public interface BookDAO {
    void insertBook(Book book);
    List<Book> getBooksByName(String bookName);
}