package com.example.web_intro.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import java.util.List;

@Data
@Entity
// when you delete element from database just update value of column is_deleted but not delete entity
@SQLDelete(sql = "UPDATE employees SET is_deleted = true WHERE id =?")
// when you search for all elements but when element is deleted it won't be shown.
// It says show all elements where field "is deleted" false means element exists.
// Prevent to show deleted elements (is_deleted column = true)
@SQLRestriction(value = "is_deleted=false") // simply filter deleted data. Always used to get entity from database (@Where(clause) is deprecated)
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    @ToString.Exclude
    @Column(name = "social_security_number", unique = true)
    private String socialSecurityNumber;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    private Department department;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name = "employee.skill",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills;

    @Column(nullable = false)
    private boolean isDeleted = false;
}
