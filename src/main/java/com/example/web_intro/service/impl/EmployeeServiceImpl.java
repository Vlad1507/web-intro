package com.example.web_intro.service.impl;

import com.example.web_intro.dto.employee.CreateEmployeeRequestDto;
import com.example.web_intro.dto.employee.EmployeeDto;
import com.example.web_intro.dto.employee.EmployeeWithoutSkillsDto;
import com.example.web_intro.exception.EntityNotFoundException;
import com.example.web_intro.mapper.EmployeeMapper;
import com.example.web_intro.model.Employee;
import com.example.web_intro.repository.EmployeeRepository;
import com.example.web_intro.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeDto save(CreateEmployeeRequestDto requestDto) {
        Employee employee = employeeMapper.toModel(requestDto);
        employee.setSocialSecurityNumber("xyz" + new Random().nextInt(20000));
        return employeeMapper.toDto(employeeRepository.save(employee));
    }

    @Override
    public List<EmployeeWithoutSkillsDto> getAll() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::toEmployeeWithoutSkillsDto)
                .toList();
    }

    @Override
    public EmployeeWithoutSkillsDto findById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find employee by id: " + id)
        );
        return employeeMapper.toEmployeeWithoutSkillsDto(employee);
    }

    @Override
    public List<EmployeeWithoutSkillsDto> getAllByName(String name) {
        return employeeRepository.findAllByNameContainsIgnoreCase(name).stream()
                .map(employeeMapper::toEmployeeWithoutSkillsDto)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
