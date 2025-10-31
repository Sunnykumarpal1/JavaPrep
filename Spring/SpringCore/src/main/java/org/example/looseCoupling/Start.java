package Spring.SpringCore.src.main.java.org.example.looseCoupling;
public class Start {
    public static void main(String[] args) {
        Vehicle car=new Car();
        Vehicle bike=new Bike();
        Traveller t1=new Traveller(car);
        Traveller t2=new Traveller(bike);
        t1.StartDriving();
        t2.StartDriving();
    }
}
