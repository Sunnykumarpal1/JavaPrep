import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample {
    public static void main(String[] args) {
        /*
         this interface is subinterface of iterator and  is only used for list  types like ArrayList,LinkedList
         here we have many methods like moving forward and backard and getting the previous and next elements
        Method	        Description
        hasNext()	    Checks if next element exists
        next()   	    Returns the next element
        hasPrevious()	Checks if previous element exists
        previous()	    Returns the previous element
        add(E e)	    Inserts element into the list
        set(E e)	    Replaces the last element returned
        remove()	    Removes last returned element
        nextIndex()	    Returns index of the element that would be returned by next()
        previousIndex()	Returns index of the element that would be returned by previous()

         */
        List<Integer>ls=new ArrayList<>();
          ls.add(5);
        ls.add(3);
        ls.add(9);
        ls.add(1);
        ls.add(91);
        ls.add(18);
        ListIterator<Integer> listIterator = ls.listIterator();
        while (listIterator.hasNext()) {
            int ele=listIterator.next();
            if(ele==1){
                listIterator.set(100);
            }
            if(ele==3){
                listIterator.remove();
            }
        }
        System.out.println(ls);
       System.out.println("reverse");
        while(listIterator.hasPrevious()){
            int ele=listIterator.previous();
            System.out.println(ele);
        }
        System.out.println(ls);
    }
}
