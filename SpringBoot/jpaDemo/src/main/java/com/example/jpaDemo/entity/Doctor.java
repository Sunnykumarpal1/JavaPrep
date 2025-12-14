package com.example.jpaDemo.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.print.Doc;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 100)
    private String name;

    @Column(length = 100)
    private String specialization;

    @Column(nullable = false,unique = true)
    private String email;

    @OneToMany(mappedBy = "doctor",cascade = CascadeType.REMOVE,orphanRemoval = true)
    @ToString.Exclude
    private List<Appointment>appointments;

    @ManyToMany(mappedBy = "doctors")
    @ToString.Exclude
    private Set<Department>departments=new HashSet<>();

}
