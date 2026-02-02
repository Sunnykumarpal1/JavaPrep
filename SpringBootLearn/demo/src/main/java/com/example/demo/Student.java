package com.example.demo;

public class Student {
    public Student(String name) {
        this.name = name;
    }

    public  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
