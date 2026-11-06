import Abstract.Car;
import Abstract.Vehicle;
import com.innerclasses.Outer;
import com.innerclasses.OuterClass;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        to create an object of inner class s since this is member inner class
//        firest we  need to create the objcet of Outter class than inner class object
        OuterClass outerClass=new OuterClass();
        OuterClass.innerClass inClass=outerClass.new innerClass();
        inClass.display();


//        so static inner class can only access the stattic fields of the outter class
//        Outer outer=new Outer();
//        here we can direclty access the inner class without creating an object of outter
//        Outer.inner inner=new Outer.inner();
//        inner.display();

        Car car=new Car();
        car.start();
        car.stop();
        System.out.println(Car.getWheels());
    }
}