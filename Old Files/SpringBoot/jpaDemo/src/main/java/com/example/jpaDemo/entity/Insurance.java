package com.example.jpaDemo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "insurance_tbl")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true,length = 50)
    private String policyNumber;

    @Column(nullable = false,length = 100)
    private String provider;

    @Column(nullable = false)
    private LocalDate validTill;

    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private LocalDateTime createdAt;


    @OneToOne(mappedBy = "insurance")
    @ToString.Exclude
    private  Patient patient;
}
