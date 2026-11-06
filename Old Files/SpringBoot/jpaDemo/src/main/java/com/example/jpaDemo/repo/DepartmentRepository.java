package com.example.jpaDemo.repo;

import com.example.jpaDemo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}