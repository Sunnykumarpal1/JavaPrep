import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class EnumerationExample {
   public static void main(String[] args) {
    /*  
    Enumeration is used to iterate over the legacy classes like vector ,stack and the hashtable
   */ 
    Vector<Integer>vec=new Vector<>();
      vec.add(1);
      vec.add(3);
      vec.add(9);
      Enumeration<Integer>MyEnum=vec.elements();
      while(MyEnum.hasMoreElements()){
          System.out.println(MyEnum.nextElement());
      }

    // this is hashtable example for enumeration
     
     Hashtable<Integer,String>hs=new Hashtable<>();
     hs.put(1, "Sunny");
     hs.put(2, "Aryan");
     hs.put(3, "Kushi");

     Enumeration<Integer>MyEnum2=hs.keys();
     while(MyEnum2.hasMoreElements()){
        int myKey=MyEnum2.nextElement();
        System.out.println(myKey+" "+hs.get(myKey));
     }



   }
}
