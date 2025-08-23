package org.example.looseCoupling;

public class Traveller {
    private  Vehicle vh;
    public Traveller(Vehicle vh){
        this.vh=vh;
    }
    public void StartDriving(){
        vh.Drive();
    }
}
