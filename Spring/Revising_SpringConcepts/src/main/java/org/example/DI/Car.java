package org.example.DI;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("car")
public class Car implements InitializingBean, DisposableBean {
    Enginee enginee;
    @Autowired
//    using qualifier
//    public  Car(@Qualifier("dieselEnginee")Enginee enginee){
//        this.enginee=enginee;
//    }

    public  Car(Enginee enginee){
        this.enginee=enginee;
    }

    public Enginee getEnginee() {
        return enginee;
    }

    @PostConstruct
    public  void myInitMethod(){
        System.out.println("hey we are in init method of postConstruct");
    }

    @PreDestroy
    public  void myDestroyMethod(){
        System.out.println("We are in Pre destroy methode");
    }

    @Override
    public String toString() {
        return "Car{" +
                "enginee=" + enginee +
                '}';
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("WE are in destr4oy method");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("We are in initt method of afterPropertiesSet");
    }
}
