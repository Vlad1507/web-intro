package com.example.web_intro.dto.employee;

import lombok.Data;

import java.util.List;

@Data
public class EmployeeDto {
    private Long id;
    private String name;
    private String email;
    private Long departmentId;
    private List<Long> skillIds;
}
