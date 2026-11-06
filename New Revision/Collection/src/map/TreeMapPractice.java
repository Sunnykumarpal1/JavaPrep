package map;

import Classes.Student;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapPractice {
    public static void run(){
        TreeMap<Student,Integer>mp=new TreeMap<>(Comparator.comparingInt(Student::getAge));
        Student st1=new Student("Suny",22,100);
        Student st2=new Student("Kushi",12,100);
        Student st3=new Student("Aryan",8,98);
        Student st4=new Student("Arush",1,95);
        Student st5=new Student("Ansh",2,95);
        mp.put(st1,1);
        mp.put(st2,5);
        mp.put(st3,6);
        mp.put(st4,4);
        mp.put(st5,3);

//        mp.forEach((k,v)-> System.out.println("Key "+k +" value "+v));

        Student fkey=mp.firstKey();
        System.out.println(fkey);

        Map.Entry<Student, Integer> studentIntegerEntry = mp.firstEntry();
        System.out.println(studentIntegerEntry);

        System.out.println(mp.lowerEntry(st5));
        System.out.println(mp.higherEntry(st5));

        System.out.println(mp.headMap(st3)); //give all the small lthan  this elelment
        System.out.println(mp.tailMap(st3));  // gives all the element greter than or equal to this elemnt
        System.out.println(mp.subMap(st5,st2)); // gives the range from starting and ending location in map



    }
}
