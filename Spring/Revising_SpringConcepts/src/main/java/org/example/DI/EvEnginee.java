package org.example.DI;

public class EvEnginee implements Enginee{
    String eType;
    public EvEnginee(String type){
        this.eType=type;
    }
    @Override
    public void start() {
        System.out.println("We are in ev enginee");
    }

    public String geteType() {
        return eType;
    }

    @Override
    public String toString() {
        return "EvEnginee{" +
                "eType='" + eType + '\'' +
                '}';
    }
    public void myInitMethod(){
        System.out.println("We are in init methods of ev");
    }
    public void myDestroyMehtod(){
        System.out.println("We are in destryo method of ev");
    }
}
