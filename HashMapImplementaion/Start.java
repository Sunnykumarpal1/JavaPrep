package HashMapImplementaion;

public class Start {
    public static void main(String[] args) {
        MyHashMap<Integer,String>mp=new MyHashMap<>();
        mp.put(1,"Sunny");
        mp.put(2,"Kushi");
        mp.put(3,"Aryan");
        mp.put(4,"Arush");

        System.out.println(mp.get(2));
        System.out.println(mp.get(1));
        System.out.println(mp.get(3));
        System.out.println(mp.get(4));
        mp.remove(3);
        System.out.println(mp.get(3));
        System.out.println(mp.get(2));
    }
}
