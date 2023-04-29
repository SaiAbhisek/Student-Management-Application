package com.abhiproject.studentmanagement.service;

import com.abhiproject.studentmanagement.model.Book;

import java.util.List;

public interface BookService {
    Book createBook(Book book,Integer studentId);
    Book getBookById(Integer id);
    Book updateBook(Integer id,Book book);
    List<Book> getAllBooks();
    void deleteBook(Integer id);
}
