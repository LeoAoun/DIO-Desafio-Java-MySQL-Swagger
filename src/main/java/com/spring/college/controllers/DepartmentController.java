package com.spring.college.controllers;

import com.spring.college.entities.Department;
import com.spring.college.entities.Student;
import com.spring.college.services.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Operation(summary = "Add a new department", description = "Add a new department to the database")
    @PostMapping()
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

    @Operation(summary = "Update a department by id", description = "Update a department by id in the database")
    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department_updated) {
        return departmentService.updateDepartment(id, department_updated);
    }

    @Operation(summary = "Get all departments", description = "Get all departments from the database")
    @GetMapping()
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @Operation(summary = "Get a department by id", description = "Get a department by id from the database")
    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable("id") Long id) {
        return departmentService.getDepartmentById(id);
    }

    @Operation(summary = "Get all students by department", description = "Get all students by department from the database")
    @GetMapping("/{id}/students")
    public List<Student> getStudentsByDepartments(@PathVariable("id") Long id) {
        return departmentService.getStudentsByDepartments(id);
    }

    @Operation(summary = "Remove a department by id", description = "Remove a department by id from the database")
    @DeleteMapping("/{id}")
    public Department deleteDepartmentById(@PathVariable("id") Long id) {
        return departmentService.deleteDepartmentById(id);
    }

}
