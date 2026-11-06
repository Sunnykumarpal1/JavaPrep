package org.example;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        //        This can be used when we have the annotation on the class but if we have annotation on the field then it won't work
        /*
        Demo d=new Demo();
        Class<? extends Demo> aClass = d. getClass();
        MyAnno an = aClass.getAnnotation(MyAnno.class);
        System.out.println(an.name()+" "+an.age());
        */

        Class<Demo> d = Demo.class;
        Method[] methods = d.getDeclaredMethods();
        for(Method m:methods){
            if(m.isAnnotationPresent(MyAnno.class)){
                MyAnno an = m.getAnnotation(MyAnno.class);
                System.out.println(" Name "+ an.name());
                System.out.println(" Age "+an.age());
            }
        }


    }
}
