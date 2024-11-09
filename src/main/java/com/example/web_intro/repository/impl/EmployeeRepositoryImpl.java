//package com.example.web_intro.repository.impl;
//
//import com.example.web_intro.exception.DataProcessingException;
//import com.example.web_intro.model.Employee;
//import com.example.web_intro.repository.EmployeeRepository;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//@RequiredArgsConstructor
//public class EmployeeRepositoryImpl implements EmployeeRepository {
//    private final EntityManagerFactory factory;
//
//    @Override
//    public Employee save(Employee employee) {
//        EntityTransaction transaction = null;
//        try (EntityManager manager = factory.createEntityManager()) {
//            transaction = manager.getTransaction();
//            transaction.begin();
//            manager.persist(employee);
//            transaction.commit();
//            return employee;
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            throw new DataProcessingException("Unable to save an employee: " + employee + " to database", e);
//        }
//    }
//
//    @Override
//    public List<Employee> findAllByName(String name) {
//        String lowerCaseName = name.toLowerCase();
//        try (EntityManager  entityManager = factory.createEntityManager()) {
//            return entityManager.createQuery("SELECT e FROM Employee e WHERE lower(e.name) LIKE :name", Employee.class)
//                    .setParameter("name", "%" + lowerCaseName + "%")
//                    .getResultList();
//        }
//    }
//
//    @Override
//    public List<Employee> findAll() {
//        try (EntityManager manager = factory.createEntityManager()) {
//            return manager.createQuery("SELECT e FROM Employee e JOIN FETCH e.skills", Employee.class).getResultList();
//        }
//    }
//
//    @Override
//    public Optional<Employee> findById(Long id) {
//        try (EntityManager entityManager = factory.createEntityManager()) {
//            Employee employee = entityManager.find(Employee.class, id);
//            return Optional.ofNullable(employee);
//        }
//    }
//}
