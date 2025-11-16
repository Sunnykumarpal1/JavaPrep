package com.example.jpaDemo.service;

import com.example.jpaDemo.entity.Patient;
import com.example.jpaDemo.repo.patientRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class patientService {
    @Autowired
    public patientRepo repo;

    @Transactional
    public Patient findById(int id){
        Patient p1=repo.findById(id).orElseThrow();
        Patient p2=repo.findById(id).orElseThrow();
        return p1;
    }
}
