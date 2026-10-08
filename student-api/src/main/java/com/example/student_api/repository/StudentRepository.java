package com.example.student_api.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.student_api.model.Student;

@Repository
public class StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // CREATE
    public int save(Student student) {

        String sql = """
                INSERT INTO students
                (name, email, course, age)
                VALUES (?, ?, ?, ?)
                """;

        return jdbcTemplate.update(
                sql,
                student.getName(),
                student.getEmail(),
                student.getCourse(),
                student.getAge()
        );
    }

    // READ ALL
    public List<Student> findAll() {

        String sql = "SELECT * FROM students";

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> {

                    Student student = new Student();

                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setEmail(rs.getString("email"));
                    student.setCourse(rs.getString("course"));
                    student.setAge(rs.getInt("age"));

                    return student;
                }
        );
    }

    // READ BY ID
    public Student findById(int id) {

        String sql = "SELECT * FROM students WHERE id = ?";

        return jdbcTemplate.queryForObject(
                sql,
                (rs, rowNum) -> {

                    Student student = new Student();

                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setEmail(rs.getString("email"));
                    student.setCourse(rs.getString("course"));
                    student.setAge(rs.getInt("age"));

                    return student;
                },
                id
        );
    }

    // UPDATE
    public int update(int id, Student student) {

        String sql = """
                UPDATE students
                SET name = ?,
                    email = ?,
                    course = ?,
                    age = ?
                WHERE id = ?
                """;

        return jdbcTemplate.update(
                sql,
                student.getName(),
                student.getEmail(),
                student.getCourse(),
                student.getAge(),
                id
        );
    }

    // DELETE
    public int delete(int id) {

        String sql = "DELETE FROM students WHERE id = ?";

        return jdbcTemplate.update(sql, id);
    }
}