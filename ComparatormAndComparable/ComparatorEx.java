package ComparatormAndComparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Employee  {
    public String name;
    public int age;
    public int id;
    
    public Employee(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", age=" + age + ", id=" + id + "]";
    }    
}

public class ComparatorEx {
    public static void main(String[] args) {
        List<Employee>ls=new ArrayList<>();
        Employee e1=new Employee("Sunny", 17, 2);
        Employee e2=new Employee("Kushi", 20, 3);
        Employee e3=new Employee("Aryan", 13, 1);

        ls.add(e3);
        ls.add(e1);
        ls.add(e2);
        Comparator<Employee>sortAge=new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                // TODO Auto-generated method stub
              return o1.age-o2.age;
            }
        };

        Comparator<Employee>sortName=new Comparator<Employee>() {

            @Override
            public int compare(Employee o1, Employee o2) {
                // TODO Auto-generated method stub
                return o1.name.compareTo(o2.name);
            }
            
        };

        System.out.println("sort by age");
        Collections.sort(ls,sortAge);
        for(Employee e:ls){
            System.out.println(e);
        }

        System.out.println("sort by name");
        Collections.sort(ls,sortName);
        for(Employee e:ls){
            System.out.println(e);
        }


    }
}
