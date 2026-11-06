package list;

import java.util.Vector;

public class VectorPractice {
    public static void run(){
        Vector<Integer>vec=new Vector<>();
        vec.addElement(1);
        vec.addElement(2);
        System.out.println(vec.firstElement());
        System.out.println(vec.lastElement());
    }
}
