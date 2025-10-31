package Spring.SpringCoreDemo.src.main.java.org.example;

public class kSeriesEngine implements Engine{
    public kSeriesEngine(){
        System.out.println("we are in the constructor of kseries ");
    }
    @Override
    public void start() {
        System.out.println("you are in  the kseries enginee");
    }
}
