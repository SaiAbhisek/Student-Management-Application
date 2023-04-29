package com.abhiproject.studentmanagement.controller;


import com.abhiproject.studentmanagement.model.Book;
import com.abhiproject.studentmanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/book/student/{studentId}")
    public ResponseEntity<Book> createBook(@RequestBody Book book, @PathVariable Integer studentId){
        Book book1=this.bookService.createBook(book, studentId);
        return  new ResponseEntity<>(book1, HttpStatus.CREATED);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id){
        Book book=this.bookService.getBookById(id);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer id,@RequestBody Book book)
    {
        Book book1=this.bookService.updateBook(id,book);
        return new ResponseEntity<>(book1,HttpStatus.OK);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Integer id)
    {
        this.bookService.deleteBook(id);
        return ResponseEntity.ok(Map.of("message","Book details deleted successfully"));

    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books=this.bookService.getAllBooks();
        return new ResponseEntity<>(books,HttpStatus.OK);
    }
}
