package Collection;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
      /* Queue */
        Queue<Integer> qu = new LinkedList<>();
        qu.add(1);
        qu.add(2);
        qu.add(3);
        qu.add(4);
        qu.add(5);
        qu.add(5);
        System.out.println(qu);
        qu.remove();
        System.out.println(qu.peek());
        qu.poll();
        System.out.println(qu);

        /* Priority Queue */

        PriorityQueue<Student>pq=new PriorityQueue<>(Collections.reverseOrder());
        Student s1=new Student(1, 02, "Sunny");
        Student s2=new Student(2, 12, "Aryan");
        Student s3=new Student(3, 40, "Kushi");
        pq.add(s1);
        pq.add(s2);
        pq.add(s3);
        while(!pq.isEmpty()){
            System.out.println(pq.peek());
            pq.poll();
        }
        System.out.println(pq);

        /* DequeuArray */
        
       Queue<Integer>


    }
}
