package org.example;

public class evSeriesEngine implements Engine {
    public evSeriesEngine(){
        System.out.println("we are in costructor of ev");
    }
    @Override
    public void start() {
        System.out.println("we are in the evSeries Engine");
    }

    @Override
    public String toString() {
        return "evSeriesEngine{}";
    }
}
