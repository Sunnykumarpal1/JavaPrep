package list;

import Classes.Student;

import java.util.*;

public class LinkedListPractic {
    public static void run(){
        LinkedList<Student> ll=new LinkedList<>();

        Student st1=new Student("Suny",20,100);
        Student st2=new Student("Kushi",20,100);
        Student st3=new Student("Aryan",18,98);
        Student st4=new Student("Arush",12,95);
        Student st5=new Student("Ansh",12,95);

        ll.addAll(List.of(st1,st2,st3));

        System.out.println(ll);

        ll.add(st4);
        System.out.println(ll);

        ll.offer(st5);
        System.out.println(ll);

        ll.push(new Student("A",1,2));
        System.out.println(ll);
        System.out.println("Before pop");
        ll.pop();

        System.out.println(ll);
//        removes first element
        System.out.println("peek"+ll.poll());
        System.out.println(ll);

//        remvoes the first elemnt
        ll.remove();
        System.out.println(ll);


        ll.sort(Comparator.comparingInt(Student::getAge)
                .thenComparing(Student::getName)
        );
//        ll.removeIf(e->e.age>0);
        Iterator<Student>its=ll.iterator();
        while(its.hasNext()){
            System.out.println(its.next());
        }

//
    }
}
