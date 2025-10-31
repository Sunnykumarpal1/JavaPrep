package Spring.SpringCore.src.main.java.org.example.looseCoupling;

public class Traveller {
    private  Vehicle vh;
//    constructor injection
    public Traveller(Vehicle vh){
        this.vh=vh;
    }
    public void StartDriving(){
        vh.Drive();
    }
}
