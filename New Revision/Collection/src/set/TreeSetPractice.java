package set;

import Classes.Student;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class TreeSetPractice {
    public static void run(){
        TreeSet<Student>ts=new TreeSet<>();


        Student st1=new Student("Suny",20,100);
        Student st6=new Student("Kushi",20,100);
        Student st2=new Student("Kushi",20,100);
        Student st3=new Student("Aryan",18,98);
        Student st4=new Student("Arush",12,95);
        Student st5=new Student("Ansh",12,95);

        ts.addAll(List.of(st1,st2,st3,st4,st5,st6));

        System.out.println(" siz of Tree set"+ts.size());
        Iterator<Student>it=ts.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
