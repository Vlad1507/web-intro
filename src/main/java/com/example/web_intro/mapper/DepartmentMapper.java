package com.example.web_intro.mapper;

import com.example.web_intro.config.MapperConfig;
import com.example.web_intro.dto.department.CreateDepartmentRequestDto;
import com.example.web_intro.dto.department.DepartmentDto;
import com.example.web_intro.model.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.Optional;

@Mapper(config = MapperConfig.class)
public interface DepartmentMapper {
    DepartmentDto toDto(Department department);

    Department toModel(CreateDepartmentRequestDto requestDto);

    @Named("departmentById")
    default Department departmentById(Long id) {
        return Optional.ofNullable(id)
                .map(Department::new)
                .orElse(null);
    }
}
