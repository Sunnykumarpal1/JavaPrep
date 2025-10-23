package com.prac;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start1 {
    public static void main(String[] args) {
         BeanP
        ApplicationContext context=new AnnotationConfigApplicationContext(Config1.class);
        Car car = context.getBean(Car.class);
        System.out.println(car.enginee.Etype);

    }
}
