package org.example.DI;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.DI")
public class MyConfig {
    @Bean
   public MyCustomeBeanProcessor myCustomeBeanProcessor(){
        return new MyCustomeBeanProcessor();
    }

    @Bean(initMethod = "myInitMethod",destroyMethod = "myDestroyMehtod")
    public EvEnginee myEvEnginee(){
        return new EvEnginee("EV");
    }
}
