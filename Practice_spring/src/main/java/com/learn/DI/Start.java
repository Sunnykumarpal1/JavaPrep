package com.learn.DI;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.naming.Name;

@Configuration
@ComponentScan("com.learn.DI")
public class Start {
    @Bean
    public Enginee petrolEnginee() {
        return new PetrolEnginee("E4 - Engine");
    }

    @Bean
    public Enginee dieselEnginee() {
        return new DieselEnginee("E6 - Enginee");
    }

//    constructor injection
 /*   @Bean("myDiesel")
    public  Car getDieselCar(){
        return new Car( dieselEnginee());
    }

    @Bean("myPetrol")
    public Car getPetrolCar(){
        return new Car(petrolEnginee());
    }
*/

//    setter injection
    @Bean("myDiesel")
    public Car getDieselCar(){
        Car car1 = new Car();
        car1.setEnginee(dieselEnginee());
        return car1;
    }

    @Bean("myPetrol")
    public Car getPetrolCar(){
        Car car2=new Car();
        car2.setEnginee(petrolEnginee());
        return car2;
    }
}
