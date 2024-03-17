package com.fazil.rest.api.demo.rest;

import com.fazil.rest.api.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Taylor", "Swift"));
        theStudents.add(new Student("Zayn", "Malik"));
        theStudents.add(new Student("Justin", "Bieber"));
        theStudents.add(new Student("Ariana", "Grande"));

    }

    @GetMapping("/students")
    public List<Student> studentList() {
        return theStudents;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if (studentId >= theStudents.size() || studentId < 0) {
           throw new StudentNotFoundException("Student ID of "+studentId+" NOT FOUND");
        } else {
            return theStudents.get(studentId);
        }
    }
}
