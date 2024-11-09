package com.example.web_intro.repository.impl;

import com.example.web_intro.exception.DataProcessingException;
import com.example.web_intro.model.Department;
import com.example.web_intro.repository.DepartmentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {
    private final EntityManagerFactory factory;

    @Override
    public List<Department> getAll() {
        try (EntityManager manager = factory.createEntityManager()) {
            return manager.createQuery("SELECT d FROM Department d", Department.class).getResultList();
        }
    }

    @Override
    public Department save(Department department) {
        EntityTransaction transaction = null;
        try (EntityManager entityManager = factory.createEntityManager()) {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(department);
            transaction.commit();
            return department;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Unable to save department to database ", e);
        }
    }
}
