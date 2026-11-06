package com.example.jpaDemo.service;

import com.example.jpaDemo.entity.Patient;
import com.example.jpaDemo.repo.PatientRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class patientService {
    @Autowired
    public PatientRepo repo;

    @Transactional
    public Patient getPatientById(int id){
        Patient p1=repo.findById(id).orElseThrow();
        Patient p2=repo.findById(id).orElseThrow();
        p1.setName("Aryu");
        return p1;
    }
    public   List<Patient> getAllPatient(){
        List<Patient>patients=repo.findAll();
        return patients;
    }
}
