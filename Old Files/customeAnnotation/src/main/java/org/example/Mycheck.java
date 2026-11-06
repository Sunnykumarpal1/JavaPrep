package org.example;

import java.util.Objects;

@Check
public class Mycheck {
  public String name;
  public  int age;

    public Mycheck() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mycheck mycheck = (Mycheck) o;
        return age == mycheck.age && Objects.equals(name, mycheck.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
