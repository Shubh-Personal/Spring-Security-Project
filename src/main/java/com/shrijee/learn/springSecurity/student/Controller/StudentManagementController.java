package com.shrijee.learn.springSecurity.student.Controller;

import com.shrijee.learn.springSecurity.student.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/management/api/student")
public class StudentManagementController {

    List<Student> registeredStudents;

    public StudentManagementController()
    {
        registeredStudents = Arrays.asList(
                new Student(1,"Demo1"),
                new Student(2,"Demo2"),
                new Student(3,"Demo3"),
                new Student(4,"Demo4"),
                new Student(5,"Demo5"),
                new Student(6,"Demo6")
        );

    }

    @GetMapping("/")
    ResponseEntity<List<Student>> getAllStudents()
    {
        return ResponseEntity.ok(registeredStudents);
    }

    @GetMapping("/{studentId}")
    ResponseEntity<Student> getStudentByStudentId(@PathVariable("studentId") int studentId)
    {
        Student student = registeredStudents.stream()
                .filter(s->s.getStudentId().equals(studentId))
                .findFirst()
                .orElseThrow(()->new IllegalStateException("Something went wrong!"));
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{studentId}")
    ResponseEntity<?> deleteStudentByStudentId(@PathVariable("studentId") int studentId)
    {
        registeredStudents.remove(
                registeredStudents.stream()
                        .filter((s)->s.getStudentId().equals(studentId))
                        .findFirst()
                        .orElseThrow(()->new IllegalStateException("Something went wrong!"))
        );
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{studentId}")
    ResponseEntity<?> deleteStudentByStudentId(@PathVariable("studentId") int studentId,
                                               @RequestBody Student updateStudent)
    {
        registeredStudents.remove(
                registeredStudents.stream()
                        .filter((s)->s.getStudentId().equals(studentId))
                        .findFirst()
                        .orElseThrow(()->new IllegalStateException("Something went wrong!"))
        );
        registeredStudents.add(updateStudent);
        return ResponseEntity.ok().build();
    }

}
