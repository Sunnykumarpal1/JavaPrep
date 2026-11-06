package MethodReference;

import java.util.function.Supplier;

public class ConstructorMethodReference {
   public static  void  run(){
       Supplier<Student>sup =Student::new;
       Student student = sup.get();
       System.out.println(student);
   }
}
