package Collection;

public class Student implements Comparable<Student>  {
   public int id;
    public int age;
    public String name;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public Student(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }


    @Override
    public String toString() {
        return "Student [id=" + id + ", age=" + age + ", name=" + name + "]";
    }
    @Override
    public int compareTo(Student o) {
        // TODO Auto-generated method stub
      return this.id-o.id;
    }

    
}
