package set;

import Classes.Student;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class HashSetPractice {
    public static void run(){
        HashSet<Student>hs=new HashSet<>();


        Student st1=new Student("Suny",20,100);
        Student st6=new Student("Kushi",20,100);
        Student st2=new Student("Kushi",20,100);
        Student st3=new Student("Aryan",18,98);
        Student st4=new Student("Arush",12,95);
        Student st5=new Student("Ansh",12,95);

        hs.addAll(List.of(st1,st2,st3,st4,st5,st6));
        hs.add(null);
        hs.add(null);
        System.out.println("Size"+ hs.size());
        Iterator<Student>it=hs.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println( " size of hash set"+hs.size());

    }
}
