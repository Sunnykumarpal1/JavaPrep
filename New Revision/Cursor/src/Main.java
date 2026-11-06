import java.security.KeyPair;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//      Enumeration : - it's used to iterate on the leggacy class like vector and Hashtable
        Vector<Integer>vec=new Vector<>();
        vec.add(1);
        vec.add(2);
        vec.add(3);
        vec.add(4);

        Enumeration<Integer>ele=vec.elements();
//        while(ele.hasMoreElements()){
//            System.out.println(ele.nextElement());
//        }

        Hashtable<String,String>mp=new Hashtable<>();
        mp.put("Sunny","Software Engineer , Backend Engineer , Java Engineer");
        mp.put("Aryan", "Business Analyst");
        mp.put("Kushi", "Business Analyst");
        Enumeration<String>enumHt = mp.elements();

        while(enumHt.hasMoreElements()){
            String key= enumHt.nextElement();
            System.out.println(key+" "+mp.get(key));
        }

//        Stack<Integer>st=new Stack<>();
//        st.add(1);
//        st.add(2);
//        st.add(3);
//        Enumeration<Integer>stEnum=st.elements();
//
//        while(stEnum.hasMoreElements()){
//            System.out.println(stEnum.nextElement());
//        }

        
    }
}