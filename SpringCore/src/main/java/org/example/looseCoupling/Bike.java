package org.example.looseCoupling;

public class Bike implements Vehicle {

    @Override
    public void Drive() {
        System.out.println("we are driving bike");
    }
}
