package com.example.web_intro.repository;

import com.example.web_intro.model.Skill;
import java.util.List;

public interface SkillRepository {
    Skill save (Skill skill);

    List<Skill> findAll();
}
