package com.example.web_intro.service.impl;

import com.example.web_intro.dto.skill.CreateRequestSkillDto;
import com.example.web_intro.dto.skill.SkillDto;
import com.example.web_intro.mapper.SkillMapper;
import com.example.web_intro.model.Skill;
import com.example.web_intro.repository.SkillRepository;
import com.example.web_intro.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {
    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;

    @Override
    public SkillDto save(CreateRequestSkillDto requestSkillDto) {
        Skill skill = skillMapper.toModel(requestSkillDto);
        return skillMapper.toDto(skillRepository.save(skill));
    }

    @Override
    public List<SkillDto> findAll() {
        return skillRepository.findAll().stream()
                .map(skillMapper::toDto)
                .toList();
    }
}
