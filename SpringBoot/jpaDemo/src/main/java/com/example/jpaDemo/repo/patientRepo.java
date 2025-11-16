package com.example.jpaDemo.repo;

import com.example.jpaDemo.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface patientRepo extends JpaRepository<Patient,Integer> {
}
