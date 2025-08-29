package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext apx= new  ClassPathXmlApplicationContext("Beans.xml");
        Car car = apx.getBean("car", Car.class);
        Car car1=apx.getBean(Car.class);
        car.StartDriving();

//        now it's depricated but this is how thier we used to implement and iti's used to give lazy loading
//        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("beans.xml"));


        System.out.println( car.hashCode());
        System.out.println(car1.hashCode());


    }
}
