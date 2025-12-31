import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {

/*        List<Student>ls=new ArrayList<>();
        Student st1= new Student(23, "sunny", "sunny@gmail.com", "LA");
        ls.add(st1);
        Student st2 = new Student(23, "sunny", "sunny@gmail.com", "LA");
        ls.add(st2);
        Student st3=new Student(18,"Aryan","Aryan@gmail.com","LA");
        Student st4=new Student(20,"Kushi","Kushi@gmail.com","Bankok");
        ls.add(st3);
        ls.add(st4);
        ls.add(new Student(12,"Ansh","Ansh@gmail.com","Bengaluru"));
        ls.add(new Student(8,"Arush","Arush@gmail.com","Bengaluru"));
        List<Student>ans=ls.stream().filter(i->i.getAge()>10).sorted(Comparator.comparingInt(Student::getAge)).distinct().toList();
        ans.stream().map(s-> new Student(s.getAge()+1,s.getName(),s.getEmail(),s.getCity())).toList().forEach(i-> System.out.println(i));

        System.out.println("Done ");

//    Terminal stream operation
        List<Student>myst2=List.of(st1,st2,st3,st4).stream().distinct().collect(Collectors.toList());
        myst2.forEach(s-> System.out.println(s));
//        Set<Student>st=List.of(st1,st2,st3,st4).stream().distinct().collect(Collectors.toSet());
//        st.forEach(s-> System.out.println(s));

        System.out.println("map ");
        Map<Integer,String>map=List.of(st1,st2,st3,st4).stream().distinct().collect(Collectors.toMap(Student::getAge,Student::getName));
        map.forEach((k,v)-> System.out.println("key "+k+" Value "+v ));


//        Reduce
        List<Integer>nums= List.of(2, 5, 6, 89, 8, 9);
        int sum=nums.stream().reduce(0,(a,b)->a+b);
        System.out.println(sum);

        int min=nums.stream().reduce(Integer.MAX_VALUE,Integer::min);
        int max=nums.stream().reduce(Integer.MIN_VALUE,Integer::max);
        System.out.println("Max "+max+" min "+min);

        String res=List.of("A","B","C","D","E","F","G").stream().reduce("",(a,b)->a+b);
        System.out.println("concat "+res);


//        Cound()
        Long val=List.of(st1,st2,st3,st4).stream().distinct().count();
        System.out.println("Count"+ List.of(st1,st2,st3,st4).stream().distinct().count());

//        AnyMatch()
        Boolean flag=nums.stream().anyMatch((i)->i%2==0);
        System.out.println("AnyMatch "+flag);
//        AllMatch()
        Boolean check=nums.stream().allMatch((i)->i>5);
        System.out.println("allMatch "+check);
//        NoneMatch
        Boolean ansFlag=nums.stream().noneMatch((i)->i>100);
        System.out.println("noneMatch "+ansFlag);
*/
        /*
//   group by and aggregate
        Employee emp1=new Employee(1,"p1",100000);
        Employee emp2=new Employee(1,"p6",30000);
        Employee emp3=new Employee(2,"p2",20000);
        Employee emp4=new Employee(2,"p3",10000);
        Employee emp5=new Employee(2,"p4",15000);
        Employee emp6=new Employee(3,"p5",35000);

        Map<Integer,Double>mp=List.of(emp1,emp2,emp3,emp4,emp6,emp5).stream().collect(Collectors.groupingBy(Employee::getDeptid,Collectors.averagingDouble(Employee::getSalay)));
        mp.forEach((k,v)->{
            System.out.println(k+" "+v);
        });

        System.out.println("Endl ");
        Map<Integer,List<Employee>>findEmployeeByDepartment=List.of(emp1,emp2,emp3,emp4,emp6,emp5).stream().collect(Collectors.groupingBy(Employee::getDeptid));
        findEmployeeByDepartment.forEach((k,v)->{
            System.out.println(k+" "+v);
        });

        System.out.println("Cnt");

        Map<Integer,Long>cnt=List.of(emp1,emp2,emp3,emp4,emp6,emp5).stream().collect(Collectors.groupingBy(Employee::getDeptid,Collectors.counting()));
        cnt.forEach((k,v)-> System.out.println(k+" "+v));

         */

//        flatmap
        List<List<Integer>> list = List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(6, 7, 5,8)
        );
        list.stream().flatMap(s->s.stream()).distinct().forEach(System.out::println);



    }
}
