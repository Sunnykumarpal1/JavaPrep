package org.example.tightCoupling;

//
public class Traveler {
  private Car2 c2=new Car2();
  public  void StartJourney(){
      c2.Drive();
  }

}
