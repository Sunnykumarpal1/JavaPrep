package org.example;

public class Truck {
    public evSeriesEngine engine;

    public  Truck(){

    }
    public Truck(evSeriesEngine engine) {
        this.engine = engine;
    }


    public evSeriesEngine getEngine() {
        return engine;
    }

    public void setEngine(evSeriesEngine engine) {
        this.engine = engine;
    }
    public  void Drive(){
        System.out.println("we are in drive method");
        engine.start();
    }

}
