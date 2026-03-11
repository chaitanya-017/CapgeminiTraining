package com.capgi.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String dept;
    private int age;
    private double marks;

    public Student() {}

    public Student(String name, String dept, int age, double marks) {
        this.name = name;
        this.dept = dept;
        this.age = age;
        this.marks = marks;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDept() { return dept; }
    public void setDept(String dept) { this.dept = dept; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public double getMarks() { return marks; }
    public void setMarks(double marks) { this.marks = marks; }
}
