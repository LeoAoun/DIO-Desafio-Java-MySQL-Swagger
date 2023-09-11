package com.spring.college.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="STUDENT_TBL")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;
    private String last_name;

    //@ManyToOne(fetch=FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;

    @ManyToMany
    @JoinTable(
        name="STUDENT_COURSE_TBL",
        joinColumns = @JoinColumn(name="student_id"),
        inverseJoinColumns = @JoinColumn(name="course_id")
    )
    private List<Course> courses = new ArrayList<>();



}
