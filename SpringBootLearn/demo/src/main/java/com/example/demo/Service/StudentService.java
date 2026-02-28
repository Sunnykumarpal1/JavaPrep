package com.example.demo.service;

import com.example.demo.Student;
import com.example.demo.dto.StudentPatchDto;
import com.example.demo.dto.StudentRequestDTO;
import com.example.demo.dto.StudentResponseDTO;
import com.example.demo.repository.StudentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class
StudentService {

    public final StudentRepo repo;
    @Autowired
    public  StudentService(StudentRepo sRep){
        repo=sRep;
    }

//    List<StudentResponseDTO>getAllStudents(){
//        return repo.getAllStudents();
//    }
    public Student getStudent(StudentRequestDTO dto){
        Student st=new Student(dto.getName(),dto.getAge(),dto.getCity());
        return  st;
    }
    public  StudentResponseDTO getResponseDTO(Student st){
        StudentResponseDTO responseDTO=new StudentResponseDTO();
        responseDTO.setId(st.getStId());
        responseDTO.setName(st.getName());
        responseDTO.setAge(st.getAge());
        responseDTO.setCity(st.getCity());
        return responseDTO;
    }

    public StudentResponseDTO addStudent(StudentRequestDTO dto) {
        Student st=getStudent(dto);
        repo.save(st);
        return getResponseDTO(st);
    }

    public List<StudentResponseDTO> getAllStudents() {
        List<Student>students=repo.findAll();
//          List<Student>students=repo.findAllByOrderByStIdDesc();
        return students.stream().map(s->getResponseDTO(s)).toList();
    }

    public StudentResponseDTO findStudentById(int id) {
        return repo.findById(id).map(s->getResponseDTO(s)).orElseThrow(()->new RuntimeException("Student id  not found"));
    }

    public void deleteStudentById(Integer id) {
         repo.deleteById(id);
    }

    public StudentResponseDTO updateStudent(StudentRequestDTO requestDTO, Integer id) {
        Student existingStudent = (Student) repo.findById(id).orElseThrow(()-> new RuntimeException("Student not found exception"));
        existingStudent.setName(requestDTO.getName());
        existingStudent.setAge(requestDTO.getAge());
        existingStudent.setCity(requestDTO.getCity());
        Student updatedStudent=repo.save(existingStudent);
        return getResponseDTO(updatedStudent);
    }

    public StudentResponseDTO updatePartialStudentData(int id, StudentPatchDto requestDto) {
        Student existingStudent = (Student) repo.findById(id).orElseThrow(()-> new RuntimeException("Student not found exception"));
        System.out.println(requestDto);
        if(requestDto.getName()!=null){
            existingStudent.setName(requestDto.getName());
        }

        if(requestDto.getAge()!=null){
            existingStudent.setAge(requestDto.getAge());
        }
        if(requestDto.getCity()!=null){
            existingStudent.setCity(requestDto.getCity());
        }

        Student updatedStudent=repo.save(existingStudent);
        return getResponseDTO(updatedStudent);
    }

//    pagination
    public List<StudentResponseDTO> getStudents(Integer page,Integer siz) {
        PageRequest pageRequest = PageRequest.of(page, siz);
        Page<Student>students=repo.findAllByOrderByStIdDesc(pageRequest);
        return students.stream().map(s->getResponseDTO(s)).toList();
    }
}






