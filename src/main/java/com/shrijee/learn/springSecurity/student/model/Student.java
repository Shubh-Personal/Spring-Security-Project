package com.shrijee.learn.springSecurity.student.model;

public class Student {
    private final Integer studentId;
    private final  String name;

    public Student(Integer studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }
}
