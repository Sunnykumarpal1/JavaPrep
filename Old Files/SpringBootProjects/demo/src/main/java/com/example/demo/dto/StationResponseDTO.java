package com.example.demo.dto;

public class StationResponseDTO {
    Integer id;
    String stationCode;
    String stationName;

    public StationResponseDTO() {
    }

    public StationResponseDTO(Integer id,String stationCode, String stationName) {
        this.id=id;
        this.stationCode = stationCode;
        this.stationName = stationName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
}
