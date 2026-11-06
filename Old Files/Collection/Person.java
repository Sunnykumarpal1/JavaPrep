package Collection;

import java.util.Objects;

public class Person implements  Comparable<Person>{
    private int age;
    private String name;
    private  String city;

    public Person() {
    }

    public Person(int age, String name, String city) {
        this.age = age;
        this.name = name;
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, city);
    }


    @Override
    public int compareTo(Person o) {
        return this.getAge()-o.getAge();
    }
}
