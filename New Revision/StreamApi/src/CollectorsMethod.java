import java.util.*;
import java.util.stream.Collectors;

public class CollectorsMethod {
    public static void run(){
        List<Integer>ls=List.of(1,23,5,6,6);
        Set<Integer> st = ls.stream().collect(Collectors.toSet());

        st.forEach(System.out::println);

        List<String>nameList= List.of("Rahul", "Amit", "Kiran","Rahul", "Rahul", "Kiran");

        /*
        Map<String, Long> collect = nameList.stream().collect(Collectors.toMap(name -> name, name -> 1L, (o, n) -> o + n));
        collect.forEach((k,v)-> System.out.println("Key "+k +" Value "+v));


        Map<String, Long> collect = nameList.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()));
        collect.forEach((k,v)-> System.out.println("Key "+k+" Value "+v));


        Map<String, Integer>mp=nameList.stream().collect(Collectors.toMap(name->name,n->1,(oldV,newV)->oldV+newV));
        System.out.println(mp);

//        joining elelment to one [ delimiter , prefix , suffix ]
        String ans=nameList.stream().collect(Collectors.joining(",","[","]"));
        System.out.println(ans);

//  now groupby based on department

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Rahul", "IT", 60000),
                new Employee(2, "Amit", "HR", 40000),
                new Employee(3, "Kiran", "IT", 70000),
                new Employee(4, "Raj", "HR", 45000),
                new Employee(5, "Ankit", "Finance", 50000)
        );

        Map<String,Long>mp=employees.stream().collect(Collectors.groupingBy(e->e.getDepartment(),Collectors.counting()));
        System.out.println(mp);


         */

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Rahul", "IT", 60000),
                new Employee(2, "Amit", "HR", 40000),
                new Employee(3, "Kiran", "IT", 70000),
                new Employee(4, "Raj", "HR", 45000),
                new Employee(5, "Ankit", "Finance", 50000)
        );
        Map<String,List<String>>mp=employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.mapping(Employee::getName,
                        Collectors.toList())));

        System.out.println(mp);
    }
}
