package set;

import Classes.Student;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ListIterator;

public class LinkedHashSetPractice {
    public  static void run(){
        LinkedHashSet<Student>lsh=new LinkedHashSet<>();

        Student st1=new Student("Suny",20,100);
        Student st6=new Student("Kushi",20,100);
        Student st2=new Student("Kushi",20,100);
        Student st3=new Student("Aryan",18,98);
        Student st4=new Student("Arush",12,95);
        Student st5=new Student("Ansh",12,95);
        lsh.add(st1);
        lsh.add(st6);
        lsh.add(st2);
        lsh.add(st4);
        lsh.add(st3);
        lsh.add(st5);
        lsh.add(null);


        System.out.println("Size of linked List "+lsh.size());

        Iterator<Student>lst=lsh.iterator();
        while (lst.hasNext()){
            System.out.println(lst.next());
        }
    }
}
