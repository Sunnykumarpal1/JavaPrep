package com.example.jpaDemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private LocalDateTime appointmentTime;

    private String reason;

    @ManyToOne
    @JoinColumn(name = "patient_id",nullable = false)
    @ToString.Exclude
    private  Patient patient;

    @ManyToOne
    @JoinColumn(nullable = false)
    @ToString.Exclude
    private Doctor doctor;
}
