package com.example.web_intro.mapper;

import com.example.web_intro.dto.employee.CreateEmployeeRequestDto;
import com.example.web_intro.dto.employee.EmployeeDto;
import com.example.web_intro.dto.employee.EmployeeWithoutSkillsDto;
import com.example.web_intro.model.Employee;

public class EmployeeMapperImpl implements EmployeeMapper {
    private final DepartmentMapper departmentMapper;
    private final SkillMapper skillMapper;

    public EmployeeMapperImpl(DepartmentMapper departmentMapper, SkillMapper skillMapper) {
        this.departmentMapper = departmentMapper;
        this.skillMapper = skillMapper;
    }


    @Override
    public EmployeeDto toDto(Employee employee) {
        if (employee == null) {
            return null;
        }
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setEmail(employee.getEmail());
        if (employee.getDepartment() != null) {
            employeeDto.setDepartmentId(employee.getDepartment().getId());
        }
        setSkillsIds(employeeDto, employee);
        return employeeDto;
    }

    @Override
    public EmployeeWithoutSkillsDto toEmployeeWithoutSkillsDto(Employee employee) {
        if (employee == null) {
            return null;
        }
        EmployeeWithoutSkillsDto employeeDto = new EmployeeWithoutSkillsDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setEmail(employee.getEmail());
        if (employee.getDepartment() != null) {
            employeeDto.setDepartmentId(employee.getDepartment().getId());
        }
        return employeeDto;
    }

    @Override
    public Employee toModel(CreateEmployeeRequestDto requestDto) {
        if (requestDto == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setName(requestDto.name());
        employee.setEmail(requestDto.email());
        employee.setDepartment(departmentMapper.departmentById(requestDto.departmentId()));
        setSkills(employee, requestDto);
        return employee;
    }
}
