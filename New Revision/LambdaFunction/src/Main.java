import BuildInFunctionalInterface.PredicateInterface;
import MethodReference.ConstructorMethodReference;
import MethodReference.StaticMethodReference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        Calculator  mul=(a,b)->a*b;
        Calculator add=(a,b)->a+b;
        Calculator sub=(a,b)->a-b;
        Calculator div=(a,b)->a/b;
//        System.out.println(mul.calculate(1,2));
//        System.out.println(add.calculate(1,2));
//        System.out.println(sub.calculate(3,2));
//        System.out.println(div.calculate(1,2));
        Predicate<String>val=(a)->a.length()%2==0;
        System.out.println(val.test("Sunn"));

        Function<Integer,Integer>fa=(n)->n*n;

        System.out.println(fa.apply(5));


        Consumer<Integer>cons=(a)-> System.out.println(a);

//        Supplier<Integer>supp=()-> {
//          int temp=(int) Math.random();
//          return temp;
//        };

        Supplier<Integer>supp=()->(int)(Math.random()*100);
        System.out.println(supp.get());

        ArrayList<Integer>arr= new ArrayList<>();
        arr.addAll(List.of(1,23,5,6,7,8,9));
        arr.forEach(a-> System.out.println(a));

         */

//        PredicateInterface.run();

//        List<Integer>ls=new ArrayList<>();
//        ls.addAll(List.of(1,2,3,4,5,6,7,8,9,10));

//        ls.forEach((c)->MathUtil.square(c));
//        ls.forEach(MathUtil::square);
//        System.out.println();

//        Calculator c=(a,b)->a*b;
//        System.out.println(c.calculate(1,3));
//        StaticMethodReference ref=new StaticMethodReference();
//        Calculator c=ref::sum;
//        System.out.println(c.calculate(2,7));

        ConstructorMethodReference.run();
    }
}