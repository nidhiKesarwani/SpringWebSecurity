package org.nidhi.websecurity.controller;

import org.nidhi.websecurity.model.Student;
import org.nidhi.websecurity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
       return studentService.getAllStudents();
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        Optional<Student> student = studentService.getStudentById(id);
        return student.orElse(null);
    }

}
