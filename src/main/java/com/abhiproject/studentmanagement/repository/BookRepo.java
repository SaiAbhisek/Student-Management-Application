package com.abhiproject.studentmanagement.repository;

import com.abhiproject.studentmanagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Integer> {
}
