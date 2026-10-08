package com.example.student_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.student_api.model.Student;
import com.example.student_api.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public int createStudent(Student student) {

        return repository.save(student);
    }

    // READ ALL
    public List<Student> getAllStudents() {

        return repository.findAll();
    }

    // READ BY ID
    public Student getStudentById(int id) {

        return repository.findById(id);
    }

    // UPDATE
    public int updateStudent(int id, Student student) {

        return repository.update(id, student);
    }

    // DELETE
    public int deleteStudent(int id) {

        return repository.delete(id);
    }
}