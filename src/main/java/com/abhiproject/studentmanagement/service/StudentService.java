package com.abhiproject.studentmanagement.service;

import com.abhiproject.studentmanagement.model.Student;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student, Integer courseId);

    Student getStudentById(Integer studentId);

    Student updateStudent(Integer studentId, Student student);

    List<Student> getAllStudents();

    void deleteStudent(Integer studentId);

}
