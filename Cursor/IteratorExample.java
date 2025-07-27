import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {
    private static Iterator<Integer> iterator;

    public static void main(String[] args) {
        /* Iterator interfaces is used for traversal of all the collection classes 
          
        Methods:- 
                  hasNext();
                  next();
                  remove(): when this method is used it remove the element on which next() method is applied
                           if this is used before the the next() method then it will throw an exception

        */
        List<Integer>ls=new ArrayList<>();
        ls.add(5);
        ls.add(3);
        ls.add(9);
        ls.add(1);
        ls.add(91);
        ls.add(18);
        Iterator<Integer>it = ls.iterator();
        while(it.hasNext()){
            int ele=it.next();
            if(ele==1){
                it.remove();
            }
            
        }
        System.out.println(ls);
        
    }
}
