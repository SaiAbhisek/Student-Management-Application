package com.abhiproject.studentmanagement.service;

import com.abhiproject.studentmanagement.model.Course;

import java.util.List;

public interface CourseService {

    Course createCourse(Course course);
    Course updateCourse(Integer id,Course course);
    Course getCourseById(Integer id);
    List<Course> getAllCourses();
    void deleteCourse(Integer id);
}
