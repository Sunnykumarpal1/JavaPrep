package com.example.jpaDemo.entity;

import com.example.jpaDemo.entity.type.BloodType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDate;


@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "patient_tbl",
        uniqueConstraints = {
//               @UniqueConstraint(name = "unique mail", columnNames = "email"),
                @UniqueConstraint(name = "unique_name_dob",columnNames = {"name","birth_day"})

        },
        indexes={
             @Index(name = "idx_patient_dob",columnList = "birth_day")
        }
)

public class Patient {

    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Id()
    private  Long pid;

    @Column(nullable = false)
    private  String name;


    private  String gender;
    private LocalDate birth_day;

    @Column(unique = true,nullable = false)
    private String email;

   @CreationTimestamp
   @Column(updatable = false)
   private LocalDate regDay;


   @Enumerated(EnumType.STRING)
   private BloodType blood_group;



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