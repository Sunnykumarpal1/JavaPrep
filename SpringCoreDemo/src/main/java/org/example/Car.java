package org.example;


public class Car {
    private Engine engine;

    public  Car(){
        System.out.println("we are in consttucotr of car");
    }
//    constructor dependency
    public  Car(Engine engine){
        System.out.println("we are in constructor of car");
        this.engine=engine;
    }

//    setter dependency
    public void setEngine(Engine engine) {
        System.out.println("we are in the setter of car");
        this.engine = engine;
    }


    public void StartDriving(){
        System.out.println("we are starting to drive");
        engine.start();
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                '}';
    }
}
