package com.abhiproject.studentmanagement.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer studentId;

    @NotEmpty
    private String name;
    private Integer age;

    @NotEmpty
    @Size(max = 10,min = 10,message = "please enter a valid mobile number")
    private String phoneNo;
    private String branch;
    private String address;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Course.class)
            @JoinTable(name = "student_course_table", joinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "studentId")
            },inverseJoinColumns = {@JoinColumn(name = "course_id",referencedColumnName = "courseId")})
    private List<Course> courses=new ArrayList<>();
}
