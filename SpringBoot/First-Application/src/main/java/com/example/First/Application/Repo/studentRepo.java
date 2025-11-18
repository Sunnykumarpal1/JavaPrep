package com.example.First.Application.Repo;

import com.example.First.Application.Dto.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class studentRepo {
    List<Student>ls=new ArrayList<>();
    public List<Student>getAllStudent(){
        System.out.println("repo running");

        Student st1=new Student("sunny",1,"Bangalore","cse");
        Student st2=new Student("Kushi",2,"Mangalore","ise");
        Student st3=new Student("Aryan",3,"Mysore","fsd");
//        Student st4=new Student("arush",4,"hubli","dsa");
//        Student st5=new Student("ansh",5,"lucknow","fsd");
//        Student st6=new Student("ashwini",6,"varanasi","dsa");
//        Student st7=new Student("pandu",7,"patna","fsd");
//        Student st8=new Student("panda",8,"chennai","cse");
//        Student st9=new Student("hero",9,"mumbai","cse");
        ls.add(st1);
        ls.add(st2);
        ls.add(st3);

        return ls;
    }

    public  void addStudent(Student st){
        ls.add(st);
    }

    public  void updateStudent(int id,Student st){
        for(Student i:ls){
            if(i.getId()==id){
                i.setAddress(st.getAddress());
                i.setName(st.getName());
                i.setId(st.getId());
                i.setCourse(st.getCourse());
            }
        }
    }
    public  void deleteStudent(int id){
        ls.removeIf(s -> s.getId()==id);

    }

}
