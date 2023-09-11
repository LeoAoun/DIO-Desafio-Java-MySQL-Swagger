package com.spring.college.repositories;

import com.spring.college.entities.Department;
import com.spring.college.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    //@Query("SELECT Department.students FROM Department WHERE Department.id = :id")
    @Query("SELECT d.students FROM Department d WHERE d.id = :id")
    List<Student> getStudentsByDepartments(@Param("id") Long id);

}
