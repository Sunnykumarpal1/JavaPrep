import java.util.Enumeration;
import java.util.Vector;

public class Start {
   public static void main(String[] args) {
      Vector<Integer>vec=new Vector<>();
      vec.add(1);
      vec.add(3);
      vec.add(9);
      Enumeration<Integer>MyEnum=vec.elements();
   }
}
