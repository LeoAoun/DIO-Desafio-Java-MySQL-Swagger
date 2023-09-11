package com.spring.college.controllers;


import com.spring.college.entities.Course;
import com.spring.college.entities.Student;
import com.spring.college.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Operation(summary = "Add a new student", description = "Add a new student to the database")
    @PostMapping()
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @Operation(summary = "Update a student by id", description = "Update a student by id in the database")
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student_updated) {
        return studentService.updateStudent(id, student_updated);
    }

    @Operation(summary = "Get all students", description = "Get all students from the database")
    @GetMapping()
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @Operation(summary = "Get a student by id", description = "Get a student by id from the database")
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") Long id) {
        return studentService.getStudentById(id);
    }

    @Operation(summary = "Get all courses by student", description = "Get all courses by student from the database")
    @GetMapping("/{id}/courses")
    public List<Course> getCoursesByStudent(@PathVariable("id") Long id) {
        return studentService.getCoursesByStudent(id);
    }

    @Operation(summary = "Remove a student by id", description = "Remove a student by id from the database")
    @DeleteMapping("/{id}")
    public Student removeStudentById(@PathVariable("id") Long id) {
        return studentService.removeStudentById(id);
    }


}
