package ComparatormAndComparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
   Use Comparable when your class has a natural default sorting (e.g., sorting Integer, String, Date).

 */
class Student implements Comparable<Student> {
    public String name;
    public int age;
    public int id;
    
    public Student(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", id=" + id + "]";
    }

    @Override
    public int compareTo(Student o) {
        // TODO Auto-generated method stub
        return this.id-o.id;
    }
    
    
}


public class ComparableEx {
    public static void main(String[] args) {
        List<Student>students=new ArrayList<>();
        Student s1=new Student("Aryan ", 18, 3);
        Student s2=new Student("kushi", 19, 2);
        Student s3=new Student("Sunny", 17, 1);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        Collections.sort(students);
        for(Student s:students){
            System.out.println(s);
        }
    }
}
