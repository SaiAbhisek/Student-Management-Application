package com.abhiproject.studentmanagement.service.impl;

import com.abhiproject.studentmanagement.exception.ResourceNotFoundException;
import com.abhiproject.studentmanagement.model.Course;
import com.abhiproject.studentmanagement.model.Student;
import com.abhiproject.studentmanagement.repository.CourseRepo;
import com.abhiproject.studentmanagement.repository.StudentRepo;
import com.abhiproject.studentmanagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Course createCourse(Course course) {
        Course course1=this.courseRepo.save(course);
        return course1;
    }

    @Override
    public Course updateCourse(Integer id, Course course) {
        Course course1=this.courseRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Course not found with the id you mentioned"));
        course1.setTitle(course.getTitle());
        course1.setDuration(course.getDuration());
        course1.setDescription(course.getDescription());
        Course updatedCourse=this.courseRepo.save(course1);
        return updatedCourse;
    }

    @Override
    public Course getCourseById(Integer id) {
        Course course=this.courseRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Course not found with the id you provided"));
        return course;
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses=this.courseRepo.findAll();
        return courses;
    }

    @Override
    public void deleteCourse(Integer id) {
        Course course=this.courseRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Course not found with the id you mentioned"));
        this.courseRepo.delete(course);
    }
}
