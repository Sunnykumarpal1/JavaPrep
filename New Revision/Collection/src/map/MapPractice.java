package map;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class MapPractice {
    public static void run(){

        Map<String,Integer>mp=new HashMap<>();
        mp.put("Sunny",24);
        mp.put("Kushi",21);
        mp.put("Aryan",18);
        mp.put("Arush",1);
        mp.put("Ansh",12);
        mp.put(null,1);
//       mp.forEach((k,v)-> System.out.println("key "+k+" value "+v));
//       for(Map.Entry<String,Integer>e:mp.entrySet()){
//           System.out.println(e.getKey()+" "+e.getValue());
//       }
        System.out.println(mp.containsValue(8));
        mp.entrySet().forEach((e-> System.out.println(e.getKey()+" "+e.getValue())));
}
}
