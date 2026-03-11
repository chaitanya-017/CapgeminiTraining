package com.capgi.dao;

import com.capgi.entity.Student;
import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student getById(int id);

    List<Student> getAll();

    void update(Student student);

    void delete(int id);

    List<Student> sortByDept();

    List<Student> sortByAge();
}