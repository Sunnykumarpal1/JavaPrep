package com.innerclasses;

// this is Static Inner  Class
public class Outer {
    int x=4;
    static int y=5;
    public  static  class inner{
        public void display(){
            System.out.println( "static y "+y);
        }
    }
}

