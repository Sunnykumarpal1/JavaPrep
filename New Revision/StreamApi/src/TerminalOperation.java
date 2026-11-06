import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

public class TerminalOperation {
    public static void run(){
        List<Integer>ls=List.of(1,2,3,5,4,17,19,11,13,15);
        ls.stream().filter(i->i>10).forEach(System.out::println);
        long cnt= ls.stream().filter(i->i>10).count();
        System.out.println(cnt);

        int sum=ls.stream().reduce(0,(a,b)->a+b);
        System.out.println(sum);

//        to List is immutabl e and collecto(Collector.toList) is mutable
        List<Integer>val=ls.stream().map(i->i+1).collect(Collectors.toList());
        val.add(1);
        System.out.println(val);


        Optional<Integer> maxi=ls.stream().max(Integer::compareTo);
        Optional<Integer>mini=ls.stream().min(Integer::compareTo);
        System.out.println("Maxi "+maxi.get()+" Mini "+mini.get());


        System.out.println(ls.stream().findFirst());
        System.out.println(ls.parallelStream().findAny());
        Boolean flag1=ls.stream().anyMatch((i)->i<5);
        Boolean flag2=ls.stream().allMatch((i)->i>0);
        System.out.println("Flag1 "+ flag1 +" Flag2 "+flag2);

        Boolean nonMatch=ls.stream().noneMatch(i->i<0);
        System.out.println("non Match "+nonMatch);

        Object[] array = ls.stream().toArray();
        System.out.println(array);

        Iterator<Integer> iterator = ls.stream().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
