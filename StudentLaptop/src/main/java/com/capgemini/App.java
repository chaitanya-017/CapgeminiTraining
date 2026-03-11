package com.capgemini;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import com.capgemini.dao.StudentDAO;
import com.capgemini.dao.StudentDAOImpl;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("jpa-example");

        EntityManager em = emf.createEntityManager();

        StudentDAO dao = new StudentDAOImpl(em);

        System.out.println("Saving Data...");
        dao.saveData();

        dao.fetchLaptopFromStudent(1);
        dao.fetchStudentFromLaptop(1);

        dao.updateLaptopBrand(1, "Lenovo");
        dao.updateStudentCourse(1, "Computer Science");

        dao.changeLaptopForStudent(1, 4);
        dao.removeLaptopFromStudent(2);
        dao.deleteStudentAndLaptop(3);

        em.close();
        emf.close();

        System.out.println("Operations Completed.");
    }
}
