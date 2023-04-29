package com.abhiproject.studentmanagement.controller;

import com.abhiproject.studentmanagement.model.Course;
import com.abhiproject.studentmanagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/course")
    public ResponseEntity<Course> createCourse(@RequestBody Course course)
    {
        Course course1=this.courseService.createCourse(course);
        return new ResponseEntity<>(course1, HttpStatus.CREATED);
    }

    @PutMapping("/course/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Integer id,@RequestBody Course course){
        Course course1=this.courseService.updateCourse(id,course);
        return new ResponseEntity<>(course1,HttpStatus.OK);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Integer id)
    {
        Course course=this.courseService.getCourseById(id);
        return new ResponseEntity<>(course,HttpStatus.OK);
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses()
    {
        List<Course> courses=this.courseService.getAllCourses();
        return new ResponseEntity<>(courses,HttpStatus.OK);
    }

    @DeleteMapping("/course/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id)
    {
        this.courseService.deleteCourse(id);
        return ResponseEntity.ok(Map.of("message","Course deleted successfully"));
    }
}
