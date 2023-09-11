package com.spring.college.controllers;

import com.spring.college.entities.Course;
import com.spring.college.services.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Operation(summary = "Add a new course", description = "Add a new course to the database")
    @PostMapping()
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @Operation(summary = "Update a course by id", description = "Update a course by id in the database")
    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course_updated) {
        return courseService.updateCourse(id, course_updated);
    }

    @Operation(summary = "Get all courses", description = "Get all courses from the database")
    @GetMapping()
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @Operation(summary = "Get all courses", description = "Get all courses from the database")
    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @Operation(summary = "Remove a course by id", description = "Remove a course by id from the database")
    @DeleteMapping("/{id}")
    public Course deleteCourseById(@PathVariable Long id) {
        return courseService.deleteCourseById(id);
    }




}
