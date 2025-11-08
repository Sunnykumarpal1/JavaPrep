package com.example.First.Application.Service;

import com.example.First.Application.Dto.Student;
import com.example.First.Application.Repo.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentService {

    @Autowired
    private studentRepo repo;

    public List<Student>getAllStudent(){
        return repo.getAllStudent();
    }
    public  void addStudent(Student st){
        repo.addStudent(st);
    }

    public  void updateStudent(int id,Student st){
        repo.updateStudent(id,st);
    }

    public  void deleteStudent(int id){
        repo.deleteStudent(id);
    }

}
