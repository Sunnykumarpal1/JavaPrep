package com.learn.DI;

public class PetrolEnginee implements Enginee{
    private String eType;

    public PetrolEnginee(String etype){
        this.eType=etype;
    }

    @Override
    public String geteType() {
        return eType;
    }
}
