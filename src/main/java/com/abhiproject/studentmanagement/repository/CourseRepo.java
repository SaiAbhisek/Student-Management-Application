package com.abhiproject.studentmanagement.repository;

import com.abhiproject.studentmanagement.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Integer> {
}
