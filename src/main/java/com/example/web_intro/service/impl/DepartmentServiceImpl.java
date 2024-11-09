package com.example.web_intro.service.impl;

import com.example.web_intro.dto.department.CreateDepartmentRequestDto;
import com.example.web_intro.dto.department.DepartmentDto;
import com.example.web_intro.mapper.DepartmentMapper;
import com.example.web_intro.model.Department;
import com.example.web_intro.repository.DepartmentRepository;
import com.example.web_intro.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository repository;
    private final DepartmentMapper mapper;

    @Override
    public List<DepartmentDto> findAll() {
        return repository.getAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public DepartmentDto save(CreateDepartmentRequestDto requestDto) {
        Department department = mapper.toModel(requestDto);
        return mapper.toDto(repository.save(department));
    }
}
