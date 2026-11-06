package com.innerclasses;

// this is a member inner class
public class OuterClass {
    int x=2;
    static int y=5;
    public  class innerClass{
       public int z=3;
       public void display(){
            System.out.println("inner class feild : x "+x+" static y :- "+y + " Inner Class z "+z);
        }
    }
}
