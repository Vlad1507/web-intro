package com.example.web_intro.repository.impl;

import com.example.web_intro.exception.DataProcessingException;
import com.example.web_intro.model.Skill;
import com.example.web_intro.repository.SkillRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class SkillRepositoryImpl implements SkillRepository {
    private final EntityManagerFactory managerFactory;

    @Override
    public Skill save(Skill skill) {
        EntityTransaction transaction = null;
        try (EntityManager entityManager = managerFactory.createEntityManager()) {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(skill);
            transaction.commit();
            return skill;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Unable to save a skill to database ", e);
        }
    }

    @Override
    public List<Skill> findAll() {
        try (EntityManager entityManager = managerFactory.createEntityManager()) {
            return entityManager.createQuery("SELECT s FROM Skill s", Skill.class).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all skills from database ", e);
        }
    }
}
