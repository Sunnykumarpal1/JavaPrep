package Collection;

import java.util.*;

public class MapDemo {
    public static void main(String[] args)
    {
        HashMap<String,Integer>map=new HashMap<>();
        map.put("Sunny",1234);
        map.put("Aryan",3);
        map.put("Kushi",2);
        map.put("Mom",1);
        map.put(null,100);

//        print
//       1.using  forEach
//       map.forEach((k,v)-> System.out.println("key "+k+"-> value"+ v));

//      2.using entry
//        for(Map.Entry<String,Integer>m:map.entrySet()){
//            System.out.println(m.getKey()+" "+m.getValue());
//        }

//        3. using keySet
//        for(String m:map.keySet()){
//            System.out.println(m+" "+map.get(m));
//        }

//       4. using iterator
        Iterator<Map.Entry<String, Integer>> myIt=map.entrySet().iterator();
       while(myIt.hasNext()){
           Map.Entry<String,Integer>row=myIt.next();
           String key=row.getKey();
           Integer value=row.getValue();
           System.out.println(key+" "+value);
       }
//       To Check if the key exist
        if(map.containsKey("Mom")){
            System.out.println("key is present in the map");
        }

        TreeSet<Integer>st=new TreeSet<>();
        st.pollFirst();
        st.pollLast();
        st.
    }
}
