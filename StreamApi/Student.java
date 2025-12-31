import java.util.Objects;

public class Student {
    private  int age;
    private  String name;
    private  String email;
    private  String city;

    public Student() {
    }

    public Student(int age, String name, String email,String city) {
        this.age = age;
        this.name = name;
        this.email = email;
        this.city=city;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name) && Objects.equals(email, student.email) && Objects.equals(city, student.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, email, city);
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
