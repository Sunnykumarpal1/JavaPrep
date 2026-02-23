package com.example.demo;

import jakarta.persistence.*;



@Entity
@Table(name ="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stId;
    private String name;
    private  Integer age;
    private  String city;


    public Student(String name, Integer age, String city) {

        this.name = name;
        this.age = age;
        this.city = city;
    }

    public Student() {
    }

    public Integer getStId() {
        return stId;
    }

    public void setStId(Integer stId) {
        this.stId = stId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }




    @Override
    public String toString() {
        return "Student{" +
                "stId=" + stId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\''+
                '}';
    }
}
