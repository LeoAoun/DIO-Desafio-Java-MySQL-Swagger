package com.spring.college.services;

import com.spring.college.entities.Course;
import com.spring.college.entities.Student;
import com.spring.college.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        if(Objects.isNull(student.getFirst_name()) || Objects.isNull(student.getLast_name())) throw new RuntimeException("Student first name and last name are required");
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student student_updated) {
        Student student_exists = studentRepository.findById(id).orElse(null);

        if(Objects.isNull(student_exists)) throw new RuntimeException("Student not found");
        if(Objects.isNull(student_updated.getFirst_name()) || Objects.isNull(student_updated.getLast_name())) throw new RuntimeException("Student first name and last name are required");

        student_exists.setFirst_name(student_updated.getFirst_name());
        student_exists.setLast_name(student_updated.getLast_name());
        student_exists.setDepartment(student_updated.getDepartment());
        student_exists.setCourses(student_updated.getCourses());

        return studentRepository.save(student_exists);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if(Objects.isNull(student)) throw new RuntimeException("Student not found");
        return student;
    }

    public List<Course> getCoursesByStudent(Long id) {
        return studentRepository.getCoursesByStudent(id);
    }

    public Student removeStudentById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if(Objects.isNull(student)) throw new RuntimeException("Student not found");
        studentRepository.deleteById(id);
        return student;
    }

}
