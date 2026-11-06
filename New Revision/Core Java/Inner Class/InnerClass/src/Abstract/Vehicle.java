package Abstract;

public abstract class Vehicle {
    int seats;
    static int wheels;

    public Vehicle(){
        seats=5;
        wheels=4;
    }
    public static int getWheels(){
        return  wheels;
    }
    abstract  public void start();
    public void stop(){
        System.out.println("Vehicle is Stopped");
    }
}
