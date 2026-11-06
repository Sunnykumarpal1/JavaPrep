package org.example.DI;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Primary;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

public class MyCustomeBeanProcessor implements    BeanPostProcessor {
     public  Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
         System.out.println("We are in"+beanName+" post process before init ");
         return bean;
    }

    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("We are in"+beanName+" post process  after init ");
        return bean;
    }
}
