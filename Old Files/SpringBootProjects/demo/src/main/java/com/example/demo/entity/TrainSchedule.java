package com.
        example.demo.entity;

import jakarta.persistence.*;

@Entity
public class TrainSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn()
    private Train train;

    @ManyToOne
    @JoinColumn(name = "sourceStationId")
    private Station sourceStation;

    @ManyToOne
    @JoinColumn(name = "destinatinStationId")
    private Station destinationStation;

    String arrivalTime;
    String departureTime;

    public TrainSchedule( Train train, Station sourceStation, Station destinationStation, String arrivalTime, String departureTime) {
        this.train = train;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public TrainSchedule() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Station getSourceStation() {
        return sourceStation;
    }

    public void setSourceStation(Station sourceStation) {
        this.sourceStation = sourceStation;
    }

    public Station getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(Station destinationStation) {
        this.destinationStation = destinationStation;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}
