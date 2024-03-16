package com.fazil.rest.api.demo.rest;

import com.fazil.rest.api.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    @GetMapping("/students")
    public List<Student> studentList(){
        List<Student> theStudents = new ArrayList<>();
        theStudents.add(new Student("Taylor","Swift"));
        theStudents.add(new Student("Zayn","Malik"));
        theStudents.add(new Student("Justin","Bieber"));

        return theStudents;
    }
}
