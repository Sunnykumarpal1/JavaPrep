package Spring.SpringCore.src.main.java.org.example.looseCoupling;

public class Car implements  Vehicle{
    @Override
    public void Drive() {
        System.out.println("we are driving car");
    }
}
