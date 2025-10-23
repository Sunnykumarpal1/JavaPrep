package com.prac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {


    public Enginee1 enginee;
//
//    public Car(Enginee1 enginee) {
//        this.enginee = enginee;
//    }

    public void printTypeOfEnginee(){
       enginee.printType();
    }

    @Autowired
    @Qualifier("pEnginee")
    public void setEnginee(Enginee1 enginee) {
        this.enginee = enginee;
    }

    @Override
    public String toString() {
        return "Car{" +
                "enginee=" + enginee +
                '}';
    }
}
