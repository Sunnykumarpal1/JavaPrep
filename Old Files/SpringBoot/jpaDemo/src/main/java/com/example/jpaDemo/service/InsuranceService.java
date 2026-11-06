package com.example.jpaDemo.service;

import com.example.jpaDemo.entity.Insurance;
import com.example.jpaDemo.entity.Patient;
import com.example.jpaDemo.repo.InsuranceRepository;
import com.example.jpaDemo.repo.PatientRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepo patientRepo;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Integer p_id) {
        Optional<Patient> patient = patientRepo.findById(p_id);
        Patient p = patient.orElseThrow(() ->
                new EntityNotFoundException("we got an exception"));
        p.setInsurance(insurance);
        insurance.setPatient(p);
        return p;
    }

    @Transactional
    public Patient disassociateInsuranceFromPatient(int patiendId) {
        Patient patient = patientRepo.findById(patiendId).orElseThrow(() -> new EntityNotFoundException("patient not found"));
        patient.setInsurance(null);
        return patient;
    }
}