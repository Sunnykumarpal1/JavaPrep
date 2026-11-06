package Spring.SpringCore.src.main.java.org.example.DI;

public class Car {
   private Engine engine;
    /*
//    constructor dependency
    public  Car(Engine engine){
        this.engine=engine;
    }

//    setter dependency
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

     */
    public void StartDriving(){
        System.out.println("we are starting to drive");
        engine.start();
    }


}
