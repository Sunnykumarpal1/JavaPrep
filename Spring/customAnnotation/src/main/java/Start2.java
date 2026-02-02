import java.lang.reflect.Method;

public class Start2 {
    public static void main(String[] args) {
        Employee emp=new Employee();
        Class<?>employee=emp.getClass();
        for(Method m:employee.getDeclaredMethods()){
            if(m.isAnnotationPresent(executeMethod.class)){
                executeMethod em=m.getAnnotation(executeMethod.class);
                System.out.println(em);
            }
        }
    }
}
