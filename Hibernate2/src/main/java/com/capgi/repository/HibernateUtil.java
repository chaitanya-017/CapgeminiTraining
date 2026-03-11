package com.capgi.repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.capgi.entity.Student;

public class HibernateUtil {

    private static final SessionFactory sessionFactory =
            new Configuration()
                    .configure()
                    .addAnnotatedClass(Student.class)
                    .buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
