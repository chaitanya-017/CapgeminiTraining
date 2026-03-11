package ObjectReadAndWrite;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectWrite {
    public static void main(String[] args) {
        Student s = new Student(1,"Ion");
        Student s1 = new Student(2,"Chaits");
        Student s2 = new Student(1,"Manas");

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/studentObj.txt",true))){
            out.writeObject(s);
            out.writeObject(s1);
            out.writeObject(s2);
            System.out.println("Objects saved successfully");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
