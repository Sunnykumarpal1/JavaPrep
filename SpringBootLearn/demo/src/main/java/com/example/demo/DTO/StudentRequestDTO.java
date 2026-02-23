package com.example.demo.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class StudentRequestDTO {



    @NotNull(message = "Name cannot be null")
    public  String name;
    @Size(min = 5,message = "minimum 5 yrs")
    public  Integer age;
    @NotNull(message = "City cannot be null")
    public String city;


    public @NotNull(message = "Name cannot be null") String getName() {
        return name;
    }

    public void setName(@NotNull(message = "Name cannot be null") String name) {
        this.name = name;
    }

    public @Size(min = 5, message = "minimum 5 yrs") Integer getAge() {
        return age;
    }

    public void setAge(@Size(min = 5, message = "minimum 5 yrs") Integer age) {
        this.age = age;
    }

    public @NotNull(message = "City cannot be null") String getCity() {
        return city;
    }

    public void setCity(@NotNull(message = "City cannot be null") String city) {
        this.city = city;
    }
}
