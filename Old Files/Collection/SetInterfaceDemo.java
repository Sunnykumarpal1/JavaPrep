package Collection;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetInterfaceDemo {
    public static void main(String[] args) {
        // Hashset :- just unique
//        Set<Integer>st=new HashSet<>();
//        st.add(31);
//        st.add(13);
//        st.add(12);
//        st.add(15);
//        st.add(1);
//        System.out.println(st);
//
 /*       HashSet<Person>st=new HashSet<>();
        Person s1=new Person(23,"Sunny","Sidney");
        Person s2=new Person(20,"Kushi","LA");
        Person s3=new Person(18,"Aryan","Bangalore");
        Person s4=new Person(18,"Aryan","Bangalore");

        st.add(s1);
        st.add(s2);
        st.add(s3);
        st.add(s4);
        System.out.println(st);
*/

        
//        // LinedList :- uniqe and remains in the order
//
//          Set<Integer>Lst=new LinkedHashSet();
//            Lst.add(31);
//            Lst.add(13);
//            Lst.add(12);
//            Lst.add(15);
//            Lst.add(1);
//        System.out.println(Lst);

        /*

        LinkedHashSet<Person>lHs=new LinkedHashSet<>();
        Person s1 = new Person(23, "Sunny", "Sidney");
        Person s4 = new Person(18, "Aryan", "Bangalore");

        Person s2 = new Person(20, "Kushi", "LA");
        Person s3 = new Person(18, "Aryan", "Bangalore");

        lHs.add(s4);
        lHs.add(s1);
        lHs.add(s2);
        lHs.add(s3);

        System.out.println(lHs);


         */
//
//        // TreeSet:- unique and sorted
//        Comparator<Integer>cmp=(a,b)->{
//            return b-a;
//        };
//
//        TreeSet<Integer>tset=new TreeSet<>(cmp);
//        tset.add(9);
//        tset.add(1);
//        tset.add(3);
//         tset.add(1);
//        tset.add(3);
//        System.out.println(tset);


//        TreeSet<Person>ts=new TreeSet<>((a,b)->b.getAge()-a.getAge());
        TreeSet<Person>ts=new TreeSet<>();
        Person s1 = new Person(23, "Sunny", "Sidney");
        Person s4 = new Person(18, "Aryan", "Bangalore");

        Person s2 = new Person(20, "Kushi", "LA");
        Person s3 = new Person(18, "Aryan", "Bangalore");

        ts.add(s4);
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.
        System.out.println(ts);

    }
}
