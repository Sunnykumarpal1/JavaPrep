package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(Start.class);
        System.out.println("staretd");
        Car myCar = (Car)context.getBean(Car.class);
        System.out.println("we have successfully learned the lifecycle");
        context.close();
    }
}
