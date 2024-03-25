package HW3;

import HW3.model.Student;
import HW3.connectivity.DBTransit;
import HW3.connectivity.JDBC;

public class Main {

    public static void main(String[] args) {

        DBTransit<Student> dbTransit = new DBTransit<>(new JDBC());
        Student student = new Student(1, "Lone", "Wane", 32);
        System.out.println(dbTransit.saveOrUpdate(student));
        System.out.println(dbTransit.simpleSelect());

    }
}