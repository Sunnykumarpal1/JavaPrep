package org.example.DI;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws Exception {
//        Car c1=new Car(new kSeriesEngine());
//        c1.setEngine(new evEngine());
//        c1.StartDriving();

//
//
//       java reflection api
        Class<?> c1 = Class.forName("org.example.Car");
        Object obj = c1.newInstance();
        Car c=(Car) obj;
        Field field=c1.getField("engine");
        field.setAccessible(true);
        field.set(c,new evEngine());
        c.StartDriving();

    }
}
