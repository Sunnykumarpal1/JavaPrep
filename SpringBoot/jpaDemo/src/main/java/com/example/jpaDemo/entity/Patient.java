package com.example.jpaDemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;


@Entity
@ToString
@Getter
@Setter
@Table(name = "patient_tbl",
        uniqueConstraints = {
//               @UniqueConstraint(name = "unique mail", columnNames = "email"),
                @UniqueConstraint(name = "unique_name_dob",columnNames = {"pName","birth_day"})

        },
        indexes={
             @Index(name = "idx_patient_dob",columnList = "birth_day")
        }
)

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private  Long pId;
    private LocalDate birth_day;
    @Column(name = "person_name",nullable = false)
    private  String pName;

    @Column(unique = true, name = "Email",nullable = false)
    private String email;
   private  String gender;





   /*
    @Override
    public String toString() {
        return "Patient{" +
                "pId=" + pId +
                ", birth_day=" + birth_day +
                ", pName='" + pName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
     1) so instead of useing this we can use lombord  annotation that will help us remove the boiler plate code
     2) if we wnat to remove any paramenter to printed we can use @ToString.Exclude
     */
}


/*
  uniqueCostraints is basically used when you want to aplliy  uniquness for multi columns.
  Note:- If we want to use for single column then we use the column annotaion
 */