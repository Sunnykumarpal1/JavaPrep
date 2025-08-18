package HashMapImplementaion;

public class Entity<K,V> {
    K key;
    V value;
    Entity<K,V>next;
    Entity(K k,V v){
        key=k;
        value=v;
        next=null;
    }
}
