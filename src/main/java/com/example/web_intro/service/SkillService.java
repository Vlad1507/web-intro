package com.example.web_intro.service;

import com.example.web_intro.dto.skill.CreateRequestSkillDto;
import com.example.web_intro.dto.skill.SkillDto;
import com.example.web_intro.model.Skill;

import java.util.List;

public interface SkillService {
    SkillDto save(CreateRequestSkillDto requestSkillDto);

    List<SkillDto> findAll();
}
