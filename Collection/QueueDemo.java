package Collection;

import java.util.*;

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


        PriorityQueue<Student>pq2=new PriorityQueue<>((a,b)->b.getId()-a.getId());
        pq2.add(s1);
        pq2.add(s2);
        System.out.println(pq2);

        /* DequeuArray */
        ArrayDeque<Integer>aDq=new ArrayDeque<>();
        aDq.push(1);
        aDq.push(2);
        aDq.push(5);
        aDq.push(9);
        aDq.offerFirst(3);
        aDq.offerFirst(10);
        System.out.println(aDq);


        Integer peek = aDq.peek();
        System.out.println("peek"+peek);
        System.out.println(aDq);



        Integer pF = aDq.pollFirst();
        System.out.println("pollFirst"+ pF);
        System.out.println(aDq);
        Integer pL = aDq.pollLast();
        System.out.println("pollLast"+pL);





    }
}
