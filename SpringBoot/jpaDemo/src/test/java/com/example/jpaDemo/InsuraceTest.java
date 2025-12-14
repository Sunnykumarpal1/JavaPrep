package com.example.jpaDemo;

import com.example.jpaDemo.entity.Insurance;
import com.example.jpaDemo.entity.Patient;
import com.example.jpaDemo.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuraceTest {
    @Autowired
    private InsuranceService insuranceService;
    @Test
    public  void assignInsuranceToPatient(){
        Insurance insurance=new Insurance();
        insurance.setProvider("Icici");
        insurance.setPolicyNumber("1234asd");
        insurance.setValidTill(LocalDate.of(2050,12,31));
        Patient p=insuranceService.assignInsuranceToPatient(insurance,6);
        System.out.println(p);
        System.out.println("done");
    }

    @Test
    public  void disassociateInsuranceFromPatient(){
        assignInsuranceToPatient();
        insuranceService.disassociateInsuranceFromPatient(6);
    }

}
