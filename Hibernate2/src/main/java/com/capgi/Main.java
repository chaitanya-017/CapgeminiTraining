package com.capgi;

import com.capgi.dao.StudentDAO;
import com.capgi.dao.StudentDAOImpl;
import com.capgi.entity.Student;

public class Main {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAOImpl();

        // Insert
        dao.save(new Student("Chaitanya", "CSE", 22, 85));
        dao.save(new Student("Rahul", "ECE", 21, 90));

        // Fetch All
        dao.getAll().forEach(System.out::println);

        // Sort By Age
        dao.sortByAge().forEach(System.out::println);
    }
}