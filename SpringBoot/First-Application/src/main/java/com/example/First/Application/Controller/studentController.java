package com.example.First.Application.Controller;

import com.example.First.Application.Dto.Student;
import com.example.First.Application.Service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stud")
public class studentController {

    @Autowired
    private studentService ss;



//    get all student
     @GetMapping("/student")
    List<Student> getAllStudent(){
            return ss.getAllStudent();
     }
     @PostMapping("/student")
     void addStudent(@RequestBody Student st){
         ss.addStudent(st);
     }

     @PutMapping("/student/{id}")
    void updateStudent(@PathVariable int id,@RequestBody Student st){
         ss.updateStudent(id,st);
     }

     @DeleteMapping("/student/{id}")
     void deleteStudent(@PathVariable int id){
         ss.deleteStudent(id);
     }
}
