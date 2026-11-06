package com.example.demo.controller;

import com.example.demo.dto.StationRequestDTO;
import com.example.demo.dto.StationResponseDTO;
import com.example.demo.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/stations")
public class StationController {

    private final StationService stationService;
    
    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping("")
    public ResponseEntity<List<StationResponseDTO>> getAllStations() {
        List<StationResponseDTO> allStation = stationService.getAllStation();
        return ResponseEntity.ok(allStation);
    }

    @PostMapping("")
    public ResponseEntity<StationResponseDTO>addStation(@RequestBody StationRequestDTO stationRequestDTO){
        StationResponseDTO stationResponseDTO = stationService.addStation(stationRequestDTO);
       return ResponseEntity.status(201).body(stationResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteStaionById(@PathVariable Integer id){
        stationService.deleteStationById(id);
        return ResponseEntity.noContent().build();
    }

}
