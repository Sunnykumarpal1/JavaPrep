package com.example.demo.repository;

import com.example.demo.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepo  extends    JpaRepository<Student,Integer> {
    public Page<Student> findAllByOrderByStIdDesc(PageRequest request);
}
