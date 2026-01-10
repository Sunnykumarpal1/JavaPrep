package SerlizableAndDeserlizable;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Serial {
    public static void main(String[] args) {
        Li
        try {
            // serilizaiton
            Student st = new Student("Sunny", "Bangalore", "Sunny@gmail.com", 23);
            Student st2=new Student("Aryan", "Bangalore", "Aryan@gmail.com", 18);
            FileOutputStream fos = new FileOutputStream("file.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            /*
             * FileOutputStream → This is the low-level stream that writes bytes to a file.
             * ObjectOutputStream → This is a high-level stream that knows how to convert
             *                       Java objects into bytes (serialization).
             */
            List<Student>ls=new ArrayList<>();
            ls.add(st2);
            ls.add(st);
            oos.writeObject(ls);
            // oos.writeObject(st2);
            oos.close();
            fos.close();
            System.out.println("heere the object is serialized");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
