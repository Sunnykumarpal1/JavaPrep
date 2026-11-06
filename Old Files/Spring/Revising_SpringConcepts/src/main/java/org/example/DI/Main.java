package org.example.DI;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("we are in start of main method");
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println("after the application context");
        Car car = (Car)context.getBean("car");
        context.close();
        System.out.println(car);
    }
}
