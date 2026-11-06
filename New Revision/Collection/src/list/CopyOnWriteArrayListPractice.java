package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListPractice {
    public static void run(){

        CopyOnWriteArrayList<Integer> arr=new CopyOnWriteArrayList<>();
        arr.addAll(List.of(1,2,34,5,6,78));
        Iterator<Integer> it=arr.iterator();

        arr.add(99);
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
