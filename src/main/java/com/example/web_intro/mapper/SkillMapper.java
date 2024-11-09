package com.example.web_intro.mapper;

import com.example.web_intro.config.MapperConfig;
import com.example.web_intro.dto.skill.CreateRequestSkillDto;
import com.example.web_intro.dto.skill.SkillDto;
import com.example.web_intro.model.Skill;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface SkillMapper {
    SkillDto toDto(Skill skill);

    Skill toModel(CreateRequestSkillDto requestSkillDto);
}
