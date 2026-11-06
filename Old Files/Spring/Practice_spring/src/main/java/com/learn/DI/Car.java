package Spring.Practice_spring.src.main.java.com.learn.DI;

import com.prac.Enginee1;
import org.springframework.stereotype.Component;

//@Component
public class Car {
    private Enginee enginee;

    public  Car(){

    }
//    constructor injection
 /*
 public Car(Enginee enginee){
        this.enginee = enginee;
    }
*/
//   setter injection
    public void setEnginee(Enginee enginee) {
        this.enginee = enginee;
    }


    public void getEngineeType(){
        System.out.println(enginee.geteType());
    }


}
