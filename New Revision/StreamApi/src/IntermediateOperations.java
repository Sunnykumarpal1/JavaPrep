import java.util.List;

public class IntermediateOperations {
    static  void run(){
//        Intermediate operation
        List<Integer>ls=List.of(1,23,3,5,6,6,55,59,62,78,9);
//        ls.stream().filter(i->i%2==0&& i>5).distinct().forEach(System.out::println);

//        ls.stream().filter(i->i%3==0).map(i->i*i).forEach(System.out::println);
/*
        System.out.println("hi");
        List<List<Integer>>ls1=List.of(List.of(1,2,3),List.of(4,5,6),List.of(7,8,9),List.of(10,11,12,13));
        ls1.stream().flatMap(i->i.stream()).forEach(System.out::println);



        System.out.println("Ascending order");
        ls.stream().sorted().forEach(System.out::println);

        System.out.println("Descending Order");
        ls.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);


 */

        ls.stream().takeWhile((n)->n<50).forEach(System.out::println);

        System.out.println("Next is the drop while");
        ls.stream().dropWhile(n->n<50).forEach(System.out::println);

    }
}
