package com.spring.college.services;

import com.spring.college.entities.Department;
import com.spring.college.entities.Student;
import com.spring.college.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department addDepartment(Department department) {
        if (Objects.isNull(department.getName())) throw new RuntimeException("Department name is required");
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Long id, Department department_updated) {
        Department department_exists = departmentRepository.findById(id).orElse(null);

        if (Objects.isNull(department_exists)) throw new RuntimeException("Department not found");
        if (Objects.isNull(department_updated.getName())) throw new RuntimeException("Department name is required");

        department_exists.setName(department_updated.getName());
        department_exists.setStudents(department_updated.getStudents());

        return departmentRepository.save(department_exists);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id).orElse(null);
        if (Objects.isNull(department)) throw new RuntimeException("Department not found");
        return department;
    }

    public List<Student> getStudentsByDepartments(Long id) {
        return departmentRepository.getStudentsByDepartments(id);
    }

    public Department deleteDepartmentById(Long id) {
        Department department = departmentRepository.findById(id).orElse(null);
        if (Objects.nonNull(department)) departmentRepository.deleteById(id);
        return department;
    }

}
