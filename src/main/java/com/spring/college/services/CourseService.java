package com.spring.college.services;

import com.spring.college.entities.Course;
import com.spring.college.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course addCourse(Course course) {
        if(Objects.isNull(course.getName())) throw new RuntimeException("Course name is required");
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course course_updated) {
        Course course_exists = courseRepository.findById(id).orElse(null);

        if(Objects.isNull(course_exists)) throw new RuntimeException("Course not found");
        if(Objects.isNull(course_updated.getName())) throw new RuntimeException("Course name is required");

        course_exists.setName(course_updated.getName());
        course_exists.setStudents(course_updated.getStudents());

        return courseRepository.save(course_exists);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        Course course = courseRepository.findById(id).orElse(null);
        if(Objects.isNull(course)) throw new RuntimeException("Course not found");
        return course;
    }

    public Course deleteCourseById(Long id) {
        Course course = courseRepository.findById(id).orElse(null);
        if(Objects.isNull(course)) throw new RuntimeException("Course not found");
        courseRepository.deleteById(id);
        return course;
    }

}
