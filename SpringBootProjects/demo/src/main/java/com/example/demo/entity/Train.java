package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String TrainName;
    private String TrainNumber;

    @OneToMany(mappedBy = "train",cascade = CascadeType.ALL)
    private List<TrainSchedule>schedules;

    public Train() {
    }

    public Train(String trainName, String trainNumber, List<TrainSchedule> schedules) {
        TrainName = trainName;
        TrainNumber = trainNumber;
        this.schedules = schedules;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrainName() {
        return TrainName;
    }

    public void setTrainName(String trainName) {
        TrainName = trainName;
    }

    public String getTrainNumber() {
        return TrainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        TrainNumber = trainNumber;
    }

    public List<TrainSchedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<TrainSchedule> schedules) {
        this.schedules = schedules;
    }
}
