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

//    @Test
public  void findAllPatient(){
        List<Patient> all = repo.findAll();
        System.out.println("all the daata in patient is "+all);
    }


    @Test
    public void TestCustomeMethods(){
//         Patient p=repo.findByName("Sunny");
//        System.out.println(p);


//          List<Patient>ps=repo.findAllByOrderByPidDesc();
//        System.out.println(ps);

//        List<Patient> byNameLike = repo.findByNameLike("%s%");
//        System.out.println(byNameLike);

//        List<Patient> top3OrderbyName = repo.findTop3ByOrderByNameDesc();
//        System.out.println(top3OrderbyName);

//        List<Patient> patientByBloodGroup = repo.findPatientByBloodGroup(BloodType.AB_NEGATIVE);
//        System.out.println(patientByBloodGroup);

//        List<Patient> afterBirthDay = repo.findAfterBirthDay(LocalDate.of(2010,12,12));
//        System.out.println(afterBirthDay);


//        List<Object[]> groupByBloodGroup = repo.findGroupByBloodGroup();
//        for(Object obj[]:groupByBloodGroup){
//            System.out.println(obj[0]+" "+obj[1]);
//        }

//        List<Patient> allPatient = repo.getAllPatient();
//        System.out.println(allPatient);

//        here we are update the row in a table
//         int res=  repo.updatePatientNameMailById("Sun","Sun@gmail.com",1);
//        System.out.println(res)

//        here we will deleting the row from table
        int res=repo.deletePatientById(1);
        System.out.println(res);

    }
}
