package com.example.web_intro.controller;

import com.example.web_intro.dto.employee.CreateEmployeeRequestDto;
import com.example.web_intro.dto.employee.EmployeeDto;
import com.example.web_intro.dto.employee.EmployeeWithoutSkillsDto;
import com.example.web_intro.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public EmployeeDto save(@RequestBody CreateEmployeeRequestDto requestDto) {
        return employeeService.save(requestDto);
    }

    @GetMapping("/all")
    public List<EmployeeWithoutSkillsDto> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public EmployeeWithoutSkillsDto findById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @GetMapping("/by-name")
    public List<EmployeeWithoutSkillsDto> getAllByName(@RequestParam String name) {
        return employeeService.getAllByName(name);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        employeeService.deleteById(id);
    }
}
