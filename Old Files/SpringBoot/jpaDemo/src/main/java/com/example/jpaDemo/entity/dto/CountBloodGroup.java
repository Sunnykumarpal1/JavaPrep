package com.example.jpaDemo.entity.dto;

import com.example.jpaDemo.entity.type.BloodType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CountBloodGroup {
    private   BloodType bloodType;
    private   Long count;
}
