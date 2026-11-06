package list;

import java.util.List;
import java.util.Stack;

public class StackPractice {
    public static void run(){
        Stack<Integer> st=new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println(st.pop());
        st.add(5);
        System.out.println(st.peek());
        System.out.println(st);
        System.out.println(st.search(1));
        System.out.println(st.contains(2));
        st.set(0,7);

        System.out.println(st.empty());

        System.out.println(st);

        System.out.println(st.size());  // Number of elements
        System.out.println(st.isEmpty()); // Checks if empty
        System.out.println(st.get(0));  // Gets element at index 0

        st.remove(Integer.valueOf(2));  // Removes the value 2
        st.clear();                     // Removes all elements
    }
}
