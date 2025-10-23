package com.learn.DI;

public class DieselEnginee implements Enginee{
    private String  eType;

    public  DieselEnginee(String type){
        this.eType=type;
    }
    @Override
    public String geteType() {
        return eType;
    }
}
