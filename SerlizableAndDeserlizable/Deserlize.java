package SerlizableAndDeserlizable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class Deserlize {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("file.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Student>students  = (List<Student>) ois.readObject();
            for(Student st:students){
                System.out.println(st);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
