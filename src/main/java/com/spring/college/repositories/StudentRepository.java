package com.spring.college.repositories;

import com.spring.college.entities.Course;
import com.spring.college.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s.courses FROM Student s WHERE s.id = :id")
    public List<Course> getCoursesByStudent(@Param("id") Long id);
}
