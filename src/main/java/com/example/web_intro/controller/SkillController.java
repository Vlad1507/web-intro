package com.example.web_intro.controller;

import com.example.web_intro.dto.skill.CreateRequestSkillDto;
import com.example.web_intro.dto.skill.SkillDto;
import com.example.web_intro.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/skills")
public class SkillController {
    private final SkillService skillService;

    @PostMapping
    public SkillDto save(@RequestBody CreateRequestSkillDto requestSkillDto) {
        return skillService.save(requestSkillDto);
    }

    @GetMapping
    public List<SkillDto> findAll() {
        return skillService.findAll();
    }
}
