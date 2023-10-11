package com.hb11.criteriaapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Random;

public class RunnerSave11 {
    public static void main(String[] args) {

        Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student11.class);

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Random random =new Random();

        for (int i=1;i<=20;i++){
            Student11 student=new Student11();
            student.setName("Student "+i);
            student.setMathGrade(random.nextInt(101));
            session.save(student);
            //session.persist(student); ---> save ile ayni islemi yapar, objeyi data basede kalici hale getirir.
        }




        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
