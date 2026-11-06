package com.example.demo.repository;

import com.example.demo.dto.StationResponseDTO;
import com.example.demo.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;


@Repository
public interface StationRepository extends JpaRepository<Station,Integer> {
     Station findByStationCode(String stationCode);
}
