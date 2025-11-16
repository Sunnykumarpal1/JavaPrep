package com.example.jpaDemo;

import com.example.jpaDemo.entity.Patient;
import com.example.jpaDemo.repo.patientRepo;
import com.example.jpaDemo.service.patientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class patientTest {
    @Autowired
    public patientRepo repo;

    @Autowired
    public patientService  patientService;

    @Test
public  void findAllPatient(){
        List<Patient> all = repo.findAll();
        System.out.println("all the daata in patient is "+all);
    }

    @Test
    public  void findById(){
        Patient p=patientService.findById(1);
        System.out.println(p);
    }
}
