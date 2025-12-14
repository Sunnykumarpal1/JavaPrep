package com.example.jpaDemo.service;

import com.example.jpaDemo.entity.Appointment;
import com.example.jpaDemo.entity.Doctor;
import com.example.jpaDemo.entity.Patient;
import com.example.jpaDemo.repo.AppointmentRepository;
import com.example.jpaDemo.repo.DoctorRepository;
import com.example.jpaDemo.repo.PatientRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private  final AppointmentRepository appointmentRepository;
    private  final PatientRepo patientRepo;
    private  final DoctorRepository doctorRepository;

    @Transactional
    public Appointment createAppointment(Appointment appointment,int patiendId,int doctorId){
        Patient patient = patientRepo.findById(patiendId).orElseThrow();
        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
//        just to maintaining the bi directional consistency
        patient.getAppointment().add(appointment);
        doctor.getAppointments().add(appointment);
        appointmentRepository.save(appointment);
        return appointment;
    }

    @Transactional
    public  Appointment reAssignAppointmentToAnotherDoctor(int appointmentId,int doctorId){
        Appointment appointment=appointmentRepository.findById(appointmentId).orElseThrow(()-> new EntityNotFoundException("appointment doesntExist"));
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()-> new EntityNotFoundException("doctor doesntExist"));
        appointment.setDoctor(doctor);   // when ever anything is changed then dirty checking happens and then update query is fired
        doctor.getAppointments().add(appointment);
        return appointment;
    }

}
