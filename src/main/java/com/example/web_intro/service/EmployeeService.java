package com.example.web_intro.service;

import com.example.web_intro.dto.employee.CreateEmployeeRequestDto;
import com.example.web_intro.dto.employee.EmployeeDto;
import com.example.web_intro.dto.employee.EmployeeWithoutSkillsDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto save(CreateEmployeeRequestDto requestDto);

    List<EmployeeWithoutSkillsDto> getAll();

    EmployeeWithoutSkillsDto findById(Long id);

    List<EmployeeWithoutSkillsDto> getAllByName(String name);

    void deleteById(Long id);
}
