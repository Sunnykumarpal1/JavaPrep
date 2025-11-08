package com.example.First.Application.Dto;

public class Student {
    private String name;
    private int id;
    private String address;
    private String course;

    public Student(String name, int id, String address, String course) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", address='" + address + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
