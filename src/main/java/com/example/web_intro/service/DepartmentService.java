package com.example.web_intro.service;

import com.example.web_intro.dto.department.CreateDepartmentRequestDto;
import com.example.web_intro.dto.department.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDto> findAll();
    DepartmentDto save(CreateDepartmentRequestDto requestDto);
}
