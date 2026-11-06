package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example")
public class Start {

    @Bean(initMethod = "myInitMethod",destroyMethod = "myDestroyMethod")
    public Car car(){
        return new Car();
    }
}
