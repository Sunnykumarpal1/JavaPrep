import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {

        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(4);
        ls.add(5);
        ls.add(6);
        /*
         * filter :- this just stores the data that is true .
           here we have a predicated method which returns true or false 
         */
        List<Integer> collect = ls.stream().
        filter(i->i%2==0).
        collect(Collectors.toList());
        System.out.println(collect);

        /*
         * Map: if we want to perform some opetioans on the element and store the
         * updated one then we use this
         */

        List<Integer> collect2 =
        ls.stream().map(i->i*2).collect(Collectors.toList());
        System.out.println(collect2);


        

    }
}
