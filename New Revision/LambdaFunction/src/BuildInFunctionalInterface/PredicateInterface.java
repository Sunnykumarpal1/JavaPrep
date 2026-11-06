package BuildInFunctionalInterface;

import java.util.function.Predicate;

public class PredicateInterface {
    public  static  void  run(){
//        test
        Predicate<Integer>pre=(n)->n%2==0;
        System.out.println(pre.test(4));

//        and

        Predicate<Integer>smalThan=(n)->n<10;
        Predicate<Integer>greThan=(n)->n>5;

        System.out.println(greThan.and(smalThan).test(8));

//        or

        System.out.println(greThan.or(smalThan).test(16));

//   negate
        System.out.println(greThan.negate().test(6));

//        equal
        Predicate<Integer>check=Predicate.isEqual(5);
        System.out.println(check.test(5));
    }

}
