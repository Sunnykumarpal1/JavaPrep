package Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class ListDemo {
    public static void main(String[] args) {
   /* 


        List<Integer>ls=new ArrayList<>();
        ls.add(1);
        ls.add(13);
        ls.add(15);
        ls.get(1);
        Collections.reverse(ls);
        System.out.println(ls);

        /* Linked list */

        List<Integer>ll=new LinkedList<>();
        ll.add(1);
        ll.add(321);
        ll.add(13);
        ll.add(11);

        Collections.sort(ll);
        Collections.reverse(ll);
        System.out.println(ll);
        System.out.println(ll.get(3));
        
        
        /* Vector */

        List<Integer>vec=new Vector<>();
        vec.add(93);
        vec.add(23);
        vec.add(13);
        vec.add(33);
        vec.add(31);
        Collections.sort(vec);
        vec.remove(0);
       System.out.println( vec.contains(23));
       /* Stack */

       Stack<Integer>st=new Stack<>();
       st.push(1);
       st.push(61);
       st.push(41);
       st.push(14);
       st.push(13);
       st.push(21);
       st.push(11);
       System.out.println(st.peek());
       while(!st.empty()){
           int ele=st.peek();
           st.pop();
           System.out.println(ele);
       }


    }
}
