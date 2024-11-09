package com.example.web_intro.mapper;

import com.example.web_intro.config.MapperConfig;
import com.example.web_intro.dto.employee.CreateEmployeeRequestDto;
import com.example.web_intro.dto.employee.EmployeeDto;
import com.example.web_intro.dto.employee.EmployeeWithoutSkillsDto;
import com.example.web_intro.model.Employee;
import com.example.web_intro.model.Skill;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(config = MapperConfig.class, uses = DepartmentMapper.class)
public  interface EmployeeMapper {
    @Mapping(source = "department.id", target = "departmentId")
    @Mapping(target = "skillIds", ignore = true)
    EmployeeDto toDto(Employee employee);

    @AfterMapping
    default void setSkillsIds(@MappingTarget EmployeeDto employeeDto,  Employee employee) {
        List<Long> skillsIds = employee.getSkills().stream()
                .map(Skill::getId)
                .toList();
        employeeDto.setSkillIds(skillsIds);
    }

    @Mapping(source = "department.id", target = "departmentId")
    EmployeeWithoutSkillsDto toEmployeeWithoutSkillsDto(Employee employee);

    @Mapping(target = "department", source = "departmentId", qualifiedByName = "departmentById")
    @Mapping(target = "skills", ignore = true)
    Employee toModel(CreateEmployeeRequestDto requestDto);

    @AfterMapping
    default void setSkills(@MappingTarget Employee employee, CreateEmployeeRequestDto requestDto) {
        List<Skill> skills = requestDto.skills().stream()
                .map(Skill::new)
                .toList();
        employee.setSkills(skills);
    }
}
