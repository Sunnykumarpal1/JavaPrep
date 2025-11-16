package com.example.jpaDemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@ToString
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private  Long pId;
    private LocalDate birth_day;
    private  String pName;
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
