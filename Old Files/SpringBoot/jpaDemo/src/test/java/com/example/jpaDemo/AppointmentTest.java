package com.example.jpaDemo;

import com.example.jpaDemo.entity.Appointment;
import com.example.jpaDemo.repo.PatientRepo;
import com.example.jpaDemo.service.AppointmentService;
import lombok.Builder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTest {
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientRepo patientRepo;

    @Test
    public void creatingAppointment(LocalDateTime dateTime,String appReason,int doctId,int patientId){
        Appointment appointment1 = Appointment.builder().appointmentTime(dateTime)
                .reason(appReason)
                .build();

        Appointment apptment = appointmentService.createAppointment(appointment1, patientId, doctId);
        System.out.println(apptment);

        System.out.println(" assigning appointment done");



    }

    @Test
    public void reAssignAppointmenttoAnotherDoctor(){
        Appointment ap = appointmentService.reAssignAppointmentToAnotherDoctor(1, 3);
        System.out.println(ap);
    }

    @Test
    public void cratingMultipleAppointment(){
        creatingAppointment(LocalDateTime.of(2025,12,14,11,11,11),"headache",3,1);
        creatingAppointment(LocalDateTime.of(2026,1,12,11,11,11),"stomachPain",2,1);
        creatingAppointment(LocalDateTime.of(2026,2,11,11,11,11),"toothpain",1,1);
        patientRepo.deleteById(1);
    }



}
