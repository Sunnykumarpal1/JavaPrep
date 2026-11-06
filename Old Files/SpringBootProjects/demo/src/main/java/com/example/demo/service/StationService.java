package com.example.demo.service;

import com.example.demo.dto.StationRequestDTO;
import com.example.demo.dto.StationResponseDTO;
import com.example.demo.entity.Station;
import com.example.demo.repository.StationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {
    private final StationRepository stationRepository;

    public StationService(StationRepository repository){
        stationRepository=repository;
    }
    public StationResponseDTO mapToResponseDTO(Station station){
        return new StationResponseDTO(station.getId(),station.getStationName(),station.getStationCode());
    }
    public List<StationResponseDTO> getAllStation(){
       List<Station>ls= stationRepository.findAll();
       return ls.stream().map(this::mapToResponseDTO).toList();
    }
    public StationResponseDTO findByStationCode(String stationCode){
       Station st= stationRepository.findByStationCode(stationCode);
       if(st==null){
           throw  new RuntimeException("Station not found Exception");
       }
       return mapToResponseDTO(st);
    }

    public StationResponseDTO addStation( StationRequestDTO requestDTO){
        Station s=new Station(requestDTO.getStationCode(), requestDTO.getStationName());
        stationRepository.save(s);
        return mapToResponseDTO(s);
    }

    public void deleteStationById( int id){
        Station st=stationRepository.findById(id).orElseThrow(()->new RuntimeException("Station not found exception"));
        stationRepository.delete(st);
    }

}
