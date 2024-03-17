package com.fazil.rest.api.demo.rest;

import com.fazil.rest.api.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
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
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception){
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatusCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setDate(new Date());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exception){
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exception.getMessage());
        error.setDate(new Date());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
