package Spring.Practice_spring.src.main.java.com.learn.DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =new AnnotationConfigApplicationContext(Start.class);
        Car myPetrol = (Car)context.getBean("myPetrol");
        Car myDiesel = (Car)context.getBean("myDiesel");

        myPetrol.getEngineeType();
        myDiesel.getEngineeType();


    }
}
