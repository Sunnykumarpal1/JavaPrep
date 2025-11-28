package com.example.jpaDemo.repo;

import com.example.jpaDemo.entity.Patient;
import com.example.jpaDemo.entity.type.BloodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface patientRepo extends JpaRepository<Patient, Integer> {
    public Patient findByName(String name);

    public List<Patient> findAllByOrderByPidDesc();

    public List<Patient> findByNameLike(String name);

    public List<Patient> findTop3ByOrderByNameDesc();


//    here ?1 measn the we want the first parameter to be use here
    @Query("SELECT p FROM Patient p where p.blood_group=?1")
    List<Patient>findPatientByBloodGroup(BloodType bloodGroup);

//    here we put the : before the varialbe name  and we tell the what's the name in @param

    @Query("SELECT P FROM Patient P WHERE P.birth_day > :b_day")
    List<Patient>findAfterBirthDay(@Param("b_day") LocalDate b_day);



//    how to apply group by in jpql

    @Query("Select p.blood_group, COUNT(p) from Patient p GROUP BY p.blood_group")
    List<Object[]>findGroupByBloodGroup();



//    how to apply native query in jpa
    @Query(value = "SELECT * FROM patient_tbl",nativeQuery = true)
    List<Patient>getAllPatient();

//    modifying Query using update

    @Modifying
    @Transactional
    @Query("Update Patient p set p.name=:name , p.email=:email where p.pid=:id ")
    int updatePatientNameMailById(@Param("name")String name,@Param("email")String email,@Param("id")int id);

//    delete a table
    @Modifying
    @Transactional
    @Query("Delete from Patient p where p.pid=:id")
    int deletePatientById(@Param("id")int id);


}
