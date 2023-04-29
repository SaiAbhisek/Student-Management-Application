package com.abhiproject.studentmanagement.repository;

import com.abhiproject.studentmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StudentRepo extends JpaRepository<Student,Integer> {

}
