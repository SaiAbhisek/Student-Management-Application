package com.abhiproject.studentmanagement.controller;


import com.abhiproject.studentmanagement.model.Student;
import com.abhiproject.studentmanagement.service.StudentService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student/{courseId}")
    public ResponseEntity<Student> saveDoctor(@Valid @RequestBody Student student, @PathVariable Integer courseId){
        Student student1=this.studentService.saveStudent(student,courseId);
        return new ResponseEntity<>(student1, HttpStatus.CREATED);
    }

    @PutMapping("/student/{studentId}")
    public ResponseEntity<Student> updateStudent( @PathVariable Integer studentId,@Valid @RequestBody Student student){
        Student student1= studentService.updateStudent(studentId,student);
        return new ResponseEntity<>(student1,HttpStatus.OK);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable  Integer studentId)
    {
        Student student=this.studentService.getStudentById(studentId);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> studentList=this.studentService.getAllStudents();
        return new ResponseEntity<>(studentList,HttpStatus.OK);
    }

    @DeleteMapping("/student/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer studentId){
        this.studentService.deleteStudent(studentId);
        return ResponseEntity.ok(Map.of("message","Student details are deleted successfully"));
    }

}
