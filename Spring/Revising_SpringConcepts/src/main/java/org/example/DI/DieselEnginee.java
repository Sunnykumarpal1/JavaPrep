package org.example.DI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("dieselEnginee")
@Primary
public class DieselEnginee implements  Enginee {
    String eType;

    public DieselEnginee(@Value("diesel") String eType) {
        this.eType = eType;
    }

    @Override
    public void start() {
        System.out.println("Hey we are in Diesel Enginee");
    }

    @Override
    public String toString() {
        return "DieselEnginee{" +
                "eType='" + eType + '\'' +
                '}';
    }
}
