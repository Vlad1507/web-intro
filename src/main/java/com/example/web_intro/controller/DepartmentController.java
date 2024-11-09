package com.example.web_intro.controller;

import com.example.web_intro.dto.department.CreateDepartmentRequestDto;
import com.example.web_intro.dto.department.DepartmentDto;
import com.example.web_intro.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping
    public DepartmentDto save(@RequestBody CreateDepartmentRequestDto requestDto) {
        return departmentService.save(requestDto);
    }

    @GetMapping("/all")
    public List<DepartmentDto> findAll() {
        return departmentService.findAll();
    }
}
