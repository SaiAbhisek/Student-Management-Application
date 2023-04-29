package com.abhiproject.studentmanagement.service.impl;

import com.abhiproject.studentmanagement.exception.ResourceNotFoundException;
import com.abhiproject.studentmanagement.model.Book;
import com.abhiproject.studentmanagement.model.Student;
import com.abhiproject.studentmanagement.repository.BookRepo;
import com.abhiproject.studentmanagement.repository.StudentRepo;
import com.abhiproject.studentmanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Book createBook(Book book,Integer studentId) {
        Student student=this.studentRepo.findById(studentId).orElseThrow(()->new ResourceNotFoundException("Student not found with the id you mentioned"));
        book.setStudent(student);
        Book book1=this.bookRepo.save(book);

        return book1;
    }

    @Override
    public Book getBookById(Integer id) {
        Book book=this.bookRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Book not found with the id you mentioned"));

        return book;
    }

    @Override
    public Book updateBook(Integer id, Book book) {
        Book book1=this.bookRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Book not found with the id you mentioned"));
        book1.setAuthor(book.getAuthor());
        book1.setDescription(book.getDescription());
        book1.setPrice(book.getPrice());
        book1.setTitle(book.getTitle());
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return this.bookRepo.findAll();
    }

    @Override
    public void deleteBook(Integer id) {
        Book book=this.bookRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Book not found with the id you mentioned"));
        this.bookRepo.delete(book);
    }
}
