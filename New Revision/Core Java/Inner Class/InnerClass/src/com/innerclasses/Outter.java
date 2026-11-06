package com.innerclasses;

public class Outter {
    int number=0;
    public Outter() {
        number=10;
    }

    public void display(){
        class InnerLocal{
            public void print(){
                System.out.println("the value of number is "+number);
            }
        }
    }
}
