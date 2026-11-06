package com.example.demo.controller;


import com.example.demo.dto.StudentPatchDto;
import com.example.demo.dto.StudentRequestDTO;
import com.example.demo.dto.StudentResponseDTO;
import com.example.demo.service.StudentService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
@RequestMapping("/students")
public class StudentController {


    public  final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

//    @GetMapping
//    ResponseEntity<List<StudentResponseDTO>>findAllStudent() {
//        return ResponseEntity.ok(service.getAllStudents());
//    }

    @GetMapping("/{id}")
    ResponseEntity<StudentResponseDTO> findStudentById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.findStudentById(id));
    }

//    get for pagination
     @GetMapping()
     ResponseEntity<List<StudentResponseDTO>>findAllStudents(@RequestParam("page") Integer page,@RequestParam("size") Integer size){
        return ResponseEntity.ok(service.getStudents(page,size));
     }

    @PostMapping
    ResponseEntity<StudentResponseDTO> addStudent(@Valid @RequestBody StudentRequestDTO dto) {
        StudentResponseDTO resDTO=   service.addStudent(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(resDTO);
    }
//
//    @DeleteMapping
//    void deleteAllStudents() {
//        service.deleteAllStudents();
//    }

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deleteStudentById(@PathVariable("id") int id) {
        service.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
//
//     put update the entire object
    @PutMapping("/{id}")
    ResponseEntity<StudentResponseDTO> updateStudent(@Valid @RequestBody StudentRequestDTO dto,@PathVariable("id")Integer id){
        StudentResponseDTO resDTO=service.updateStudent(dto,id);
        return ResponseEntity.status(HttpStatus.OK).body(resDTO);
    }

////    patch update the partial object
    @PatchMapping("/{id}")
    ResponseEntity<StudentResponseDTO>patchStudent(@Valid @RequestBody StudentPatchDto requestDto, @PathVariable("id") int id){
        StudentResponseDTO responseDTO=service.updatePartialStudentData(id,requestDto);
        return ResponseEntity.ok(responseDTO);
    }

}
