import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamCreation {
    public  static void run(){
        /*
//        using ls.stream
        List<Integer>ls=new ArrayList<>();
        ls.addAll(List.of(1,2,3,5,5,6,7,9,10));
        Stream<Integer> integerStream = ls.stream().filter(n -> n % 3 == 0);

//        parallel Stream
        Stream<Integer>pr=ls.parallelStream();
        pr.forEach(System.out::println);

        Stream<Integer>str=Stream.of(1,2,3,5);

        Integer arr[]={1,2,3,5,6,7,8,9};

        Stream<Integer>st1= Arrays.stream(arr);

        Stream.iterate(1,i->i+1).limit(7).forEach(System.out::println);

        Stream.generate(()->"Hello").limit(4).forEach(System.out::println);

//


        String s=new String("SUNNY");
        s.chars().forEach(System.out::println);

         */
    }
}
