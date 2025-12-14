package com.example.jpaDemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,unique = true)
    private String name;

    @OneToOne
    private Doctor head_doctor;

    @ManyToMany
    @JoinTable(name = "my_dpt_doc",
      joinColumns = @JoinColumn(name = "deptId"),
            inverseJoinColumns = @JoinColumn(name = "docId")
    )
    private Set<Doctor> doctors=new HashSet<>();
}

// we have have multiple relationship in a table