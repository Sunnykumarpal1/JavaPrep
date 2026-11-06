package list;

import Classes.Student;

import java.util.*;

public class ArrayListPractice {

    public static void run(){

       /*
        List<Integer>ls=new ArrayList<>();
//        it's is used to add the element
        ls.add(2);
        ls.add(3);
        ls.add(8);
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(8);

        int val=ls.get(2);
        System.out.println("value at index : 2"+val);

        if(ls.contains(3)){
            System.out.println(" the element is pressent");
            ls.remove(ls.indexOf(3));

        }

        ls.addLast(7);
        ls.removeLast();
        System.out.println("Before sorting");
        System.out.println(ls);

        Collections.sort(ls);
        System.out.println("After sorting");
        System.out.println(ls);

        System.out.println("before referse");
        System.out.println(ls);
        ls.sort(Collections.reverseOrder());


        System.out.println("after referse");
        System.out.println(ls);

        System.out.println("Filter");
        ls.removeIf(x->x%2==1);
        System.out.println(ls);


        */

        /*
        List<Student>students=new ArrayList<>();

        Student st1=new Student("Suny",20,100);
        Student st2=new Student("Kushi",20,100);
        Student st3=new Student("Aryan",18,98);
        Student st4=new Student("Arush",12,95);
        Student st5=new Student("Ansh",12,95);

        students.addAll(List.of(st1,st2,st3,st4,st5));
        students.sort(null);
//        sort by marks in decresing order
//        students.sort((a,b)->Integer.compare(b.marks,a.marks));

//        sort by age , if both are same sort by marks , if marks are same sort by decending name
        students.sort(
                Comparator.comparingInt(Student::getAge)
                        .thenComparingInt(Student::getMarks)
                        .thenComparing(Student::getName, Comparator.reverseOrder())
        );
        for(Student st:students){
            System.out.println(st);
        }
             */

        ArrayList<Integer>arr=new ArrayList<>();
        arr.addAll(List.of(1,2,34,5,6,78));
        Iterator<Integer>it=arr.iterator();

        arr.add(99);
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
