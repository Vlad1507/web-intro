package com.example.web_intro.dto.employee;

import lombok.Data;

@Data
public class EmployeeWithoutSkillsDto {
    private Long id;
    private String name;
    private String email;
    private Long departmentId;
}
