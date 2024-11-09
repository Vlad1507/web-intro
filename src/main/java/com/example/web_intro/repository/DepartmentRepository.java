package com.example.web_intro.repository;

import com.example.web_intro.model.Department;

import java.util.List;

public interface DepartmentRepository {
    List<Department> getAll();

    Department save(Department department);
}
