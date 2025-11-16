package com.example.jpaDemo;

import com.example.jpaDemo.repo.patientRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
public class JpaDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(JpaDemoApplication.class, args);
	}

}
