package com.example.jpaDemo;

import com.example.jpaDemo.entity.Appointment;
import com.example.jpaDemo.entity.Patient;
import com.example.jpaDemo.repo.PatientRepo;
import com.example.jpaDemo.service.patientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@SpringBootTest
public class patientTest {
    @Autowired
    public PatientRepo repo;

    @Autowired
    public patientService  patientService;

//    @Test
public  void findAllPatient(){
        List<Patient> all = repo.findAll();
        System.out.println("all the daata in patient is "+all);
    }


    @Test
    public void TestCustomeMethods(){
////         Patient p=repo.findByName("Sunny");
////        System.out.println(p);
//
//
////          List<Patient>ps=repo.findAllByOrderByPidDesc();
////        System.out.println(ps);
//
////        List<Patient> byNameLike = repo.findByNameLike("%s%");
////        System.out.println(byNameLike);
//
////        List<Patient> top3OrderbyName = repo.findTop3ByOrderByNameDesc();
////        System.out.println(top3OrderbyName);
//
////        List<Patient> patientByBloodGroup = repo.findPatientByBloodGroup(BloodType.AB_NEGATIVE);
////        System.out.println(patientByBloodGroup);
//
////        List<Patient> afterBirthDay = repo.findAfterBirthDay(LocalDate.of(2010,12,12));
////        System.out.println(afterBirthDay);
//
//
////        List<Object[]> groupByBloodGroup = repo.findGroupByBloodGroup();
////        for(Object obj[]:groupByBloodGroup){
////            System.out.println(obj[0]+" "+obj[1]);
////        }
//
////        List<Patient> allPatient = repo.getAllPatient();
////        System.out.println(allPatient);
//
////        here we are update the row in a table
////         int res=  repo.updatePatientNameMailById("Sun","Sun@gmail.com",1);
////        System.out.println(res)
//
////        here we will deleting the row from table
//        int res=repo.deletePatientById(1);
//        System.out.println(res);


//        List<CountBloodGroup>ls=repo.cntBGroup();
//        System.out.println(ls);

//        List<NameEmail> ch = repo.findNameAndMail();
//        System.out.println("check");
//        System.out.println(nameAndMail);

//        System.out.println(ch);


//       pageination
//        Page<Patient> patients = repo.findPaginationPatient(PageRequest.of(1, 2, Sort.by("name").ascending()));

        Page<Patient>patients=repo.findPaginationPatient(PageRequest.of(0,2,Sort.by(Sort.Order.desc("name"),Sort.Order.desc("email"))));

        for(Patient p:patients) {
            System.out.println(p);
        }
//               System.out.println( patients.getTotalPages()+" "+patients .getTotalElements());

    }

    @Test
    public void getAllPatients(){
        List<Patient> allPatient = patientService.getAllPatient();
          for(Patient p:allPatient){
              System.out.println(p.getAppointment());
          }
    }

    @Test
    public  void getAllPatientWithAppointment(){
        List<Patient>patients=repo.findAllPatientWithAppointment();
        System.out.println(patients);
    }

    @Test
    public  void getPatientWithAppointmentEntityGraph(){
        List<Patient> all = repo.findAll();
        System.out.println(all);
    }

}
