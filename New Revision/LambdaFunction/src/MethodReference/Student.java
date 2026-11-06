package MethodReference;

public class Student {
    String name="sunny";
    Student(){
        System.out.println("hey now Student class is intilized");

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
