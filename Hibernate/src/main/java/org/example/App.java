package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {

    public static void main(String[] args) {

        Configuration configuration =
                new Configuration()
                        .configure()
                        .addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        // ================= INSERT CODE (OLD) =================
        /*
        Person pr = new Person();
        pr.setName("Chaitanya");
        session.persist(pr);
        */

        // ================= DELETE CODE (OLD) =================
        /*
        Person personToDelete = session.get(Person.class, 3);

        if (personToDelete != null) {
            session.remove(personToDelete);
            System.out.println("Person with ID 3 deleted.");
        } else {
            System.out.println("Person with ID 3 not found.");
        }
        */

        // ================= UPDATE CODE (OLD) =================
        /*
        Person personToUpdate = session.get(Person.class, 2);

        if (personToUpdate != null) {
            personToUpdate.setName("Chaitanya Garg");
            System.out.println("Person with ID 2 updated.");
        } else {
            System.out.println("Person with ID 2 not found.");
        }
        */
        // ================= VIEW CODE (NEW) =================

        List<Person> persons = session.createQuery("from Person", Person.class).list();

        for (Person p : persons) {
            System.out.println(p);
        }

        transaction.commit();
        session.close();
        sessionFactory.close();

        System.out.println("View operation completed!");
    }
}