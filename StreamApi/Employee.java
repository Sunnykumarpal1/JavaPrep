public class Employee {
    private  int Deptid;
    private  String name;
    private  int Salay;

    public Employee() {
    }

    public Employee(int deptid, String name, int salay) {
        Deptid = deptid;
        this.name = name;
        Salay = salay;
    }

    public int getDeptid() {
        return Deptid;
    }

    public void setDeptid(int deptid) {
        Deptid = deptid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalay() {
        return Salay;
    }

    public void setSalay(int salay) {
        Salay = salay;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Deptid=" + Deptid +
                ", name='" + name + '\'' +
                ", Salay=" + Salay +
                '}';
    }
}
