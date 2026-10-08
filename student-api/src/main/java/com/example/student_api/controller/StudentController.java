package com.example.student_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.student_api.model.Student;
import com.example.student_api.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<String> createStudent(
            @RequestBody Student student) {

        service.createStudent(student);

        return ResponseEntity.ok("Student created successfully");
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {

        return ResponseEntity.ok(
                service.getAllStudents()
        );
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(
            @PathVariable int id) {

        return ResponseEntity.ok(
                service.getStudentById(id)
        );
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(
            @PathVariable int id,
            @RequestBody Student student) {

        service.updateStudent(id, student);

        return ResponseEntity.ok("Student updated successfully");
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(
            @PathVariable int id) {

        service.deleteStudent(id);

        return ResponseEntity.ok("Student deleted successfully");
    }
}