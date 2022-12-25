package com.shrijee.learn.springSecurity.student.Controller;

import com.shrijee.learn.springSecurity.student.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1,"Shubh"),
            new Student(2,"Goldy"),
            new Student(3,"Darshan"),
            new Student(4,"Sudhir")
    );
    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId)
    {
        return STUDENTS.stream()
                .filter(student -> studentId.equals(student.getStudentId()) )
                .findFirst()
                .orElseThrow(()->new IllegalStateException("Something went Wrong"));
    }
}
