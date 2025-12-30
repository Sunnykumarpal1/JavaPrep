package HashMapImplementaion;

import java.util.ArrayList;

public class MyHashMap<K,V> {
   int capacity=16;
   Entity<K,V>buckets[];
   MyHashMap(){
    buckets=new Entity[capacity];
   }
   public int GetIndex(K key){
      return key.hashCode()%capacity;
   }

   public void put(K k,V v){
      int ind=GetIndex(k);
      Entity<K,V>head=buckets[ind];
      while(head!=null){
         if(head.key.equals(k)){
            head.value=v;
            return ;
         }
         head=head.next;
      }
    //   adding new element
      Entity<K,V>newElement=new Entity(k,v);
      newElement.next=buckets[ind];
      buckets[ind]=newElement;
   }

   public V get(K k){
      int ind=GetIndex(k);
      Entity<K,V>head=buckets[ind];
      while(head!=null){
         if(head.key.equals(k)){
            return head.value;
         }
         head=head.next;
      }
      return null;
   }
    public void remove(K k){
        int ind = GetIndex(k);
        Entity<K, V> head = buckets[ind];
        Entity<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(k)) {
                // Node found
                if (prev == null) {
                    // Node is head
                    buckets[ind] = head.next;
                } else {
                    // Node is in middle or end
                    prev.next = head.next;
                }
                return; // Removed successfully
            }
            prev = head;
            head = head.next;
        }

   }

}
