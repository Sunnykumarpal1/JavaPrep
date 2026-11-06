package org.example.DI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("petrolEnginee")
public class PetrolEnginee implements  Enginee {
    String eType;
    PetrolEnginee(@Value("petrol") String type){
        eType=type;
    }

    @Override
    public void start() {
        System.out.println("We are in the Petrol start Enginee");
    }
    @Override
    public String toString() {
        return "PetrolEnginee{" +
                "eType='" + eType + '\'' +
                '}';
    }
}
