package Collection;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetInterfaceDemo {
    public static void main(String[] args) {
        // Hashset :- just unique
        Set<Integer>st=new HashSet<>();
        st.add(31);
        st.add(13);
        st.add(12);
        st.add(15);
        st.add(1);
        System.out.println(st);
        
        // LinedList :- uniqe and remains in the order

          Set<Integer>Lst=new LinkedHashSet();
            Lst.add(31);
            Lst.add(13);
            Lst.add(12);
            Lst.add(15);
            Lst.add(1);
        System.out.println(Lst);

        // TreeSet:- unique and sorted 
        Comparator<Integer>cmp=(a,b)->{
            return b-a;
        };

        TreeSet<Integer>tset=new TreeSet<>(cmp);
        tset.add(9);
        tset.add(1);
        tset.add(3);
         tset.add(1);
        tset.add(3);
        System.out.println(tset);
    }
}
