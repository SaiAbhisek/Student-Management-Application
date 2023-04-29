package com.abhiproject.studentmanagement.service.impl;

import com.abhiproject.studentmanagement.exception.ResourceNotFoundException;
import com.abhiproject.studentmanagement.model.Student;
import com.abhiproject.studentmanagement.model.Course;
import com.abhiproject.studentmanagement.repository.CourseRepo;
import com.abhiproject.studentmanagement.repository.StudentRepo;
import com.abhiproject.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public Student saveStudent(Student student,Integer courseId) {
        Course course=this.courseRepo.findById(courseId).orElseThrow(()->new ResourceNotFoundException("Course not found with the id you mentioned"));
        student.getCourses().add(course);
        Student student1=this.studentRepo.save(student);
        return student1;
    }

    @Override
    public Student getStudentById(Integer studentId) {
        Student student=this.studentRepo.findById(studentId).orElseThrow(()->new ResourceNotFoundException("Student Not Found with the Id you mentioned"));

        return student;
    }

    @Override
    public Student updateStudent(Integer studentId, Student student) {
        Student student1=this.studentRepo.findById(studentId).orElseThrow(()->new ResourceNotFoundException("Student Not Found with the Id you mentioned"));
        student1.setName(student.getName());
        student1.setPhoneNo(student.getPhoneNo());
        student1.setBranch(student.getBranch());
        student1.setAge(student.getAge());
        student1.setAddress(student.getAddress());
        Student updatedStudent=this.studentRepo.save(student1);
        return updatedStudent;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students=this.studentRepo.findAll();
        return students;
    }

    @Override
    public void deleteStudent(Integer studentId) {
        Student student=this.studentRepo.findById(studentId).orElseThrow(()->new ResourceNotFoundException("student not found with the id you mentioned"));
        this.studentRepo.delete(student);
    }


}
