package com.capgi.dao;

import com.capgi.entity.Student;
import com.capgi.repository.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public void save(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(student);
        tx.commit();
        session.close();
    }

    @Override
    public Student getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }

    @Override
    public List<Student> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Student> list = session.createQuery("from Student", Student.class).list();
        session.close();
        return list;
    }

    @Override
    public void update(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.merge(student);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Student student = session.get(Student.class, id);
        if (student != null) {
            session.remove(student);
        }
        tx.commit();
        session.close();
    }

    @Override
    public List<Student> sortByDept() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Student> list = session
                .createQuery("from Student order by dept", Student.class)
                .list();
        session.close();
        return list;
    }

    @Override
    public List<Student> sortByAge() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Student> list = session
                .createQuery("from Student order by age", Student.class)
                .list();
        session.close();
        return list;
    }
}