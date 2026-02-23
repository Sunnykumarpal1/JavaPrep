package com.example.demo.repository;

import com.example.demo.Student;
import com.example.demo.dto.StudentRequestDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepo  extends    JpaRepository<Student,Integer> {

}
