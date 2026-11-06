package Spring.Practice_spring.src.main.java.com.prac;


public abstract  class Enginee1 {
   public String Etype;

    public Enginee1() {

    }

    public  void printType(){
       System.out.println("we have a enginee type as "+" "+Etype);
   }

    public void setEtype(String etype) {
        Etype = etype;
    }
}
