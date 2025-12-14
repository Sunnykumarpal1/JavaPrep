package com.example.jpaDemo.repo;

import com.example.jpaDemo.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}