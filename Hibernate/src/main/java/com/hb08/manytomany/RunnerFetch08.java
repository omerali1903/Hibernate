package com.hb08.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch08 {
    public static void main(String[] args) {

        Configuration config=new Configuration().configure().addAnnotatedClass(Student08.class)
                .addAnnotatedClass(Course08.class);

        SessionFactory sf =config.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx= session.beginTransaction();

        Student08 student=session.get(Student08.class,1001);
        System.out.println(student.getCourseList());

        Course08 course=session.get(Course08.class,11);
        System.out.println(course.getStudentList());

        tx.commit();
        session.close();
        sf.close();



    }
}
