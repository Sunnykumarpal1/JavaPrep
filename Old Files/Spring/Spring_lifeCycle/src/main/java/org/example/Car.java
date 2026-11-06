package org.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("myCar")
public class Car implements InitializingBean, DisposableBean {
    @Value("BMW")
    String cName;

    @Value("10000")
    Long price;

    @Value("Racing")
    String carCategory;

    public Car() {

    }

    public String getcName() {
        return cName;
    }

    public String getCarCategory() {
        return carCategory;
    }

    public Long getPrice() {
        return price;
    }

    @PostConstruct
    public void init(){
        System.out.println("We are here in init method");
    }

    @PreDestroy
    public void remove(){
        System.out.println("now we are in destroy method");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("we are in afterProperties set");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("wer are in dispoalbe bean");
    }

    public  void myInitMethod(){
        System.out.println("we are in custome init method");
    }

    public void myDestroyMethod(){
        System.out.println("we are in custome destroy method");
    }
}
