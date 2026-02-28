package com.example.demo.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StudentRequestDTO {



    @NotBlank(message = "Name cannot be null")
    private   String name;
    @NotNull(message = "age cannot be null and less 5")
    @Min(value = 5)
    private   Integer age;
    @NotBlank(message = "City cannot be null")
    private String city;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge( Integer age) {
        this.age = age;
    }

    public  String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
