package com.example.web_intro.repository;

import com.example.web_intro.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //@Query("from Employee e where upper(e.name) LIKE upper(:name)") // use if we write incorrect methodName() for Spring Data JPA to understand what to do
    @Query(value = "SELECT * FROM employees WHERE UPPER(name) LIKE UPPER(:name)", nativeQuery = true) // tells JPA that this is native SQL query
    List<Employee> findAllByNameContainsIgnoreCase(String name); // Spring Data JPA parse method name in query (this method name tells JPA to find by name ignoring case)
//    List<Employee> findAll();
//
//    Optional<Employee> findById(Long id);// IF WE WANT SOMETHING TO SEARCH if we are looking for object that can be absent
//
//    //Employee getById(Long id); // IF WE WANT TO GET if we want to get object
//
//    Employee save(Employee employee);
//
//    List<Employee> findAllByName+(String name);
}
